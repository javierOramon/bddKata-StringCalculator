package oramon.saiyans.stringcalculator;

public class StringCalculator {
    public String calculate(String input) {
        String[] operands = input.split("/");
        Double result = convertToNumber(operands[0]);
        for (int position = 1; position < operands.length; position++){
            Double number = convertToNumber(operands[position]);
            result = result / number;
        }

        if(Double.isInfinite(result)){
            return "Cannot divide by zero";
        }
        return result.toString();
    }

    private double convertToNumber(String operand) {
        return Double.parseDouble(operand.trim());
    }
}