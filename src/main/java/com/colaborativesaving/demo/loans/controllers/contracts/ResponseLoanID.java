package com.colaborativesaving.demo.loans.controllers.contracts;

public class ResponseLoanID {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResponseLoanID(long id) {
        this.id = id;
    }
}
