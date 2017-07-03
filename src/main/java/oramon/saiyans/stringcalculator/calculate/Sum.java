package oramon.saiyans.stringcalculator.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Sum implements Operation {
    private final List<Double> operands;

    public Sum(Double operand1, Double operand2) {
        this.operands = Arrays.asList(operand1, operand2);
    }

    public  Sum(Collection<Double> operands) {
        this.operands = new ArrayList<>(operands);
    }

    @Override
    public Double calculate() {
        Double total = 0d;
        for (Double number : operands) {
            total += number;
        }
        return total;
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
