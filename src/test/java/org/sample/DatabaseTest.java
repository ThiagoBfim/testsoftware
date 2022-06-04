package org.sample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void shouldInsertElement() {
        Database database = new Database();
        assertThat(database.get("1x1")).isEmpty();
        database.insert("1x1", BigInteger.ONE);
        assertThat(database.get("1x1")).isEqualTo(Optional.of(BigInteger.ONE));
    }
}