package com.colaborativesaving.demo.loans.repository;

import com.colaborativesaving.demo.loans.model.Installment;
import com.colaborativesaving.demo.loans.model.InstalmentStateEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "installment")
public class InstallmentsDB {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(optional = false)
    private LoanDB loanDB;

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


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LoanDB getLoanDB() {
        return loanDB;
    }

    public void setLoanDB(LoanDB loanDB) {
        this.loanDB = loanDB;
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

    public void setInstallment(Installment installment) {
        this.total = installment.getTotal();
        this.state = installment.getInstalmentState().getCode();
        this.pendingInstallments = installment.getInstallmentNumber();
        this.interest = installment.getInterest();
        this.installmentValue = installment.getAbonoCapital();
        this.balance = installment.getBalance();
    }

    public Installment getInstalment() throws Exception {
        Installment installment = new Installment();
        installment.setInstalmentState(InstalmentStateEnum.fromInteger(this.state));
        installment.setInstallmentNumber(this.pendingInstallments);
        installment.setAbonoCapital(this.installmentValue);
        installment.setBalance(this.balance);
        installment.setInterest(this.interest);
        installment.setTotal(this.state);

        return installment;
    }
}
