package com.colaborativesaving.demo.models.loan;

import com.colaborativesaving.demo.models.entities.Loan;

public class ResponseLoan {
    private Loan loan;

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public ResponseLoan(Loan loan) {
        this.loan = loan;
    }
}
