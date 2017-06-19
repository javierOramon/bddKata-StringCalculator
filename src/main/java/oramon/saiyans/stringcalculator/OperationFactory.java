package oramon.saiyans.stringcalculator;

public class OperationFactory {
    public Operation create(String input) {
        if(input.trim().isEmpty()) return new Sum(0, 0);
        String[] numbers = input.split(",");
        Integer number1 = Integer.parseInt(numbers[0].trim());
        Integer number2 = 0;
        if(numbers.length > 1){
            number2 = Integer.parseInt(numbers[1].trim());
        }
        return new Sum(number1, number2);
    }
}
