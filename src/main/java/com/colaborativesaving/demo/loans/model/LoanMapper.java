package com.colaborativesaving.demo.loans.model;

import java.util.UUID;

public class LoanMapper {

    private UUID id;
    private String type;
    private double installment;
    private int pending;
    private int installments;
    private LoanStateEnum state;
    private double total;

    public LoanMapper(Loan loan) throws Exception {
        this.id = loan.getId();
        this.type = loan.getLoanType().getLoanTypeName();
        this.installment = loan.getPayment();
        this.pending = loan.getPendingInstallments();
        this.installments = loan.getTotalInstallments();
        this.state = LoanStateEnum.fromInteger(loan.getState());
        this.total = loan.getTotal();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getInstallment() {
        return installment;
    }

    public void setInstallment(double installment) {
        this.installment = installment;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public LoanStateEnum getState() {
        return state;
    }

    public void setState(LoanStateEnum state) {
        this.state = state;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
