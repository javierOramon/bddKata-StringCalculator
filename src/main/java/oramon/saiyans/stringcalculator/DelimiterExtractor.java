package oramon.saiyans.stringcalculator;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final String DEFAULT_DELIMETER = ",";
    private static final String LINE_BREAK = "\n";
    private static final String DEFINE_DELIMETER = "//";

    public Delimeter extractDelimeter(String input) {
        String delimeter = DEFAULT_DELIMETER;
        if(input.startsWith(DEFINE_DELIMETER)){
            int first_line_break = input.indexOf(LINE_BREAK);
            delimeter = input.substring(2, first_line_break);
            delimeter = delimeter.replace("[", "");
            delimeter = delimeter.replace("]", "");
            delimeter = scapeSpecialCharacters(delimeter);
        }
        return new Delimeter(delimeter);
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
