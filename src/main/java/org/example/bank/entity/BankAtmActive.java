package org.example.bank.entity;

import java.util.Random;
public enum BankAtmActive {
    WORKING,
    NOT_WORKING,
    NO_MONEY;

    private static final Random
            RANDOM = new Random();

    public static BankAtmActive randomStatus()  {
        BankAtmActive[] statuses = values();
        return statuses[RANDOM.nextInt(statuses.length)];
    }
}
