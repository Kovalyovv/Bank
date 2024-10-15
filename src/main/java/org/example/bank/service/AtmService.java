package org.example.bank.service;

import org.example.bank.entity.Bank;
import org.example.bank.entity.BankAtm;
import org.example.bank.entity.BankOffice;
import org.example.bank.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface AtmService {
    BankAtm createBankAtm(String name, String address, Bank bank, BankOffice location, Employee employee,
                          boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost);

    Optional<BankAtm> getBankAtmById(int id);

    List<BankAtm> getAllBankAtms();

    List<BankAtm> getAllBankAtmsByBank(Bank bank);

    void updateBankAtm(int id, String name);

    void deleteBankAtm(int id);
}
