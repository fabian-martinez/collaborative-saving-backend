package com.colaborativesaving.demo.loans.model;

public class LoanType {
    private String loanTypeName;
    private double minInstallmentValue;
    private short maxNumberInstallments;
    private float interest;

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }

    public double getMinInstallmentValue() {
        return minInstallmentValue;
    }

    public void setMinInstallmentValue(double minInstallmentValue) {
        this.minInstallmentValue = minInstallmentValue;
    }

    public short getMaxNumberInstallments() {
        return maxNumberInstallments;
    }

    public void setMaxNumberInstallments(short maxNumberInstallments) {
        this.maxNumberInstallments = maxNumberInstallments;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }
}
