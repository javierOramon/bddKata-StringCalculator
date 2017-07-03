package oramon.saiyans.stringcalculator.calculate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationFactoryTest {

    @Test
    public void ASumOperationIsCreatedProperly(){
        //Arrange
        final Sum expected = new Sum(4d, 5d);
        OperationFactory factory = new OperationFactory();
        String text_input = "4 + 5";
        //Act
        Operation operation = factory.create(text_input);
        //Assert
        assertEquals("The operation is not the same", expected , operation);
    }
}
