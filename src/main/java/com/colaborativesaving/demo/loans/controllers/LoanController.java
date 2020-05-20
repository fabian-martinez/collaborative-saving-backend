package com.colaborativesaving.demo.loans.controllers;

import com.colaborativesaving.demo.loans.controllers.contracts.RequestLoan;
import com.colaborativesaving.demo.loans.controllers.contracts.ResponseLoan;
import com.colaborativesaving.demo.loans.controllers.contracts.ResponseLoanID;
import org.springframework.http.ResponseEntity;

public interface LoanController {
    public ResponseEntity<ResponseLoanID> createLoan(RequestLoan requestLoanType) throws Exception;
    public ResponseEntity<ResponseLoan> updateLoan(RequestLoan requestLoan, long loanId) throws Exception;
}
