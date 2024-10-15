package org.example.bank;
import org.example.bank.entity.*;
import org.example.bank.service.*;
import org.example.bank.service.impl.*;
import org.example.bank.utils.BankUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
        var bankBuilder = new BankUtils();
        var bank = bankBuilder.setBankName("KoBank").createBank();


        UserService userService = new UserImpl();
        User user = userService.createUser("Ковалев Дмитрий Сергеевич",LocalDate.of(2003, 10, 27), "Босс");

        BankService bankService = new BankImpl(userService);
        bankService.registerBank(bank);

        BankOfficeService bankOfficeService = new BankOfficeImpl(bankService);
        BankOffice bankOffice = bankOfficeService.createBankOffice(
                "Лахта Центр",
                " Санкт-Петербург, Лахтинский проспект, д. 2, корп. 3.",
                true,
                true,
                true,
                true,
                1000,
                bank
        );

        EmployeeService employeeService = new EmployeeImpl(bankService);
        Employee employee = employeeService.createEmployee(
                "Думин Валерий Витальевич",
                LocalDate.now(),
                "Ровный тип",
                bank,
                false,
                bankOffice,
                true,
                30000
        );

        AtmService bankAtmService = new BankAtmImpl(bankService);
        BankAtm bankAtm = bankAtmService.createBankAtm(
                "Бабломет",
                "Индустриальная 7",
                bank,
                bankOffice,
                employee,
                true,
                true,
                500
        );

        PaymentAccountService paymentAccountService = new PaymentAccountImpl(userService, bankService);
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(user, bank);

        CreditAccountService creditAccountService = new CreditAccountImpl(userService, bankService);
        CreditAccount creditAccount = creditAccountService.createCreditAccount(
                user,
                bank,
                LocalDate.now(),
                8,
                500000,
                15,
                employee,
                paymentAccount
        );

        System.out.println(bank);
        System.out.println(user);
        System.out.println(bankOffice);
        System.out.println(employee);
        System.out.println(bankAtm);
        System.out.println(paymentAccount);
        System.out.println(creditAccount);
    }




}
