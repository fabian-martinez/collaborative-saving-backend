package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.loans.model.LoanType;
import com.colaborativesaving.demo.users.model.User;

public class ResponseLoan {

    private User user;
    private LoanType loanType;
    private long installmentValue;
    private long total;
    private long balance;
    private int totalInstallments;
    private int pendingInstallments;
    private double interest;

    public ResponseLoan(Loan updateLoan) {
        this.user = updateLoan.getUser();
        this.loanType = updateLoan.getLoanType();
        this.installmentValue = updateLoan.getInstallmentValue();
        this.total = updateLoan.getTotal();
        this.balance = updateLoan.getBalance();
        this.totalInstallments = updateLoan.getTotalInstallments();
        this.pendingInstallments = updateLoan.getPendingInstallments();
        this.interest = updateLoan.getInterest();
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

    public long getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(long installmentValue) {
        this.installmentValue = installmentValue;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
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
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
