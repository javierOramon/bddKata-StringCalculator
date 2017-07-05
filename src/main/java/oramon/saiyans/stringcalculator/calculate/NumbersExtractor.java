package oramon.saiyans.stringcalculator.calculate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NumbersExtractor {

    public Collection<Double> extract(String text, String symbol){
        String text_prepared = removeSpaces(text, symbol);
        boolean startWithSymbol = text_prepared.startsWith(symbol);
        String text_to_process = extractTextToProcess(text_prepared, startWithSymbol);
        String[] operands = splitInStringNumbers(symbol, startWithSymbol, text_to_process);
        List<Double> numbers = transformToNumbers(operands);
        return numbers;
    }

    private List<Double> transformToNumbers(String[] operands) {
        List<Double> numbers = new ArrayList<>();
        for(int position = 0; position < operands.length; position++){
            double operand = convertToNumber(operands[position]);
            numbers.add(operand);

        }
        return numbers;
    }

    private String[] splitInStringNumbers(String symbol, boolean startWithSymbol, String text_to_process) {
        String[] operands = text_to_process.replace(symbol, " ").split(" ");
        if(startWithSymbol){
            operands[0] = symbol + operands[0];
        }
        return operands;
    }

    private String extractTextToProcess(String text_prepared, boolean startWithSymbol) {
        String text_to_process = text_prepared.toString();
        if(startWithSymbol){
            text_to_process = text_prepared.substring(1);
        }
        return text_to_process;
    }


    private String removeSpaces(String text, String symbol) {
        return text.replace(" ", "");
    }

    private Double convertToNumber(String operand) {
        double number = Double.parseDouble(operand.trim());
        return number;
    }
}
