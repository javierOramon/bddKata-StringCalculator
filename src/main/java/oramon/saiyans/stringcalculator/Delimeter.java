package oramon.saiyans.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Delimeter {

    private static final String DEFAULT_DELIMETER = ",";
    private static final String LINE_BREAK = "\n";
    private static final String DEFINE_DELIMETER = "//";

    private String delimeter;

    public Delimeter(String delimeter) {
        this.delimeter = delimeter;
    }

    public List<Integer> process(String input) {
        String sanitizedInput = extractOperation(input, delimeter);
        String[] numbers_splitted = sanitizedInput.split(delimeter);
        List<Integer> numbers = Arrays.stream(numbers_splitted)
                .map(entry -> Integer.parseInt(entry.trim()))
                .collect(Collectors.toList());
        return numbers;
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
}
