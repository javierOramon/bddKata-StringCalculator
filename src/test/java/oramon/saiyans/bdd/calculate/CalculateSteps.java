package oramon.saiyans.bdd.calculate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import oramon.saiyans.stringcalculator.calculate.OperationFactory;
import oramon.saiyans.stringcalculator.calculate.StringCalculator;

import static org.junit.Assert.assertEquals;

public class CalculateSteps {

    private String input;
    private String result;

    @Given("^an input of \"(.*?)\"$")
    public void inputOperation(String insert){
        this.input = insert.replace("\\n", "\n");
    }

    @When("^you run the Calculate method$")
    public void proccessInput(){
        result = new StringCalculator(new OperationFactory()).calculate(input);
    }

    @Then("^the result will be a \"(.*?)\"$")
    public void resultWillBe(String expected){
        assertEquals(expected, result );
    }

    @Then("^an exception will be shown \"(.*?)\"$")
    public void exceptionResult(String exception){
        assertEquals(exception, result);
    }

    @Given("^your input is an addition \"(.*?)\"$")
    public void yourInputIsAnAdditionInput(String input)  {
        this.input = input.replace("\\n", "\n");
    }
}
