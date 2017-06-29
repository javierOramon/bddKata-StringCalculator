package oramon.saiyans.stringcalculator.calculate;

import static org.junit.Assert.assertEquals;

public class OperationFactoryTest {

    public void ASumOperationIsCreatedProperly(){
        //Arrange
        final Sum expected = new Sum(4, 5);
        OperationFactory factory = new OperationFactory();
        String text_input = "4 + 5";
        //Act
        Operation operation = factory.create(text_input);
        //Assert
        assertEquals("The operation is not the same", expected , operation);
    }
}
