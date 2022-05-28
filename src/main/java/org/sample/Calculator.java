package org.sample;

public class Calculator {

    public int sum(String x, String y) {
        return parseToInt(x) + parseToInt(y);
    }

    public int subtraction(String x, String y) {
        return parseToInt(x) - parseToInt(y);
    }

    public int multiply(String x, String y) {
        return parseToInt(x) * parseToInt(y);
    }

    public int division(String x, String y) {
        return parseToInt(x) / parseToInt(y);
    }

    private int parseToInt(String value) {
        return Integer.parseInt(value);
    }
}
