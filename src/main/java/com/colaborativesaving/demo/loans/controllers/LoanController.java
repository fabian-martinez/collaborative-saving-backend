package com.colaborativesaving.demo.loans.controllers;

import com.colaborativesaving.demo.loans.controllers.contracts.*;
import org.springframework.http.ResponseEntity;


public interface LoanController {
    public ResponseEntity<ResponseLoanID> createLoan(RequestLoan requestLoanType) throws Exception;
    public ResponseEntity<ResponseLoan> updateLoan(RequestLoan requestLoan, String loanId) throws Exception;
    public ResponseEntity<ResponseAmortization> amortizateLoan(RequestAmortization amortization, String loanID) throws Exception;
    public ResponseEntity<ResponseAmortization> getAmotization(String loanID);
}
