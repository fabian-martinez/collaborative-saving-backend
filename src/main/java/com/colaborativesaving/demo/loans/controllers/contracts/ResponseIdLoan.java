package com.colaborativesaving.demo.loans.controllers.contracts;

public class ResponseIdLoan {
    private long idLoan;

    public ResponseIdLoan(long id) {
        this.idLoan = id;
    }

    public long getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(long idLoan) {
        this.idLoan = idLoan;
    }

}
