package org.sample;

import org.sample.exception.DivisionByZeroNotAllowed;
import org.sample.exception.NotSupportedOperation;

import java.math.BigInteger;

public class Calculator {
    final IDatabase database;

    public Calculator(IDatabase database) {
        this.database = database;
    }


    public BigInteger sum(String x, String y) {
        String operation = String.format("%s+%s", x, y);

        return database.get(operation)
                .orElseGet(() -> {
                    BigInteger sum = parseToBigInt(x).add(parseToBigInt(y));
                    database.insert(operation, sum);
                    return sum;
                });
    }

    public BigInteger subtraction(String x, String y) {
        return parseToBigInt(x).subtract(parseToBigInt(y));
    }

    public BigInteger multiply(String x, String y) {
        return parseToBigInt(x).multiply(parseToBigInt(y));
    }

    public BigInteger division(String x, String y) {
        try {
            return parseToBigInt(x).divide(parseToBigInt(y));
        } catch (ArithmeticException exception) {
            throw new DivisionByZeroNotAllowed(exception);
        }
    }

    private BigInteger parseToBigInt(String value) {
        try {
            return new BigInteger(value);
        } catch (NumberFormatException exception) {
            throw new NotSupportedOperation(exception, value);
        }
    }


}
