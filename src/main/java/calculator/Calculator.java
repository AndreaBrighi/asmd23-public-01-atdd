package calculator;

import java.util.*;

public class Calculator {

    private interface CalculatorElement {
        boolean isOperator();

        boolean isNumber();
    }

    public enum Operator {
        ADD,
        SUBTRACT,
        RESULT
    }

    private record OperatorElement(Operator operator) implements CalculatorElement {

        @Override
            public boolean isOperator() {
                return true;
            }

            @Override
            public boolean isNumber() {
                return false;
            }
        }

    private record NumberElement(double value) implements CalculatorElement {

        @Override
            public boolean isOperator() {
                return false;
            }

        @Override
            public boolean isNumber() {
                return true;
            }
        }
    private final List<CalculatorElement> numbers = new LinkedList<>();

    public void enter(double i){
        if (!numbers.isEmpty() && numbers.getLast().isNumber()) {
            throw new IllegalStateException();
        }
        numbers.add(new NumberElement(i));
    }

    public void enter(Calculator.Operator operator){
        if(numbers.isEmpty()){
            throw new IllegalStateException();
        }else if(numbers.getLast().isOperator()){
            numbers.removeLast();
        }
        if(operator != Calculator.Operator.RESULT){
            numbers.add(new OperatorElement(operator));
        }else {
            while(numbers.size() > 1){
                double first = ((NumberElement)numbers.removeFirst()).value();
                Operator operator1 = ((OperatorElement)numbers.removeFirst()).operator();
                double second = ((NumberElement)numbers.removeFirst()).value();
                switch (operator1){
                    case ADD -> numbers.addFirst(new NumberElement(first + second));
                    case SUBTRACT -> numbers.addFirst(new NumberElement(first - second));
                }
            }

        }

    }

    public double getResult(){
        if (numbers.size() != 1 && !numbers.getLast().isNumber()) {
            throw new IllegalStateException();
        }
        return ((NumberElement)numbers.getFirst()).value();
    }
}