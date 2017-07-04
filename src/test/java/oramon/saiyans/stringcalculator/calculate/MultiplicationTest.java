package oramon.saiyans.stringcalculator.calculate;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class MultiplicationTest {

    @Test
    public void getOperands(){
        //Arrange
        Collection<Double> expectedOperands = Arrays.asList(1d, 2d, -1d, 0d);
        Operation operation = new Multiplication(expectedOperands);
        //Act
        Collection<Double> result = operation.operands();
        //Assert
        assertEquals("The operands are not the same", expectedOperands, result);
    }

    @Test
    public void operationEquality(){
        //Arrange
        Operation expected = new Multiplication(1d, 2d);
        //Act
        Operation result = new Multiplication(1d, 2d);
        //Assert
        assertEquals("Both objects aren't equals", expected, result);
    }

    @Test
    public void calculateMultiplicationOfOneToZero() throws Exception {
        //Arrange
        final Double zero = 0d;
        Operation Multiplication = new Multiplication(1d, 0d);
        //Act
        Double result = Multiplication.calculate();
        //Assert
        assertEquals("Multiplication to zero doesn't work", zero, result);
    }

    @Test
    public void calculateMultiplicationOfTwoNumbers() throws Exception {
        //Arrange
        final Double expected = 2d;
        Operation Multiplication = new Multiplication(1d, 2d);
        //Act
        Double result = Multiplication.calculate();
        //Assert
        assertEquals("Multiplication with two numbers doesn't work", expected, result);
    }

    @Test
    public void calculateMultiplicationWithOneNegativeValue() throws Exception {
        //Arrange
        final Double expected = -2d;
        Operation Multiplication = new Multiplication(-1d, 2d);
        //Act
        Double result = Multiplication.calculate();
        //Assert
        assertEquals("Multiplication with one negative value doesn't work", expected, result);
    }

    @Test
    public void calculateMultiplicationWithNegativeValues() throws Exception {
        //Arrange
        final Double expected = -2d;
        Operation Multiplication = new Multiplication(-1d, -2d);
        //Act
        Double result = Multiplication.calculate();
        //Assert
        assertEquals("Multiplication with two negatives values doesn't work", expected, result);
    }

    @Test
    public void calculateMultipleNumbers() throws Exception {
        //Arrange
        final Double expected = 250d;
        Operation Multiplication = new Multiplication(Arrays.asList(-5d, 2d, 5d, -5d));
        //Act
        Double result = Multiplication.calculate();
        //Assert
        assertEquals("Multiplication with multiple values doesn't work", expected, result);
    }
}
