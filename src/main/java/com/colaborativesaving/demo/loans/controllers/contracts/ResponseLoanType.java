package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.LoanType;

public class ResponseLoanType {

    private String name;
    private int maxInstallmenNumber;
    private double minInstallmentValue;
    private double interest;

    public ResponseLoanType(LoanType type) {
        this.name = type.getLoanTypeName();
        this.minInstallmentValue = type.getMinInstallmentValue();
        this.maxInstallmenNumber = type.getMaxNumberInstallments();
        this.interest = type.getInterest();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxInstallmenNumber() {
        return maxInstallmenNumber;
    }

    public void setMaxInstallmenNumber(int maxInstallmenNumber) {
        this.maxInstallmenNumber = maxInstallmenNumber;
    }

    public double getMinInstallmentValue() {
        return minInstallmentValue;
    }

    public void setMinInstallmentValue(double minInstallmentValue) {
        this.minInstallmentValue = minInstallmentValue;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
