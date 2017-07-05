package oramon.saiyans.stringcalculator.calculate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NumbersExtractor {

    public Collection<Double> extract(String text, String symbol){
        String text_prepared = text.replace(" ", "").replace(symbol, " ");
        String[] operands = text_prepared.split(" ");
        List<Double> numbers = new ArrayList<>();
        for(int position = 0; position < operands.length; position++){
            double operand = convertToNumber(operands[position]);
            numbers.add(operand);

        }
        return numbers;
    }

    private Double convertToNumber(String operand) {
        double number = Double.parseDouble(operand.trim());
        return number;
    }
}
