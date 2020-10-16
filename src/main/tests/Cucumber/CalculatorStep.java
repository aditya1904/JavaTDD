package Cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import home.Calculator;

import static org.junit.Assert.assertEquals;

public class CalculatorStep {

    private int sum;
    private Calculator calc;

    @Given("^I have a calculator$")
    public void iHaveACalculator(){
        calc = new Calculator();
    }


    @When("^I enter the string \"([^\"]*)\"$")
    public void iEnterTheString(String input) throws Throwable {
        sum = calc.Add(input);
    }

    @Then("^I should have the result as (\\d+)$")
    public void iShouldHaveTheResultAs(int expectedSum) {
        assertEquals(sum, expectedSum);
    }
}
