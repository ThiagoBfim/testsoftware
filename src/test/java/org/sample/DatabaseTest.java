package org.sample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private static Database database = new Database();

    @Test
    void shouldInsertElement() {
        Database database = new Database();
        assertThat(database.get("1x1")).isEmpty();
        database.insert("1x1", BigInteger.ONE);
        assertThat(database.get("1x1")).isEqualTo(Optional.of(BigInteger.ONE));
    }

    @org.testng.annotations.Test(invocationCount = 100_000, threadPoolSize = 1_000)
    void shouldWorkWillMultiThread() {
        int nextInt = new Random().nextInt(0, 10000);
        database.insert("1x"+nextInt, BigInteger.valueOf(nextInt));
        assertThat(database.get("1x"+nextInt)).isEqualTo(Optional.of(BigInteger.valueOf(nextInt)));
    }
}