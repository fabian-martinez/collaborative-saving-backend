package com.colaborativesaving.demo.loans.controllers.contracts;

public class RequestAmortization {

    private double installmentValue;
    private short numberInstallments;

    public double getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(double installmentValue) {
        this.installmentValue = installmentValue;
    }

    public short getNumberInstallments() {
        return numberInstallments;
    }

    public void setNumberInstallments(short numberInstallments) {
        this.numberInstallments = numberInstallments;
    }
}
