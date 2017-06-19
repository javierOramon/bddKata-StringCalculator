package oramon.saiyans.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum implements Operation {

    private final List<Integer> list_of_numbers;

    public Sum(int first_number, int second_number) {
        this.list_of_numbers = Arrays.asList(first_number, second_number);
    }

    public Sum(List<Integer> list_of_numbers) {
        this.list_of_numbers = new ArrayList<>(list_of_numbers);
    }

    public Integer calculate() {
        int total = 0;
        for (Integer number : list_of_numbers) {
            total += number;
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sum sum = (Sum) o;

        return list_of_numbers != null ? list_of_numbers.equals(sum.list_of_numbers) : sum.list_of_numbers == null;
    }

    @Override
    public int hashCode() {
        return list_of_numbers != null ? list_of_numbers.hashCode() : 0;
    }
}
