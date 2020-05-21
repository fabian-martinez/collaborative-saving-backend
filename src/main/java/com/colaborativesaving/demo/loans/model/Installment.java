package com.colaborativesaving.demo.loans.model;

public class Installment {
    private double balance;
    private double abonoCapital;
    private double shorterest;
    private double total;
    private short installmentNumber;

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
        return shorterest;
    }

    public void setInterest(double shorterest) {
        this.shorterest = shorterest;
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

}
