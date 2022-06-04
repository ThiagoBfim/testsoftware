package org.sample;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.NumericChars;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.constraints.StringLength;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;

public class CalculatorPropertyBasedTest {
    private static Calculator calculator = new Calculator(mock(IDatabase.class));

    @Property(tries = 2000)
    void sumsOfSmallPositivesAreAlwaysPositive(@ForAll @Size(min = 1, max = 10) List<@NumericChars @StringLength(min = 10, max = 200) String> listOfStrings) {
        listOfStrings.forEach(a -> {
            BigInteger sum = calculator.sum(a, a);
            assertThat(sum).isGreaterThanOrEqualTo(BigInteger.ZERO);
        });
    }
}
