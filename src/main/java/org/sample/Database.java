package org.sample;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Database implements IDatabase {

    private Map<String, BigInteger> database = new HashMap<>();

    @Override
    public void insert(String operation, BigInteger result) {
        database.put(operation, result);
    }

    @Override
    public Optional<BigInteger> get(String operation) {
        if (database.containsKey(operation)) {
            return Optional.ofNullable(database.get(operation));
        }
        return Optional.empty();
    }
}
