package oramon.saiyans.stringcalculator;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationFactory {

    public static final String DEFAULT_DELIMETER = ",";
    public static final String LINE_BREAK = "\n";
    public static final String DEFINE_DELIMETER = "//";

    public final int maxNumber;

    public OperationFactory(){
        maxNumber = 1000;
    }

    public Operation create(String input) {

        if(input.trim().isEmpty()) return new Sum(0, 0);
        String delimeter = extractDelimeter(input);
        String sanitizedInput = extractOperation(input, delimeter);
        String[] numbers_splitted = sanitizedInput.split(delimeter);
        List<Integer> numbers = Arrays.stream(numbers_splitted)
                .map(entry -> Integer.parseInt(entry.trim()))
                .filter(number -> number <= maxNumber)
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
            delimeter = delimeter.replace("[", "");
            delimeter = delimeter.replace("]", "");
            delimeter = scapeSpecialCharacters(delimeter);
        }
        return delimeter;
    }

    private String scapeSpecialCharacters(String delimeter) {
        Map<Character, String> possibilities = ImmutableMap.<Character, String>builder()
                .put('*', "\\*")
                .put('+', "\\+")
                .put('?', "\\?")
                .build();
        Pattern p = Pattern.compile("[*+?]");
        boolean hasSpecialCharacters = p.matcher(delimeter).find();
        if(hasSpecialCharacters){
            StringBuilder sb = new StringBuilder();
            for(char character : delimeter.toCharArray()){
                if(possibilities.containsKey(character)){
                    sb.append(possibilities.get(character));
                }else{
                    sb.append(character);
                }
            }
            delimeter = sb.toString();
        }
        return delimeter;
    }
}
