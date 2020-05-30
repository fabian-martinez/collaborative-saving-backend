package com.colaborativesaving.demo.loans.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "installment")
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false)
    private Loan loan;

    @Column(name = "state")
    private int state;

    @Column(name = "installment_value")
    private double installmentValue;

    @Column(name = "total")
    private double total;

    @Column(name = "balance")
    private double balance;

    @Column(name = "pendings_installment")
    private int pendingInstallments;

    @Column(name = "interest")
    private double interest;

    public Installment(Loan loan, double balace, double installmentValue, double interest, double total, int pendingInstallment) {
        this.balance = balace;
        this.installmentValue = installmentValue;
        this.interest = interest;
        this.total = total;
        this.pendingInstallments = pendingInstallment;
        this.state = InstalmentStateEnum.PENDING.getCode();
        this.loan = loan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
