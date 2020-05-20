package com.colaborativesaving.demo.loans.repository;

import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.loans.model.LoanType;
import com.colaborativesaving.demo.users.model.User;
import com.colaborativesaving.demo.users.repository.UserDB;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "loan")
public class LoanDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(optional = false)
    private UserDB user;

    @ManyToOne
    private LoanTypeDB loanType;

    @Column(name = "installment_value")
    private long installmentValue;

    @Column(name = "total")
    private long total;

    @Column(name = "balance")
    private long balance;

    @Column(name = "total_installment")
    private int totalInstallments;

    @Column(name = "pendings_installment")
    private int pendingInstallments;

    @Column(name = "interest")
    private double interest;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDB getUser() {
        return user;
    }

    public void setUser(UserDB user) {
        this.user = user;
    }

    public LoanTypeDB getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanTypeDB loanType) {
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

    public Loan getLoan() throws Exception {
        Loan loan = new Loan();
        loan.setUser(this.user.getUser());
        loan.setTotal(this.total);
        loan.setBalance(this.balance);
        loan.setLoanType(this.loanType.getLoanType());
        loan.setInstallmentValue(this.installmentValue);
        loan.setInterest(this.interest);
        loan.setPendingInstallments(this.pendingInstallments);
        loan.setTotalInstallments(this.totalInstallments);
        return loan;
    }
}
