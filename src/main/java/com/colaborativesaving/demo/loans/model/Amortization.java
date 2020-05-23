package com.colaborativesaving.demo.loans.model;

import java.util.List;

public class Amortization {
    private String userName;
    private String loanType;
    private double total;
    private double interest;
    private double installmentValue;
    private double totalInstallments;

    private List<Installment> installments;

    public Amortization(Loan loan, List<Installment> amortization) {
        this.userName = loan.getUser().getUserName();
        this.totalInstallments = loan.getTotalInstallments();
        this.loanType = loan.getLoanType().getLoanTypeName();
        this.total = loan.getTotal();
        this.installmentValue = loan.getInstallmentValue();
        this.interest = loan.getInterest();
        this.installments = amortization;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(double installmentValue) {
        this.installmentValue = installmentValue;
    }

    public double getTotalInstallments() {
        return totalInstallments;
    }

    public void setTotalInstallments(double totalInstallments) {
        this.totalInstallments = totalInstallments;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void setInstallments(List<Installment> installments) {
        this.installments = installments;
    }
}
