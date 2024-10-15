package org.example.bank.service;

import org.example.bank.entity.Bank;
import org.example.bank.entity.PaymentAccount;
import org.example.bank.entity.CreditAccount;
import org.example.bank.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface UserService {

    User createUser(String fullName, LocalDate birthDate, String job);

    Optional<User> getUserById(int id);

    List<User> getAllUsers();

    void updateUser(int id, String name);

    void deleteUser(int id);

    User getUserIfExists(int id);

    void addCreditAccount(CreditAccount creditAccount, User user);

    void addPaymentAccount(PaymentAccount paymentAccount, User user);

    void addBank(Bank bank, User user);

    void deleteCreditAccount(CreditAccount creditAccount, User user);

    void deletePaymentAccount(PaymentAccount paymentAccount, User user);

    void deleteBank(Bank bank);

}
