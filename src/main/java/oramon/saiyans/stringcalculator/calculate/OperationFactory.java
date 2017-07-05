package oramon.saiyans.stringcalculator.calculate;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import oramon.saiyans.NotNegativesAllowed;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OperationFactory {

    private final ImmutableMap<String, Function<String, Operation>> map;
    private final int maxNumber;
    private final NumbersExtractor extractor;

    public OperationFactory(){
        extractor = new NumbersExtractor();
        map = ImmutableMap.<String, Function<String, Operation>>builder()
                .put("+", this::buildSum)
                .put("*", this::buildMultiplication)
                .put("/", this::buildDivision)
                .put("-", this::buildSubstraction)
                .build();
        maxNumber = 1000;
    }

    private Operation buildMultiplication(String text_input) {
        Collection<Double> numbers = extractor.extract(text_input, "*");
        Collection<Double> sanitized_numbers = sanitizeNumbers(numbers);
        return new Multiplication(sanitized_numbers);
    }

    private Collection<Double> sanitizeNumbers(Collection<Double> numbers) {
        return numbers.stream().filter(number ->
        {
            if (number < 0d) {
                throw new NotNegativesAllowed();
            }
            return number <= maxNumber;
        }).collect(Collectors.toList());

    }

    private Operation buildDivision(String text_input) {
        Collection<Double> numbers = extractor.extract(text_input, "/");
        Collection<Double> sanitized_numbers = sanitizeNumbers(numbers);
        return new Division(sanitized_numbers);
    }

    private Operation buildSubstraction(String text_input) {
        if(text_input.indexOf("-") != text_input.lastIndexOf("-")) throw new NotNegativesAllowed();

        Collection<Double> numbers = extractor.extract(text_input, "-");
        Collection<Double> sanitized_numbers = sanitizeNumbers(numbers);
        return new Substraction(sanitized_numbers);
    }

    private Operation buildSum(String text_input) {
        Collection<Double> numbers = extractor.extract(text_input, "+");
        Collection<Double> sanitized_numbers = sanitizeNumbers(numbers);
        return new Sum(sanitized_numbers);
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
}
