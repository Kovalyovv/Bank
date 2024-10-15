package org.example.bank.service.impl;



import org.example.bank.entity.*;
import org.example.bank.service.BankOfficeService;
import org.example.bank.service.BankService;

import java.util.*;

public class BankOfficeImpl  implements BankOfficeService {

    private static int bankOfficesCount = 0;

    private List<BankOffice> bankOffices = new ArrayList<>();

    private final BankService bankService;

    public BankOfficeImpl(BankService bankService) {
        this.bankService = bankService;
    }
    @Override
    public BankOffice createBankOffice(String name, String address, boolean canPlaceAtm,
                                       boolean canIssueLoan, boolean cashWithdrawal, boolean cashDeposit,
                                       double rentCost, Bank bank) {
        BankOffice bankOffice = new BankOffice(name, address, canPlaceAtm, canIssueLoan,
                cashWithdrawal, cashDeposit, rentCost, bank);
        bankOffice.setId(bankOfficesCount++);
        bankOffice.setStatus(generateActive());
        bankOffice.setOfficeMoney(generateOfficeMoney(bank));
        bankOffices.add(bankOffice);
        bankService.addOffice(bank.getId());
        return bankOffice;
    }


    private BankOfficeActive generateActive() {
        return BankOfficeActive.randomStatus();
    }

    @Override
    public Optional<BankOffice> getBankOfficeById(int id) {
        return bankOffices.stream()
                .filter(bankOffice -> bankOffice.getId() == id)
                .findFirst();
    }
    @Override
    public List<BankOffice> getAllBankOffices() {
        return new ArrayList<>(bankOffices);
    }
    @Override
    public void updateBankOffice(int id, String name) {
        BankOffice bankOffice = getBankOfficeIfExists(id);
        bankOffice.setName(name);
    }
    @Override
    public void deleteBankAtm(int officeId, int bankId) {
        BankOffice bankOffice = getBankOfficeIfExists(officeId);
        bankOffices.remove(bankOffice);
        bankService.removeOffice(bankId);
    }

    private BankOffice getBankOfficeIfExists(int id) {
        return getBankOfficeById(id).orElseThrow(() -> new NoSuchElementException("BankOffice was not found"));
    }

    private double generateOfficeMoney(Bank bank) {
        return new Random().nextDouble(bank.getTotalMoney());
    }
}
