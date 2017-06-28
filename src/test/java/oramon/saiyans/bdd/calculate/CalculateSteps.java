package oramon.saiyans.bdd.calculate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import oramon.saiyans.stringcalculator.StringCalculator;

import static org.junit.Assert.assertEquals;

public class CalculateSteps {

    private String input;
    private String result;

    @Given("^your input is a division \"(.*?)\"$")
    public void inputOperation(String insert){
        this.input = insert.replace("\\n", "\n");
    }

    @When("^you run the Calculate method$")
    public void proccessInput(){
        result = new StringCalculator().calculate(input);
    }

    @Then("^the result will be a \"(.*?)\"$")
    public void resultWillBe(String expected){
        assertEquals(expected, result );
    }
}