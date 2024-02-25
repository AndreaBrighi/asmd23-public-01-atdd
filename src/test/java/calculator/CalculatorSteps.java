package calculator;

import io.cucumber.java.en.*;

public class CalculatorSteps {
    private int res = 0;
    private Calculator calculator;

    protected boolean equalsWithTolerance(double a, double b, double tolerance) {
        return Math.abs(a - b) < tolerance;
    }

    @Given("I have a Calculator")
    public void iHaveACalculator() {
        this.calculator = new Calculator();
    }

    @Then("the result should be {double}")
    public void theResultShouldBe(double arg0) {
        if (!equalsWithTolerance(arg0, this.calculator.getResult(), 0.0001)) { // or using Junit's asserts
            throw new IllegalStateException();
        }
    }

    @And("I have a pre-given value of {double}")
    public void iHaveAPreGivenValueOf(double arg0) {
        this.calculator.enter(arg0);
    }

    @When("I insert {double}")
    public void iInsert(double arg0) {
        this.calculator.enter(arg0);
    }

    @And("I press +")
    public void iPressPlus() {
        this.calculator.enter(Calculator.Operator.ADD);
    }

    @And("I press -")
    public void iPressMinus() {
        this.calculator.enter(Calculator.Operator.SUBTRACT);
    }

    @And("I press =")
    public void iPressResult() {
        this.calculator.enter(Calculator.Operator.RESULT);
    }
}
