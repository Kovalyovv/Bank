package org.example.bank.entity;
import lombok.Getter;

import java.util.List;


public class Bank {
    private int id;
    private String name;
    private int officeCount = 0;
    private int atmCount = 0;
    private int employeeCount = 0;
    private int clientCount = 0;
    private int rating;
    private double totalMoney;
    private double interestRate;

    public Bank(int id, String name, int rating, double totalMoney, double interestRate) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.totalMoney = totalMoney;
        this.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOfficeCount() {
        return officeCount;
    }

    public int getAtmCount() {
        return atmCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public int getClientCount() {
        return clientCount;
    }

    public int getRating() {
        return rating;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRating(int rating) {
        if(rating < 0) return;
        this.rating = rating;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOfficeCount(int officeCount) {
        if(officeCount < 0) return;
        this.officeCount = officeCount;
    }

    public void setAtmCount(int atmCount) {
        if(atmCount < 0) return;
        this.atmCount = atmCount;
    }

    public void setEmployeeCount(int employeeCount) {
        if(employeeCount < 0) return;
        this.employeeCount = employeeCount;
    }

    public void setClientCount(int clientCount) {
        if(clientCount < 0) return;
        this.clientCount = clientCount;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", officeCount=" + officeCount +
                ", atmCount=" + atmCount +
                ", employeeCount=" + employeeCount +
                ", clientCount=" + clientCount +
                ", rating=" + rating +
                ", totalMoney=" + totalMoney +
                ", interestRate=" + interestRate +
                '}';
    }
}