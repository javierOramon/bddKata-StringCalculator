package oramon.saiyans.stringcalculator;

public class StringCalculator {

    public StringCalculator(){

    }

    public String calculate(String input) {
        Double result = processOperation(input);
        String code = invalidResult(result);
        if (code != null) return code;

        Double value_rounded = round(result);
        return value_rounded.toString();
    }

    private Double processOperation(String input) {
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

    private double convertToNumber(String operand) {
        return Double.parseDouble(operand.trim());
    }
}
