package oramon.saiyans.stringcalculator.calculate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTest {

    @Test
    public void operationEquality(){
        //Arrange
        Sum expected = new Sum(1, 2);
        //Act
        Sum result = new Sum(1, 2);
        //Assert
        assertEquals("Both objects aren't equals", expected, result);
    }

}