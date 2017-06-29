package oramon.saiyans.stringcalculator.add.delimeter;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimeter {

    private static final String DEFAULT_DELIMETER = ",";
    private static final String LINE_BREAK = "\n";
    private static final String DEFINE_DELIMETER = "//";

    private final List<String> delimeters;

    public Delimeter(List<String> delimeters) {
        if(delimeters.isEmpty()){
            this.delimeters = Arrays.asList(DEFAULT_DELIMETER);
        }else{
            this.delimeters = new ArrayList<>(delimeters);
        }
        this.delimeters.add(LINE_BREAK);
    }

    public List<Integer> process(String input) {
        String numbers_space = extractStringNumbers(input);
        String sanitized_numbers_space = alignDifferentDelimeters(numbers_space);
        String[] numbers_splitted = sanitized_numbers_space.split("[" + scapeSpecialCharacters(primaryDelimeter()) + "]");
        List<Integer> numbers = Arrays.stream(numbers_splitted)
                .filter(entry -> !entry.isEmpty())
                .map(entry -> Integer.parseInt(entry.trim()))
                .collect(Collectors.toList());
        return numbers;
    }

    private String alignDifferentDelimeters(String numbers_space) {
        String final_text = numbers_space.toString();
        String primary_delimeter = primaryDelimeter();
        for(String delimeter : delimeters){
            final_text = final_text.replace(delimeter, primary_delimeter);
        }
        return final_text;
    }

    private String primaryDelimeter() {
        return DEFAULT_DELIMETER;
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
