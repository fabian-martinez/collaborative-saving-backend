package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.Loan;

public class ResponseLoan {

    private String user;
    private String loanType;
    private double installmentValue;
    private double total;
    private double balance;
    private int totalInstallments;
    private int pendingInstallments;
    private double shorterest;

    public ResponseLoan(Loan updateLoan) {
        this.user = updateLoan.getUser().getUserName();
        this.loanType = updateLoan.getLoanType().getLoanTypeName();
        this.installmentValue = updateLoan.getInstallmentValue();
        this.total = updateLoan.getTotal();
        this.balance = updateLoan.getBalance();
        this.totalInstallments = updateLoan.getTotalInstallments();
        this.pendingInstallments = updateLoan.getPendingInstallments();
        this.shorterest = updateLoan.getInterest();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(double installmentValue) {
        this.installmentValue = installmentValue;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getTotalInstallments() {
        return totalInstallments;
    }

    public void setTotalInstallments(int totalInstallments) {
        this.totalInstallments = totalInstallments;
    }

    public int getPendingInstallments() {
        return pendingInstallments;
    }

    public void setPendingInstallments(int pendingInstallments) {
        this.pendingInstallments = pendingInstallments;
    }

    public double getInterest() {
        return shorterest;
    }

    public void setInterest(double shorterest) {
        this.shorterest = shorterest;
    }

}
