package oramon.saiyans.stringcalculator.calculate;

import java.util.Arrays;
import java.util.List;

public class Sum implements Operation {
    private final List<Integer> operands;

    public Sum(int operand1, int operand2) {
        operands = Arrays.asList(operand1, operand2);
    }

    @Override
    public Double calculate() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sum sum = (Sum) o;

        return operands != null ? operands.equals(sum.operands) : sum.operands == null;
    }

    @Override
    public int hashCode() {
        return operands != null ? operands.hashCode() : 0;
    }
}
