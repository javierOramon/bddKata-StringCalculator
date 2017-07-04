package oramon.saiyans.stringcalculator.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Multiplication implements Operation {

    private final List<Double> operands;

    public Multiplication(double operand1, double operand2) {
        this.operands = Arrays.asList(operand1, operand2);
    }

    public Multiplication(Collection<Double> operands) {
        this.operands = new ArrayList<>(operands);
    }

    @Override
    public Collection<Double> operands() {
        return new ArrayList<>(this.operands);
    }

    @Override
    public Double calculate() {
        if(this.operands.isEmpty()) return 0d;

        Double result = operands.get(0);
        for(int position = 1; position < operands.size(); position++){
            result *= operands.get(position);
        }
        return result;
    }
}
