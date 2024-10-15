package org.example.bank.service.impl;

import org.example.bank.entity.Bank;
import org.example.bank.entity.BankOffice;
import org.example.bank.entity.Employee;
import org.example.bank.service.BankService;
import org.example.bank.service.EmployeeService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;



public class EmployeeImpl implements EmployeeService {
    private static int employeesCount = 0;

    private final BankService bankService;

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeImpl(BankService bankService) {
        this.bankService = bankService;
    }
    @Override
    public Employee createEmployee(String fullName, LocalDate birthDate, String position, Bank bank, boolean remoteWork,
                                   BankOffice bankOffice, boolean canIssueLoans, double salary) {
        Employee employee = new Employee(fullName, birthDate, position, bank, remoteWork,
                bankOffice, canIssueLoans, salary);
        employee.setId(employeesCount++);
        employees.add(employee);
        bankService.addEmployee(bank.getId());
        return employee;
    }
    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }
    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
    @Override
    public void updateEmployee(int id, String name) {
        Employee employee = getEmployeeIfExists(id);
        employee.setFullName(name);
    }
    @Override
    public void deleteEmployee(int id) {
        employees.remove(getEmployeeIfExists(id));
    }
    @Override
    public Employee getEmployeeIfExists(int id) {
        return getEmployeeById(id).orElseThrow(() -> new NoSuchElementException("Employee was not found"));
    }


}
