package oramon.saiyans.stringcalculator.calculate;

import oramon.saiyans.NotNegativesAllowed;

public class StringCalculator {

    private final PoolOperationFactory operationFactory;

    public StringCalculator(PoolOperationFactory operationFactory){
        this.operationFactory = operationFactory;
    }

    public String calculate(String input) {
        try{
            Operation operation = operationFactory.create(input);
            Double result = operation.calculate();
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
}
