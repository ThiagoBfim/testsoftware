package org.sample;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sample.exception.DivisionByZeroNotAllowed;
import org.sample.exception.NotSupportedOperation;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private IDatabase database;
    @BeforeEach
    void setUp() {
        database = Mockito.mock(IDatabase.class);
    }

    @Test
    void shouldSumIntegerNumbers() {
        BigInteger sum = new Calculator(database).sum("1", "2");
        assertThat(sum).isEqualTo(3);
    }

    @Test
    void shouldRetrieveSumFromDatabase() {
        Calculator calculator = new Calculator(database);
        BigInteger sum = calculator.sum("1", "2");
        assertThat(sum).isEqualTo(3);
        sum = calculator.sum("1", "2");
        assertThat(sum).isEqualTo(3);
    }

    @Test
    void shouldSumBigIntegerNumbers() {
        BigInteger sum = new Calculator(database).sum("100000000000000000000", "200000000000000000000");
        assertThat(sum).isEqualTo(new BigInteger("300000000000000000000"));
    }

    @Test
    void shouldSubtractIntegerNumbers() {
        BigInteger subtraction = new Calculator(database).subtraction("1", "2");
        assertThat(subtraction).isEqualTo(-1);
    }

    @Test
    void shouldMultiplyIntegerNumbers() {
        BigInteger multiply = new Calculator(database).multiply("1", "2");
        assertThat(multiply).isEqualTo(2);
    }

    @Test
    void shouldDivideIntegerNumbers() {
        BigInteger division = new Calculator(database).division("4", "2");
        assertThat(division).isEqualTo(2);
    }

    @Test
    void shouldThrowExceptionWhenDivideByZero() {
        Calculator calculator = new Calculator(database);
        assertThatThrownBy(() -> calculator.division("4", "0"))
                .isInstanceOf(DivisionByZeroNotAllowed.class)
                .hasMessage("Division by zero not allowed, exception");
    }

    @Test
    void shouldThrowExceptionWhenDivideDoubleNumbers() {
        Calculator calculator = new Calculator(database);
        assertThatThrownBy(() -> calculator.division("4.5", "2.6"))
                .isInstanceOf(NotSupportedOperation.class)
                .hasMessage("Value not supported 4.5");
    }
}