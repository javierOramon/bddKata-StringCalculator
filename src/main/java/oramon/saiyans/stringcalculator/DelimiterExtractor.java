package oramon.saiyans.stringcalculator;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    private static final String DEFAULT_DELIMETER = ",";
    private static final String LINE_BREAK = "\n";
    private static final String DEFINE_DELIMETER = "//";

    public Delimeter extractDelimeter(String input) {
        List<String> delimeters = new ArrayList<>();
        if(input.startsWith(DEFINE_DELIMETER)){
            int first_line_break = input.indexOf(LINE_BREAK);
            String space_of_delimeters = input.substring(2, first_line_break);
            if(space_of_delimeters.contains("[")){
                int cursor = 0;
                while(space_of_delimeters.indexOf("[", cursor) != -1){
                    int startBracketPosition = space_of_delimeters.indexOf("[", cursor);
                    int endBracketPositiion = space_of_delimeters.indexOf("]", startBracketPosition);
                    final String delimeter = space_of_delimeters.substring(startBracketPosition +1 , endBracketPositiion);
                    delimeters.add(delimeter);
                    cursor = endBracketPositiion;
                }

            }else{
                delimeters.add(space_of_delimeters);
            }
        }

        if(delimeters.isEmpty()){
            delimeters.add(DEFAULT_DELIMETER);
        }

        return new Delimeter(delimeters);
    }


}
