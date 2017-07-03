package oramon.saiyans.stringcalculator.calculate;

import oramon.saiyans.NotNegativesAllowed;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OperationFactoryTest {

    @Test
    public void ASumOperationIsCreatedProperly(){
        //Arrange
        final Operation expected = new Sum(4d, 5d);
        OperationFactory factory = new OperationFactory();
        String text_input = "4 + 5";
        //Act
        Operation operation = factory.create(text_input);
        //Assert
        assertEquals("The operation is not the same", expected , operation);
    }

    @Test
    public void ASubstractionOperationIsCreatedProperly(){
        //Arrange
        final Operation expected = new Substraction(4d, 5d);
        OperationFactory factory = new OperationFactory();
        String text_input = "4 - 5";
        //Act
        Operation operation = factory.create(text_input);
        //Assert
        assertEquals("The operation is not the same", expected , operation);
    }

    @Test
    public void ASubstractionWithNegativeValuesReturnAnError(){
        //Arrange
        OperationFactory factory = new OperationFactory();
        String text_input = "-4 - 5";
        //Act
        try{
            Operation operation = factory.create(text_input);
        }catch (NotNegativesAllowed e){
            assertTrue(true);
        }
    }

    @Test
    public void ADivisionOperationIsCreatedProperly(){
        //Arrange
        final Operation expected = new Division(4d, 5d);
        OperationFactory factory = new OperationFactory();
        String text_input = "4 / 5";
        //Act
        Operation operation = factory.create(text_input);
        //Assert
        assertEquals("The operation is not the same", expected , operation);
    }


}
