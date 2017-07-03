package oramon.saiyans.stringcalculator.calculate;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DivisionTest {

    @Test
    public void operationEquality(){
        //Arrange
        Operation expected = new Division(1d, 2d);
        //Act
        Operation result = new Division(1d, 2d);
        //Assert
        assertEquals("Both objects aren't equals", expected, result);
    }

    @Test
    public void calculateDivisionOfOneToZero() throws Exception {
        //Arrange
        Operation division = new Division(1d, 0d);
        //Act
        Double result = division.calculate();
        //Assert
        assertTrue("division to zero is not inifinite", Double.isInfinite(result));
    }

    @Test
    public void calculateDivisionOfZeroToOneReturnZero() throws Exception {
        //Arrange
        final Double zero = 0.d;
        Operation division = new Division(0d, 1d);
        //Act
        Double result = division.calculate();
        //Assert
        assertEquals("division zero to something is not 0", zero, result);
    }

    @Test
    public void calculateDivisionOfTwoNumbers() throws Exception {
        //Arrange
        final Double expected = 0.5;
        Operation division = new Division(1d, 2d);
        //Act
        Double result = division.calculate();
        //Assert
        assertEquals("division with two numbers doesn't work", expected, result);
    }

    @Test
    public void calculateDivisionWithOneNegativeValue() throws Exception {
        //Arrange
        final Double expected = -0.5;
        Operation division = new Division(-1d, 2d);
        //Act
        Double result = division.calculate();
        //Assert
        assertEquals("division with one negative value doesn't work", expected, result);
    }

    @Test
    public void calculateDivisionWithNegativeValues() throws Exception {
        //Arrange
        final Double expected = 0.5;
        Operation division = new Division(-1d, -2d);
        //Act
        Double result = division.calculate();
        //Assert
        assertEquals("division with two negatives values doesn't work", expected, result);
    }

    @Test
    public void calculateMultipleNumbers() throws Exception {
        //Arrange
        final Double expected = 0.1;
        Operation division = new Division(Arrays.asList(-5d, 2d, 5d, -5d));
        //Act
        Double result = division.calculate();
        //Assert
        assertEquals("division with multiple values doesn't work", expected, result);
    }

}