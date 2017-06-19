package oramon.saiyans.stringcalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumTest {

    @Test
    public void calculateSumOfOneToZero() throws Exception {
        //Arrange
        final Integer one = 1;
        Operation sum = new Sum(1, 0);
        //Act
        Integer result = sum.calculate();
        //Assert
        assertEquals("Sum to zero doesn't work", one, result);
    }

    @Test
    public void calculateSumOfTwoNumbers() throws Exception {
        //Arrange
        final Integer expected = 3;
        Operation sum = new Sum(1, 2);
        //Act
        Integer result = sum.calculate();
        //Assert
        assertEquals("Sum to zero doesn't work", expected, result);
    }

    @Test
    public void calculateSumWithOneNegativeValue() throws Exception {
        //Arrange
        final Integer expected = 1;
        Operation sum = new Sum(-1, 2);
        //Act
        Integer result = sum.calculate();
        //Assert
        assertEquals("Sum to zero doesn't work", expected, result);
    }
    @Test
    public void calculateSumWithNegativeValues() throws Exception {
        //Arrange
        final Integer expected = -3;
        Operation sum = new Sum(-1, -2);
        //Act
        Integer result = sum.calculate();
        //Assert
        assertEquals("Sum to zero doesn't work", expected, result);
    }


}