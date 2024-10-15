package org.example.bank.service.impl;


import org.example.bank.entity.*;
import org.example.bank.service.AtmService;
import org.example.bank.service.BankService;

import java.util.*;
import java.util.stream.Collectors;

public class BankAtmImpl  implements AtmService {

    private static int bankAtmsCount = 0;

    private List<BankAtm> bankAtms = new ArrayList<>();

    private final BankService bankService;

    public BankAtmImpl(BankService bankService) {
        this.bankService = bankService;
    }
    @Override
    public BankAtm createBankAtm(String name, String address, Bank bank, BankOffice location, Employee employee,
                                 boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost) {
        BankAtm bankAtm = new BankAtm(name, address, bank, location, employee,
                cashWithdrawal, cashDeposit, maintenanceCost);
        bankAtm.setId(bankAtmsCount++);
        bankAtm.setStatus(generateStatus());
        bankAtm.setAtmMoney(generateAtmMoney(bank));
        bankService.addAtm(bank.getId());
        bankAtms.add(bankAtm);
        return bankAtm;
    }


    private BankAtmActive generateStatus() {
        return BankAtmActive.randomStatus();
    }

    private double generateAtmMoney(Bank bank) {
        return new Random().nextDouble(bank.getTotalMoney());
    }
    @Override
    public Optional<BankAtm> getBankAtmById(int id) {
        return bankAtms.stream()
                .filter(bankAtm -> bankAtm.getId() == id)
                .findFirst();
    }
    @Override
    public List<BankAtm> getAllBankAtms() {
        return new ArrayList<>(bankAtms);
    }

    @Override
    public List<BankAtm> getAllBankAtmsByBank(Bank bank) {
        return bankAtms.stream()
                .filter(bankAtm -> bankAtm.getBank().getId() == bank.getId())
                .collect(Collectors.toList());
    }

    @Override
    public void updateBankAtm(int id, String name) {
        BankAtm bankAtm = getBankAtmIfExists(id);
        bankAtm.setName(name);
    }
    @Override
    public void deleteBankAtm(int id) {
        BankAtm bankAtm = getBankAtmIfExists(id);
        bankAtms.remove(bankAtm);
        Bank bank = bankAtm.getBank();
        bankService.removeAtm(bank.getId());
    }

    private BankAtm getBankAtmIfExists(int id) {
        return getBankAtmById(id).orElseThrow(() -> new NoSuchElementException("BankAtm was not found"));
    }
}
