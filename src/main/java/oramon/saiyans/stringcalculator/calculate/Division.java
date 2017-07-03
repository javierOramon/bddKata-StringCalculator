package oramon.saiyans.stringcalculator.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Division implements Operation {
    private final List<Double> operands;

    public Division(double operand1, double operand2) {
        operands = Arrays.asList(operand1, operand2);
    }

    public Division(List<Double> operands) {
        this.operands = new ArrayList<>(operands);
    }

    @Override
    public Double calculate() {
        if(operands.isEmpty()) return 0d;

        Double result = operands.get(0);
        for(int position = 1; position < operands.size(); position++){
            result = result / operands.get(position);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Division division = (Division) o;

        return operands != null ? operands.equals(division.operands) : division.operands == null;
    }

    @Override
    public int hashCode() {
        return operands != null ? operands.hashCode() : 0;
    }
}
