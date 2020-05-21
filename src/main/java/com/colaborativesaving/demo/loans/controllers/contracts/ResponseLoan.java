package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.loans.model.LoanType;
import com.colaborativesaving.demo.users.model.User;

public class ResponseLoan {

    private User user;
    private LoanType loanType;
    private double installmentValue;
    private double total;
    private double balance;
    private short totalInstallments;
    private short pendingInstallments;
    private float shorterest;

    public ResponseLoan(Loan updateLoan) {
        this.user = updateLoan.getUser();
        this.loanType = updateLoan.getLoanType();
        this.installmentValue = updateLoan.getInstallmentValue();
        this.total = updateLoan.getTotal();
        this.balance = updateLoan.getBalance();
        this.totalInstallments = updateLoan.getTotalInstallments();
        this.pendingInstallments = updateLoan.getPendingInstallments();
        this.shorterest = updateLoan.getInterest();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
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

    public short getTotalInstallments() {
        return totalInstallments;
    }

    public void setTotalInstallments(short totalInstallments) {
        this.totalInstallments = totalInstallments;
    }

    public short getPendingInstallments() {
        return pendingInstallments;
    }

    public void setPendingInstallments(short pendingInstallments) {
        this.pendingInstallments = pendingInstallments;
    }

    public float getInterest() {
        return shorterest;
    }

    public void setInterest(float shorterest) {
        this.shorterest = shorterest;
    }
}
