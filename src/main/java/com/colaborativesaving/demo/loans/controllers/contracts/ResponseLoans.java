package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.LoanMapper;

import java.util.List;

public class ResponseLoans {

    private double total;
    private List<LoanMapper> loans;

    public ResponseLoans(List<LoanMapper> loansForUser) {
        loansForUser.forEach(loanMapper -> {
            total += loanMapper.getTotal();
        });
        this.loans = loansForUser;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<LoanMapper> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanMapper> loans) {
        this.loans = loans;
    }
}
