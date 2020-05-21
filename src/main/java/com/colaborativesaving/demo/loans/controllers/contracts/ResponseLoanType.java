package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.LoanType;

public class ResponseLoanType {

    private String name;
    private short number;
    private double installment;

    public ResponseLoanType(LoanType type) {
        this.name = type.getLoanTypeName();
        this.installment = type.getMinInstallmentValue();
        this.number = type.getMaxNumberInstallments();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public double getInstallment() {
        return installment;
    }

    public void setInstallment(double installment) {
        this.installment = installment;
    }
}
