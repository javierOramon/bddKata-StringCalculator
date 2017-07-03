package oramon.saiyans.stringcalculator.calculate;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class SubstractionTest {

    @Test
    public void getOperands(){
        //Arrange
        Collection<Double> expectedOperands = Arrays.asList(1d, 2d, -1d, 0d);
        Operation operation = new Substraction(expectedOperands);
        //Act
        Collection<Double> result = operation.operands();
        //Assert
        assertEquals("The operands are not the same", expectedOperands, result);
    }

    @Test
    public void operationEquality(){
        //Arrange
        Operation expected = new Substraction(1d, 2d);
        //Act
        Operation result = new Substraction(1d, 2d);
        //Assert
        assertEquals("Both objects aren't equals", expected, result);
    }

    @Test
    public void calculateSubstractionOfOneToZero() throws Exception {
        //Arrange
        final Double one = 1d;
        Operation substraction = new Substraction(1d, 0d);
        //Act
        Double result = substraction.calculate();
        //Assert
        assertEquals("Substraction to zero doesn't work", one, result);
    }

    @Test
    public void calculateSubstractionOfZeroToOneReturnLessOne() throws Exception {
        //Arrange
        final Double one = -1d;
        Operation substraction = new Substraction(0d, 1d);
        //Act
        Double result = substraction.calculate();
        //Assert
        assertEquals("Substraction to zero doesn't return -1", one, result);
    }

    @Test
    public void calculateSubstractionOfTwoNumbers() throws Exception {
        //Arrange
        final Double expected = -1d;
        Operation substraction = new Substraction(1d, 2d);
        //Act
        Double result = substraction.calculate();
        //Assert
        assertEquals("Substraction with two numbers doesn't work", expected, result);
    }

    @Test
    public void calculateSubstractionWithOneNegativeValue() throws Exception {
        //Arrange
        final Double expected = -3d;
        Operation Substraction = new Substraction(-1d, 2d);
        //Act
        Double result = Substraction.calculate();
        //Assert
        assertEquals("Substraction with one negative value doesn't work", expected, result);
    }

    @Test
    public void calculateSubstractionWithNegativeValues() throws Exception {
        //Arrange
        final Double expected = 1d;
        Operation Substraction = new Substraction(-1d, -2d);
        //Act
        Double result = Substraction.calculate();
        //Assert
        assertEquals("Substraction with two negatives values doesn't work", expected, result);
    }

    @Test
    public void calculateMultipleNumbers() throws Exception {
        //Arrange
        final Double expected = -7d;
        Operation Substraction = new Substraction(Arrays.asList(-5d, 2d, 5d, -5d));
        //Act
        Double result = Substraction.calculate();
        //Assert
        assertEquals("Substraction with multiple values doesn't work", expected, result);
    }

}