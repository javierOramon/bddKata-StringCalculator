package oramon.saiyans.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationFactoryTest {

    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    @Test
    public void oneNumberReturnsASumOperationWithNumberSum0(){
        //Arrange
        final Operation expected = new Sum(1, 0);
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

}