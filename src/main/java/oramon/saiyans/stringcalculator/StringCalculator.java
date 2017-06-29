package oramon.saiyans.stringcalculator;

import oramon.saiyans.NotNegativesAllowed;

public class StringCalculator {

    public StringCalculator(){

    }

    public String calculate(String input) {
        try{
            Double result = processOperation(input);
            String code = invalidResult(result);
            if (!code.isEmpty()) return code;

            Double value_rounded = round(result);
            return value_rounded.toString();
        }catch (NotNegativesAllowed e){
            return e.getMessage();
        }
    }

    private Double processOperation(String input) throws NotNegativesAllowed {
        String[] operands = input.split("/");
        Double result = convertToNumber(operands[0]);
        for (int position = 1; position < operands.length; position++){
            Double number = convertToNumber(operands[position]);
            result = result / number;
        }
        return result;
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

    private Double convertToNumber(String operand) throws NotNegativesAllowed {
        final double number = Double.parseDouble(operand.trim());
        if(number < 0d){
            throw new NotNegativesAllowed();
        }
        return number;
    }
}
