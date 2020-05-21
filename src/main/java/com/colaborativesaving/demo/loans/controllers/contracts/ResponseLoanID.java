package com.colaborativesaving.demo.loans.controllers.contracts;

import java.util.UUID;

public class ResponseLoanID {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ResponseLoanID(UUID id) {
        this.id = id;
    }
}
