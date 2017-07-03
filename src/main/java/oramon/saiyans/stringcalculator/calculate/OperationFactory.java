package oramon.saiyans.stringcalculator.calculate;

public class OperationFactory {

    public Operation create(String text_input) {
        String[] operands = text_input.split("\\+");
        double operand1 = Double.parseDouble(operands[0].trim());
        double operand2 = Double.parseDouble(operands[1].trim());
        return new Sum(operand1, operand2);
    }
}
