package org.sample.exception;

public class NotSupportedOperation extends RuntimeException {
    public NotSupportedOperation(NumberFormatException exception, String value) {
        super(String.format("Value not supported %s", value), exception);
    }
}
