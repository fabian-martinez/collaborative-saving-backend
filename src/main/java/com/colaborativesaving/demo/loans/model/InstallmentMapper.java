package com.colaborativesaving.demo.loans.model;

public class InstallmentMapper {

    private InstalmentStateEnum state;
    private double installmentValue;
    private double total;
    private double balance;
    private int pendingInstallments;
    private double interest;

    public InstallmentMapper(Installment installment) throws Exception {
        this.state = InstalmentStateEnum.fromInteger(installment.getState());
        this.installmentValue = installment.getInstallmentValue();
        this.total = installment.getTotal();
        this.balance = installment.getBalance();
        this.pendingInstallments = installment.getPendingInstallments();
        this.interest = installment.getInterest();
    }

    public InstalmentStateEnum getState() {
        return state;
    }

    public void setState(InstalmentStateEnum state) {
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
