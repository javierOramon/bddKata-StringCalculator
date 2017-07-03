package oramon.saiyans.stringcalculator.calculate;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import cucumber.api.java.eo.Do;

import java.util.Map;
import java.util.function.BiFunction;

public class OperationFactory {

    private final ImmutableMap<String, BiFunction<Double, Double, Operation>> map;

    public OperationFactory(){
        map = ImmutableMap.<String, BiFunction<Double, Double, Operation>>builder()
                .put("+", this::buildSum)
                .put("-", this::buildSubstraction)
                .build();
    }

    private Operation buildSubstraction(double operand1, double operand2) {
        return new Substraction(operand1, operand2);
    }

    private Operation buildSum(double operand1, double operand2) {
        return new Sum(operand1, operand2);
    }

    public Operation create(String text_input) {
        Operation operation = null;
        ImmutableSet<Map.Entry<String, BiFunction<Double, Double, Operation>>> set = map.entrySet();
        for (Map.Entry<String, BiFunction<Double, Double, Operation>> entry : set) {
            if (text_input.contains(entry.getKey())){
                String text_prepared = text_input.replace(" ", "").replace(entry.getKey(), " ");
                String[] operands = text_prepared.split(" ");
                double operand1 = Double.parseDouble(operands[0].trim());
                double operand2 = Double.parseDouble(operands[1].trim());
                operation = entry.getValue().apply(operand1, operand2);
            }
        }
        return operation;
    }
}
