package com.colaborativesaving.demo.models.loan;

import com.colaborativesaving.demo.models.entities.Loan;

import java.util.List;

public class ResponseLoans {

    private List<Loan> loans;

    public ResponseLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
