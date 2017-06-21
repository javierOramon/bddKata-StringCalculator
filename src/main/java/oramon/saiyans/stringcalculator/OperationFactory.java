package oramon.saiyans.stringcalculator;

import java.util.List;
import java.util.stream.Collectors;

public class OperationFactory {

    DelimiterExtractor delimiterExtractor;

    private final int maxNumber;

    public OperationFactory(DelimiterExtractor delimiterExtractor){
        this.delimiterExtractor = delimiterExtractor;
        maxNumber = 1000;
    }

    public OperationFactory(){
        this.delimiterExtractor = new DelimiterExtractor();
        maxNumber = 1000;
    }

    public Operation create(String input) {

        if(input.trim().isEmpty()) return new Sum(0, 0);
        Delimeter delimeter = delimiterExtractor.extractDelimeter(input);
        List<Integer> numbers = delimeter.process(input);
        return new Sum(numbers.stream().filter(number -> number < maxNumber).collect(Collectors.toList()));
    }
}
