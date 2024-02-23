package calculator;

import java.util.*;

public class Calculator {
    private final List<Double> numbers = new LinkedList<>();

    public void enter(double i){
        numbers.add(i);
        if (numbers.size() > 2){
            throw new IllegalStateException();
        }
    }

    public void add(){
        if (numbers.size() != 2){
            throw new IllegalStateException();
        }
        numbers.set(0, numbers.get(0) + numbers.get(1));
        numbers.remove(1);
    }

    public double getResult(){
        if (numbers.size() != 1){
            throw new IllegalStateException();
        }
        return numbers.getFirst();
    }
}
