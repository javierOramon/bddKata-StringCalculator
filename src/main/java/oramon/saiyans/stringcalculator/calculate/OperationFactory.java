package oramon.saiyans.stringcalculator.calculate;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import oramon.saiyans.NotNegativesAllowed;

import java.util.Map;
import java.util.function.Function;

public class OperationFactory {

    private final ImmutableMap<String, Function<String, Operation>> map;
    private final int maxNumber;

    public OperationFactory(){
        map = ImmutableMap.<String, Function<String, Operation>>builder()
                .put("+", this::buildSum)
                .put("/", this::buildDivision)
                .put("-", this::buildSubstraction)
                .build();
        maxNumber = 1000;
    }

    private Operation buildDivision(String text_input) {
        String text_prepared = text_input.replace(" ", "").replace("/", " ");
        String[] operands = text_prepared.split(" ");
        double operand1 = convertToNumber(operands[0]);
        double operand2 = convertToNumber(operands[1]);
        return new Division(operand1, operand2);
    }

    private Operation buildSubstraction(String text_input) {
        if(text_input.indexOf("-") != text_input.lastIndexOf("-")) throw new NotNegativesAllowed();

        String text_prepared = text_input.replace(" ", "").replace("-", " ");
        String[] operands = text_prepared.split(" ");
        double operand1 = convertToNumber(operands[0]);
        double operand2 = convertToNumber(operands[1]);
        return new Substraction(operand1, operand2);
    }

    private Operation buildSum(String text_input) {
        String text_prepared = text_input.replace(" ", "").replace("+", " ");
        String[] operands = text_prepared.split(" ");
        double operand1 = convertToNumber(operands[0]);
        double operand2 = convertToNumber(operands[1]);
        return new Sum(operand1, operand2);
    }

    public Operation create(String text_input) {
        Operation operation = null;
        ImmutableSet<Map.Entry<String, Function<String, Operation>>> set = map.entrySet();
        for (Map.Entry<String, Function<String, Operation>> entry : set) {
            if (text_input.contains(entry.getKey())){
                operation = entry.getValue().apply(text_input);
            }
        }
        return operation;
    }

    private Double convertToNumber(String operand) {
        double number = Double.parseDouble(operand.trim());
        if(number < 0d){
            throw new NotNegativesAllowed();
        }

        if(number > maxNumber){
            number = 1;
        }
        return number;
    }
}
