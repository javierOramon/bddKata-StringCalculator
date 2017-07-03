package oramon.saiyans.stringcalculator.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Substraction implements Operation {

    private final List<Double> operands;

    public Substraction(double operand1, double operand2) {
        operands = Arrays.asList(operand1, operand2);
    }

    public Substraction(List<Double> operands) {
        this.operands = new ArrayList<>(operands);
    }

    @Override
    public Double calculate() {
        if(operands.isEmpty()) return 0d;

        Double result = operands.get(0);
        for(int position = 1; position < operands.size(); position++){
            result -= operands.get(position);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Substraction that = (Substraction) o;

        return operands != null ? operands.equals(that.operands) : that.operands == null;
    }

    @Override
    public int hashCode() {
        return operands != null ? operands.hashCode() : 0;
    }
}
