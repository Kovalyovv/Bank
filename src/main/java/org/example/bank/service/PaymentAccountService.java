package org.example.bank.service;

import org.example.bank.entity.Bank;
import org.example.bank.entity.PaymentAccount;
import org.example.bank.entity.User;

import java.util.List;
import java.util.Optional;

public interface PaymentAccountService {

    PaymentAccount createPaymentAccount(User user, Bank bank);

    Optional<PaymentAccount> getPaymentAccountById(int id);

    List<PaymentAccount> getAllPaymentAccounts();

    void updatePaymentAccount(int id, Bank bank);

    void deletePaymentAccount(int id);
}
