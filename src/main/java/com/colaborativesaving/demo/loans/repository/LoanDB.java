package com.colaborativesaving.demo.loans.repository;

import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.users.repository.UserDB;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "loan")
public class LoanDB {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(optional = false)
    private UserDB user;

    @ManyToOne
    private LoanTypeDB loanType;

    @Column(name = "installment_value")
    private double installmentValue;

    @Column(name = "total")
    private double total;

    @Column(name = "balance")
    private double balance;

    @Column(name = "total_installment")
    private short totalInstallments;

    @Column(name = "pendings_installment")
    private short pendingInstallments;

    @Column(name = "shorterest")
    private float shorterest;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Loan getLoan() throws Exception {
        Loan loan = new Loan();
        loan.setUser(this.user.getUser());
        loan.setTotal(this.total);
        loan.setBalance(this.balance);
        loan.setLoanType(this.loanType.getLoanType());
        loan.setInstallmentValue(this.installmentValue);
        loan.setInterest(this.shorterest);
        loan.setPendingInstallments(this.pendingInstallments);
        loan.setTotalInstallments(this.totalInstallments);
        return loan;
    }
}
