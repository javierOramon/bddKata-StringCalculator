package oramon.saiyans.stringcalculator.calculate;

import java.util.Collection;
import java.util.function.Function;

public class OperationFactory {


    private final NumbersExtractor extractor;
    private final String symbol;
    private final Function<Collection<Double>, Collection<Double>> validations;
    private final Function<Collection<Double>, Operation> create;

    public OperationFactory(String symbol, NumbersExtractor extractor, Function<Collection<Double>, Collection<Double>> validations, Function<Collection<Double>, Operation> create) {
        this.extractor = extractor;
        this.symbol = symbol;
        this.validations = validations;
        this.create = create;
    }

    public String symbol(){ return symbol; }

    public Operation create(String text_input){
        Collection<Double> numbers = extractor.extract(text_input, symbol);
        Collection<Double> sanitized_numbers = validations.apply(numbers);
        return create.apply(sanitized_numbers);
    }
}
