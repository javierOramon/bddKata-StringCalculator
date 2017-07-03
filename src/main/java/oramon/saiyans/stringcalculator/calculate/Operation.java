package oramon.saiyans.stringcalculator.calculate;

import java.util.Collection;

public interface Operation {

    Collection<Double> operands();

    Double calculate();
}
