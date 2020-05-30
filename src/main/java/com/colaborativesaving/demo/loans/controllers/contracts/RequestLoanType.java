package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.LoanType;

public class RequestLoanType {

    private String name;
    private int maxInstallmenNumber;
    private double minInstallmentValue;
    private double interest;

    public LoanType getType() {
        LoanType loanType = new LoanType();
        loanType.setLoanTypeName(this.name);
        loanType.setMaxNumberInstallments(this.maxInstallmenNumber);
        loanType.setMinInstallmentValue(this.minInstallmentValue);
        loanType.setInterest(this.interest);
        return loanType;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getMaxInstallmenNumber() { return maxInstallmenNumber; }

    public void setMaxInstallmenNumber(int maxInstallmenNumber) { this.maxInstallmenNumber = maxInstallmenNumber; }

    public double getMinInstallmentValue() { return minInstallmentValue; }

    public void setMinInstallmentValue(long minInstallmentValue) { this.minInstallmentValue = minInstallmentValue; }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) { this.interest = interest; }
}
