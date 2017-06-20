package oramon.saiyans.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OperationFactory {

    public static final String DEFAULT_DELIMETER = ",";
    public static final String LINE_BREAK = "\n";
    public static final String DEFINE_DELIMETER = "//";

    public Operation create(String input) {

        if(input.trim().isEmpty()) return new Sum(0, 0);
        String delimeter = extractDelimeter(input);
        String sanitizedInput = extractOperation(input, delimeter);
        String[] numbers_splitted = sanitizedInput.split(delimeter);
        List<Integer> numbers = Arrays.stream(numbers_splitted)
                .map(entry -> Integer.parseInt(entry.trim()))
                .collect(Collectors.toList());
        return new Sum(numbers);
    }

    private String extractOperation(String input, String delimeter) {
        String sanitizedInput = extractStringNumbers(input);
        sanitizedInput = sanitizedInput.replace(LINE_BREAK, delimeter);
        return sanitizedInput;
    }

    private String extractStringNumbers(String input) {
        String sanitizedInput;
        if(input.startsWith(DEFINE_DELIMETER)){
            int position_of_line_break = input.indexOf(LINE_BREAK);
            sanitizedInput = input.substring(position_of_line_break + 1);
        }else{
            sanitizedInput = input.toString();
        }
        return sanitizedInput;
    }

    private String extractDelimeter(String input) {
        String delimeter = DEFAULT_DELIMETER;
        if(input.startsWith(DEFINE_DELIMETER)){
            int first_line_break = input.indexOf(LINE_BREAK);
            delimeter = input.substring(2, first_line_break);
        }

        return delimeter;
    }
}
