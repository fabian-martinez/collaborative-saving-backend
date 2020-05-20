package com.colaborativesaving.demo.loans.model;

import com.colaborativesaving.demo.loans.repository.LoanRepository;
import com.colaborativesaving.demo.users.model.User;
import com.colaborativesaving.demo.users.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;

public class Loan {
    private User user;
    private LoanType loanType;
    private long installmentValue;
    private long total;
    private long balance;
    private int totalInstallments;
    private int pendingInstallments;
    private double interest;

    @Autowired
    private LoanRepository loanRepository;


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
