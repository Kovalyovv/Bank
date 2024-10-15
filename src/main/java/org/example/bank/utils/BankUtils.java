package org.example.bank.utils;

import org.example.bank.entity.Bank;

import java.util.Random;

public class BankUtils {
    private String bankName;

    private static final int RATING_BOUND = 101;
    private static final int TOTAL_MONEY_BOUND = 1000001;
    private static final int MAX_RATE = 20;
    private static final double DIVIDER = 10.0;

    private int generateId() {
        return new Random().nextInt();
    }

    private int generateRating() {
        return new Random().nextInt(RATING_BOUND);
    }

    private double generateTotalMoney() {
        return new Random().nextInt(TOTAL_MONEY_BOUND);
    }


    private double calculateInterestRate(int rating) {
        return MAX_RATE - (rating / DIVIDER);
    }


    public BankUtils setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public Bank createBank() {
        var id = generateId();
        var rating = generateRating();
        var totalMoney = generateTotalMoney();
        var calculateInterestRate = calculateInterestRate(rating);

        return new Bank(id, bankName, rating, totalMoney, calculateInterestRate);
    }
}
