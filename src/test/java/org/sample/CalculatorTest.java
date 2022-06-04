package org.sample;



import org.junit.jupiter.api.Test;
import org.sample.exception.DivisionByZeroNotAllowed;
import org.sample.exception.NotSupportedOperation;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    void shouldSumIntegerNumbers() {
        BigInteger sum = new Calculator().sum("1", "2");
        assertThat(sum).isEqualTo(3);
    }

    @Test
    void shouldSumBigIntegerNumbers() {
        BigInteger sum = new Calculator().sum("100000000000000000000", "200000000000000000000");
        assertThat(sum).isEqualTo(new BigInteger("300000000000000000000"));
    }

    @Test
    void shouldSubtractIntegerNumbers() {
        BigInteger subtraction = new Calculator().subtraction("1", "2");
        assertThat(subtraction).isEqualTo(-1);
    }

    @Test
    void shouldMultiplyIntegerNumbers() {
        BigInteger multiply = new Calculator().multiply("1", "2");
        assertThat(multiply).isEqualTo(2);
    }

    @Test
    void shouldDivideIntegerNumbers() {
        BigInteger division = new Calculator().division("4", "2");
        assertThat(division).isEqualTo(2);
    }

    @Test
    void shouldThrowExceptionWhenDivideByZero() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.division("4", "0"))
                .isInstanceOf(DivisionByZeroNotAllowed.class)
                .hasMessage("Division by zero not allowed, exception");
    }

    @Test
    void shouldThrowExceptionWhenDivideDoubleNumbers() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.division("4.5", "2.6"))
                .isInstanceOf(NotSupportedOperation.class)
                .hasMessage("Value not supported 4.5");
    }
}