package oramon.saiyans.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class OperationFactoryTest {

    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    @Test
    public void oneNumberReturnsASumOperationWithNumberTheAlone(){
        //Arrange
        final Operation expected = new Sum(Arrays.asList(1));
        //Act
        Operation operation = factory.create("1");
        //Assert
        assertEquals("The operation is not the same", expected, operation);
    }

    @Test
    public void TwoNumbersSeparatedByCommasReturnsASumOperationWithBothNumbers(){
        //Arrange
        final Operation expected = new Sum(1, 2);
        //Act
        Operation operation = factory.create("1,2");
        //Assert
        assertEquals("The operation is not the same", expected, operation);
    }

    @Test
    public void EmptyStringsReturnsSumWithZeros(){
        //Arrange
        final Operation expected = new Sum(0, 0);
        //Act
        Operation operation = factory.create(" ");
        //Assert
        assertEquals("The operation is not the same", expected, operation);
    }

    @Test
    public void multipleNumbersSeparatedByCommasReturnsASumOperationWithBothNumbers(){
        //Arrange
        final Operation expected = new Sum(Arrays.asList(2,4,5));
        //Act
        Operation operation = factory.create("2,4,5");
        //Assert
        assertEquals("The operation is not the same", expected, operation);
    }

    @Test
    public void sumNumbersWithLineBreak(){
        //Arrange
        final Operation expected = new Sum(Arrays.asList(2,4,5));
        //Act
        Operation operation = factory.create("2\n 4\n5");
        //Assert
        assertEquals("The operation is not the same", expected, operation);
    }

}