package oramon.saiyans.stringcalculator;

import oramon.saiyans.stringcalculator.add.operations.Operation;
import oramon.saiyans.stringcalculator.add.operations.Sum;
import org.junit.Test;

import java.util.Arrays;

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
        assertEquals("Sum with two numbers doesn't work", expected, result);
    }

    @Test
    public void calculateSumWithOneNegativeValue() throws Exception {
        //Arrange
        final Integer expected = 1;
        Operation sum = new Sum(-1, 2);
        //Act
        Integer result = sum.calculate();
        //Assert
        assertEquals("Sum with one negative value doesn't work", expected, result);
    }

    @Test
    public void calculateSumWithNegativeValues() throws Exception {
        //Arrange
        final Integer expected = -3;
        Operation sum = new Sum(-1, -2);
        //Act
        Integer result = sum.calculate();
        //Assert
        assertEquals("Sum with two negatives values doesn't work", expected, result);
    }

    @Test
    public void calculateMultipleNumbers() throws Exception {
        //Arrange
        final Integer expected = -3;
        Operation sum = new Sum(Arrays.asList(-5, 2, 5, -5));
        //Act
        Integer result = sum.calculate();
        //Assert
        assertEquals("Sum with multiple values doesn't work", expected, result);
    }


}