package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.LoanType;

public class ResponseLoanType {

    private String name;
    private int number;
    private long installment;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getInstallment() {
        return installment;
    }

    public void setInstallment(long installment) {
        this.installment = installment;
    }
}
