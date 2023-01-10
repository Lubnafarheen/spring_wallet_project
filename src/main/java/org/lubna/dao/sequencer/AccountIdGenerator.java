package org.lubna.dao.sequencer;

public class AccountIdGenerator {

    private static long sequencer = 0;

    private static final int MIN = 100000;
    private static final int MAX = 999999;

    private static long nextId() {
        return ++sequencer;
    }

    private static long getRandomNumber() {
        return (long) (Math.random() * (MAX - MIN) + MIN);
    }

    public static long generateAccountNumber() {
        return Long.parseLong(nextId() + "" + getRandomNumber());
    }
}
