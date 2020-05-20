package com.colaborativesaving.demo.loans.model;

public class LoanType {
    private String loanTypeName;
    private long minInstallmentValue;
    private int maxNumberInstallments;
    private double interest;

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }

    public long getMinInstallmentValue() {
        return minInstallmentValue;
    }

    public void setMinInstallmentValue(long minInstallmentValue) {
        this.minInstallmentValue = minInstallmentValue;
    }

    public int getMaxNumberInstallments() {
        return maxNumberInstallments;
    }

    public void setMaxNumberInstallments(int maxNumberInstallments) {
        this.maxNumberInstallments = maxNumberInstallments;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
