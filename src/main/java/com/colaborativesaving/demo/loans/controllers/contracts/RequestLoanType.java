package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.LoanType;

public class RequestLoanType {

    private String name;
    private short number;
    private double installment;
    private float interest;

    public LoanType getType() {
        LoanType loanType = new LoanType();
        loanType.setLoanTypeName(this.name);
        loanType.setMaxNumberInstallments(this.number);
        loanType.setMinInstallmentValue(this.installment);
        loanType.setInterest(this.interest);
        return loanType;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getNumber() { return number; }

    public void setNumber(short number) { this.number = number; }

    public double getInstallment() { return installment; }

    public void setInstallment(long installment) { this.installment = installment; }

    public double getInterest() {
        return interest;
    }

    public void setInterest(float interest) { this.interest = interest; }
}
