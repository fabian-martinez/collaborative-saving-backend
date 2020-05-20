package com.colaborativesaving.demo.loans.repository;

import com.colaborativesaving.demo.loans.model.LoanType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "loan_type")
public class LoanTypeDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "name", unique = true)
    private String loanTypeName;

    @Column(name = "min_installment_value")
    private long minInstallmentValue;

    @Column(name = "max_number_installments")
    private int maxNumberInstallments;

    @Column(name = "interest")
    private double interest;


    public LoanType getLoanType(){
        LoanType loanType = new LoanType();
        loanType.setLoanTypeName(this.loanTypeName);
        loanType.setMaxNumberInstallments(this.maxNumberInstallments);
        loanType.setMinInstallmentValue(this.minInstallmentValue);
        loanType.setInterest(this.interest);
        return loanType;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }

    public long getMinInstallmentValue() {
        return minInstallmentValue;
    }

    public void setMinInstallmentValue(long minInstallmentValue) {
        this.minInstallmentValue = minInstallmentValue;
    }

    public int getMaxNumberInstallments() {
        return maxNumberInstallments;
    }

    public void setMaxNumberInstallments(int maxNumberInstallments) {
        this.maxNumberInstallments = maxNumberInstallments;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
