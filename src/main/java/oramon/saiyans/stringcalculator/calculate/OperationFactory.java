package oramon.saiyans.stringcalculator.calculate;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import oramon.saiyans.NotNegativesAllowed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
        Collection<Double> numbers = extractNumbers(text_input, "/");
        return new Division(numbers);
    }

    private Operation buildSubstraction(String text_input) {
        if(text_input.indexOf("-") != text_input.lastIndexOf("-")) throw new NotNegativesAllowed();

        Collection<Double> numbers = extractNumbers(text_input, "-");
        return new Substraction(numbers);
    }

    private Operation buildSum(String text_input) {
        Collection<Double> numbers = extractNumbers(text_input, "+");
        return new Sum(numbers);
    }

    private Collection<Double> extractNumbers(String text, String symbol){
        String text_prepared = text.replace(" ", "").replace(symbol, " ");
        String[] operands = text_prepared.split(" ");
        List<Double> numbers = new ArrayList<>();
        for(int position = 0; position < operands.length; position++){
            double operand = convertToNumber(operands[position]);
            if(operand <= maxNumber){
               numbers.add(operand);
            }
        }
        return numbers;
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
        return number;
    }
}
