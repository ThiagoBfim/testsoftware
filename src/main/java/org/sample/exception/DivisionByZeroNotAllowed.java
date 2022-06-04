package org.sample.exception;

public class DivisionByZeroNotAllowed extends RuntimeException {
    public DivisionByZeroNotAllowed(ArithmeticException exception) {
        super("Division by zero not allowed, exception", exception);
    }
}
