package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.Amortization;
import com.colaborativesaving.demo.loans.model.Installment;
import com.colaborativesaving.demo.loans.model.InstallmentMapper;
import com.colaborativesaving.demo.loans.model.Loan;

import java.util.ArrayList;
import java.util.List;

public class ResponseAmortization {

    private String userName;
    private String loanType;
    private double total;
    private double interest;
    private double installmentValue;
    private double totalInstallments;

    private List<InstallmentMapper> installments;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(double installmentValue) {
        this.installmentValue = installmentValue;
    }

    public double getTotalInstallments() {
        return totalInstallments;
    }

    public void setTotalInstallments(double totalInstallments) {
        this.totalInstallments = totalInstallments;
    }

    public List<InstallmentMapper> getInstallments() {
        return installments;
    }

    public void setInstallments(List<InstallmentMapper> installments) {
        this.installments = installments;
    }

    public ResponseAmortization(Amortization amortization) {
        this.userName = amortization.getUserName();
        this.totalInstallments = amortization.getTotalInstallments();
        this.loanType = amortization.getLoanType();
        this.total = amortization.getTotal();
        this.installmentValue = amortization.getInstallmentValue();
        this.interest = amortization.getInterest();
        this.installments = new ArrayList<InstallmentMapper>();
        amortization.getInstallments().forEach(installment -> {
            try {
                installments.add(new InstallmentMapper(installment));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
