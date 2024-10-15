package org.example.bank.entity;

import java.util.Random;
public enum BankOfficeActive {
    WORKING,
    NOT_WORKING;

    private static final Random RANDOM = new Random();

    public static BankOfficeActive randomStatus()  {
        BankOfficeActive[] statuses = values();
        return statuses[RANDOM.nextInt(statuses.length)];
    }
}
