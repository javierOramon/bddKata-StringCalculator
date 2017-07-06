package oramon.saiyans.stringcalculator.calculate;

import oramon.saiyans.NotNegativesAllowed;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class PoolOperationFactory {

    private final Collection<OperationFactory> factories;
    private final int maxNumber;
    private final NumbersExtractor extractor;

    public PoolOperationFactory(){
        extractor = new NumbersExtractor();
        factories = Arrays.asList(
        new OperationFactory("+", extractor,  this::sanitizeNumbers, Sum::new),
        new OperationFactory("*", extractor,  this::sanitizeNumbers, Multiplication::new),
        new OperationFactory("/", extractor,  this::sanitizeNumbers, Division::new),
        new OperationFactory("-", extractor,  this::sanitizeNumbers, Substraction::new)
        );
        maxNumber = 1000;
    }

    public Operation create(String text_input) {
        Operation operation = null;
        for (OperationFactory factory : factories) {
            if(text_input.contains(factory.symbol())){
                operation = factory.create(text_input);
                break;
            }
        }
        return operation;
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
}
