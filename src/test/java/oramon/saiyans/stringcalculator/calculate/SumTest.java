package oramon.saiyans.stringcalculator.calculate;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SumTest {

    @Test
    public void operationEquality(){
        //Arrange
        Operation expected = new Sum(1d, 2d);
        //Act
        Operation result = new Sum(1d, 2d);
        //Assert
        assertEquals("Both objects aren't equals", expected, result);
    }

    @Test
    public void calculateSumOfOneToZero() throws Exception {
        //Arrange
        final Double one = 1d;
        Operation sum = new Sum(1d, 0d);
        //Act
        Double result = sum.calculate();
        //Assert
        assertEquals("Sum to zero doesn't work", one, result);
    }

    @Test
    public void calculateSumOfTwoNumbers() throws Exception {
        //Arrange
        final Double expected = 3d;
        Operation sum = new Sum(1d, 2d);
        //Act
        Double result = sum.calculate();
        //Assert
        assertEquals("Sum with two numbers doesn't work", expected, result);
    }

    @Test
    public void calculateSumWithOneNegativeValue() throws Exception {
        //Arrange
        final Double expected = 1d;
        Operation sum = new Sum(-1d, 2d);
        //Act
        Double result = sum.calculate();
        //Assert
        assertEquals("Sum with one negative value doesn't work", expected, result);
    }

    @Test
    public void calculateSumWithNegativeValues() throws Exception {
        //Arrange
        final Double expected = -3d;
        Operation sum = new Sum(-1d, -2d);
        //Act
        Double result = sum.calculate();
        //Assert
        assertEquals("Sum with two negatives values doesn't work", expected, result);
    }

    @Test
    public void calculateMultipleNumbers() throws Exception {
        //Arrange
        final Double expected = -3d;
        Operation sum = new Sum(Arrays.asList(-5d, 2d, 5d, -5d));
        //Act
        Double result = sum.calculate();
        //Assert
        assertEquals("Sum with multiple values doesn't work", expected, result);
    }

}