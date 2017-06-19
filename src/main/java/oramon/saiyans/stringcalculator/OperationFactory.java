package oramon.saiyans.stringcalculator;

public class OperationFactory {
    public Operation create(String input) {
        Integer number = Integer.parseInt(input);
        return new Sum(number, 0);
    }
}
