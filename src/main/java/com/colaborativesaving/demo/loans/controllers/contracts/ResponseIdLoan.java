package com.colaborativesaving.demo.loans.controllers.contracts;

import java.util.UUID;

public class ResponseIdLoan {
    private UUID idLoan;

    public ResponseIdLoan(UUID id) {
        this.idLoan = id;
    }

    public UUID getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(UUID idLoan) {
        this.idLoan = idLoan;
    }

}
