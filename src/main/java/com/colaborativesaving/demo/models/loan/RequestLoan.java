package com.colaborativesaving.demo.models.loan;

import com.colaborativesaving.demo.models.entities.Loan;

public class RequestLoan {

    private Loan loan;

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public RequestLoan(Loan loan) {
        this.loan = loan;
    }
}
