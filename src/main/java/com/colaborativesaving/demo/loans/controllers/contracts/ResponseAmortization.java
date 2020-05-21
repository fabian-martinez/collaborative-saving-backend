package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.Installment;
import com.colaborativesaving.demo.loans.model.Loan;

import java.util.List;
import java.util.UUID;

public class ResponseAmortization {

    private double totalLoan;
    private double totalInstallments;
    private String userName;
    private UUID loanId;
    private List<Installment> installments;

    public ResponseAmortization(Loan amortizeLoan) {

    }
}
