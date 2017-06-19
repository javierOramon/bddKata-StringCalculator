package oramon.saiyans;

import oramon.saiyans.stringcalculator.Operation;
import oramon.saiyans.stringcalculator.OperationFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class MyStepsdefs  {

    private String input;
    private OperationFactory operationFactory;
    private Operation operation;

    @Given("^you input of (\\d+)")
    public void inputOperation(String insert){
        this.input = insert;
    }

    @When("^When you process this input")
    public void proccessInput(){
        operation = operationFactory.create(input);
    }

    @Then("^Then the result will be (\\d+)")
    public void resultWillBe(Integer expected){
        Integer result = operation.calculate();
        assertEquals("the result is not the expected", expected, result);
    }
}
