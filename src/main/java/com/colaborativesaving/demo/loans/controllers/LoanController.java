package com.colaborativesaving.demo.loans.controllers;

import com.colaborativesaving.demo.loans.controllers.contracts.*;
import org.springframework.http.ResponseEntity;

public interface LoanController {
    public ResponseEntity<ResponseLoanID> createLoan(RequestLoan requestLoanType) throws Exception;
    public ResponseEntity<ResponseLoan> updateLoan(RequestLoan requestLoan, long loanId) throws Exception;
    public ResponseEntity<ResponseAmortization> amortizateLoan(RequestAmortization amortization, long loanID);
    public ResponseEntity<ResponseAmortization> getAmotization(long loanID);
}
