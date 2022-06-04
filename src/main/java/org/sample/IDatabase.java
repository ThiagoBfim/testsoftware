package org.sample;

import java.math.BigInteger;
import java.util.Optional;

public interface IDatabase {
    void insert(String operation, BigInteger result);
    Optional<BigInteger> get(String operation);
}
