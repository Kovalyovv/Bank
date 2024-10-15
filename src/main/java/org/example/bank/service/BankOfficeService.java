package org.example.bank.service;

import org.example.bank.entity.Bank;
import org.example.bank.entity.BankOffice;

import java.util.List;
import java.util.Optional;

public interface BankOfficeService {

    BankOffice createBankOffice(String name, String address, boolean canPlaceAtm,
                                boolean canIssueLoan, boolean cashWithdrawal, boolean cashDeposit,
                                double rentCost, Bank bank);

    Optional<BankOffice> getBankOfficeById(int id);

    List<BankOffice> getAllBankOffices();

    void updateBankOffice(int id, String name);

    void deleteBankAtm(int officeId, int bankId);

}
