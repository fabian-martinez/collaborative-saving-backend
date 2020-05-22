package com.colaborativesaving.demo.loans.model;

public class Installment {
    private double balance;
    private double abonoCapital;
    private double interest;
    private double total;
    private short installmentNumber;

    public Installment(double balance, double abonoCapital, double interest, double total, short installmentNumber) {
        this.balance = balance;
        this.abonoCapital = abonoCapital;
        this.interest = interest;
        this.total = total;
        this.installmentNumber = installmentNumber;
    }

    public Installment() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAbonoCapital() {
        return abonoCapital;
    }

    public void setAbonoCapital(double abonoCapital) {
        this.abonoCapital = abonoCapital;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double shorterest) {
        this.interest = shorterest;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public short getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(short installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "balance=" + balance +
                ", abonoCapital=" + abonoCapital +
                ", interest=" + interest +
                ", total=" + total +
                ", installmentNumber=" + installmentNumber +
                '}';
    }
}
