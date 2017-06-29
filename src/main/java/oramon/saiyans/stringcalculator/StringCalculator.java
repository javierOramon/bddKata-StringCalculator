package oramon.saiyans.stringcalculator;

import oramon.saiyans.NotNegativesAllowed;

import java.util.List;

public class StringCalculator {

    List<String> symbols;

    public StringCalculator(){
    }

    public String calculate(String input) {
        try{
            Double result = processOperation(input);
            String code = invalidResult(result);
            if (!code.isEmpty()) return code;

            Double value_rounded = round(result);
            final String text_value = processTextToShow(value_rounded);
            return text_value;
        }catch (NotNegativesAllowed e){
            return e.getMessage();
        }
    }

    private String processTextToShow(Double value) {
        String text = value.toString();
        if(text.endsWith(".0")){
            text = text.replace(".0", "");
        }
        return text;
    }

    private Double processOperation(String input) throws NotNegativesAllowed {
        String symbol = extractSymbol(input);
        String[] operands = input.split(symbol);
        Double result = processTextNumber(operands[0]);
        for (int position = 1; position < operands.length; position++){
            Double number = processTextNumber(operands[position]);
            switch (symbol){
                case "/":
                    result = result / number;
                    break;
                case "\\+":
                    result = result + number;
            }
        }
        return result;
    }

    private String extractSymbol(String input) {
        String symbol = "";
        if(input.contains("/")){

            symbol = "/";
        }else if(input.contains("+")){
            symbol = "\\+";
        }
        return symbol;
    }

    private String invalidResult(Double result) {
        String code = "";
        if(Double.isInfinite(result)){
            code = "Cannot divide by zero";
        }

        if(Double.isNaN(result)){
            code = "Result is undefined";
        }
        return code;
    }

    private Double round(Double result) {
        return Math.round(result * 10000) / 10000d;
    }

    private Double processTextNumber(String operand) throws NotNegativesAllowed{
        Double number = convertToNumber(operand);
        if(number < 0d){
            throw new NotNegativesAllowed();
        }

        if(number > 1000){
            number = 1d;
        }
        return number;
    }

    private Double convertToNumber(String operand) {
        final double number = Double.parseDouble(operand.trim());
        return number;
    }
}
