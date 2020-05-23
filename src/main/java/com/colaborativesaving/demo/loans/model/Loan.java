package com.colaborativesaving.demo.loans.model;

import com.colaborativesaving.demo.loans.repository.LoanRepository;
import com.colaborativesaving.demo.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class Loan {
    private User user;
    private LoanType loanType;
    private double payment;
    private double installmentValue;
    private double total;
    private double balance;
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
        return interest;
    }

    public void setInterest(double shorterest) {
        this.interest = shorterest;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
