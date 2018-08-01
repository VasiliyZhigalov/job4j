package ru.job4j.calculator;

/**
 * Calculator.
 * @author Vasiliy Zhigalov
 */
public class Calculator {
    /**
     * calculatoin result.
     */
    private double result;

    /**
     *  Add first and second.
     * @param first
     * @param second
     */
    public void add(double first, double second) {
        this.result=first+second;
    }

    /**
     * Substract from the first second.
     * @param first
     * @param second
     */
    public void subtract(double first, double second) {
        this.result=first-second;
    }

    /**
     * Divide the first into the second
     * @param first
     * @param second
     */
    public void div(double first, double second) {
        this.result=first/second;
    }

    /**
     * Multiple first and second
     * @param first
     * @param second
     */
    public void multiple(double first, double second) {
        this.result=first*second;
    }
    public double getResult() {
        return result;
    }
}

