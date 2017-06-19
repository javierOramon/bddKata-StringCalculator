package oramon.saiyans.stringcalculator;

public class Sum implements Operation {

    private final int first_number;
    private final int second_number;

    public Sum(int first_number, int second_number) {
        super();
        this.first_number = first_number;
        this.second_number = second_number;
    }

    public Integer calculate() {
        return first_number + second_number;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sum sum = (Sum) o;

        if (first_number != sum.first_number) return false;
        return second_number == sum.second_number;
    }

    @Override
    public int hashCode() {
        int result = first_number;
        result = 31 * result + second_number;
        return result;
    }


}
