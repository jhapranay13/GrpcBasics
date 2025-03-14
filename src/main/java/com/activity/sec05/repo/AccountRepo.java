package com.activity.sec05.repo;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountRepo {

    private static final Map<Integer, Integer> db = IntStream.rangeClosed(1, 10)
            .boxed()
            .collect(Collectors.toConcurrentMap(k -> k, v -> v * 100));

    public static Integer getBalance(Integer accountNumber) {
        return db.get(accountNumber);
    }

    public static Map<Integer, Integer> getAllAccounts() {
        return Collections.unmodifiableMap(db);
    }

    public static void updateBalance(Integer accountNumber, Integer amount) {
        db.put(accountNumber, db.get(accountNumber) - amount);
    }
}
