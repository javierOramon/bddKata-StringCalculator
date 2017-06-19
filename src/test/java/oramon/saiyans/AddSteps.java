package oramon.saiyans;

import oramon.saiyans.stringcalculator.Operation;
import oramon.saiyans.stringcalculator.OperationFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class AddSteps {

    private String input;
    private Operation operation;

    @Given("^you input of \"(.*?)\"$")
    public void inputOperation(String insert){
        this.input = insert;
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
}
