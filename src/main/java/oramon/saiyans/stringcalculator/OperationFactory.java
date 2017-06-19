package oramon.saiyans.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OperationFactory {

    public Operation create(String input) {

        if(input.trim().isEmpty()) return new Sum(0, 0);

        String[] numbers_splitted = input.split(",");
        List<Integer> numbers = Arrays.stream(numbers_splitted)
                .map(entry -> Integer.parseInt(entry))
                .collect(Collectors.toList());
        return new Sum(numbers);
    }
}
