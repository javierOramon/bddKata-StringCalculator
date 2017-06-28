package oramon.saiyans.bdd.add;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import oramon.saiyans.NotNegativesAllowed;
import oramon.saiyans.stringcalculator.operations.Operation;
import oramon.saiyans.stringcalculator.operations.OperationFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddSteps {
    private String input;
    private Operation operation;

    @Given("^you input of \"(.*?)\"$")
    public void inputOperation(String insert){
        this.input = insert.replace("\\n", "\n");
    }

    @When("^you process this input$")
    public void proccessInput(){
        OperationFactory operationFactory = new OperationFactory();
        operation = operationFactory.create(input);
    }

    @Then("^the result will be (\\d+)$")
    public void resultWillBe(Integer expected){
        Integer result = operation.calculate();
        assertEquals("the result is not the expected", expected, result);
    }

    @When("^you process this input and fail")
    public void proccessInputFailed() {
        OperationFactory operationFactory = new OperationFactory();
        try{
            operation = operationFactory.create(input);
        }catch (NotNegativesAllowed e){
            assertTrue(true);
        }
    }
}
