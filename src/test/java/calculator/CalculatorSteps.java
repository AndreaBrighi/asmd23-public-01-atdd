package calculator;

import io.cucumber.java.en.*;

public class CalculatorSteps {
    private int res = 0;
    private Calculator calculator;

    @Given("I have a Calculator")
    public void iHaveACalculator() {
        this.calculator = new Calculator();
    }

    @When("I add {double} and {double}")
    public void iAddAnd(double arg0, double arg1) {
        this.calculator.enter(arg0);
        this.calculator.enter(arg1);
    }

    @Then("the sum should be {double}")
    public void theSumShouldBe(double arg0) {
        this.calculator.add();
        if (!equalsWithTolerance(arg0, this.calculator.getResult(), 0.0001)) { // or using Junit's asserts
            throw new IllegalStateException();
        }
    }

    private boolean equalsWithTolerance(double a, double b, double tolerance) {
        return Math.abs(a - b) < tolerance;
    }
}
