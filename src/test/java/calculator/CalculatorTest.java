package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void acceptanceTest(){
        Calculator calculator = new Calculator();
        calculator.enter(5);
        assertEquals(5, calculator.getResult());

        calculator.enter(Calculator.Operator.ADD);
        calculator.enter(6);
        calculator.enter(Calculator.Operator.RESULT);
        assertEquals(11, calculator.getResult());

        calculator.enter(Calculator.Operator.ADD);
        calculator.enter(3);
        calculator.enter(Calculator.Operator.RESULT);
        assertEquals(14, calculator.getResult());
        assertEquals(14, calculator.getResult());

        assertThrows(IllegalStateException.class, () -> calculator.enter(5));
    }
}
