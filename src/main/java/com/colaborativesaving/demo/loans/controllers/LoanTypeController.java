package com.colaborativesaving.demo.loans.controllers;

import com.colaborativesaving.demo.loans.controllers.contracts.RequestLoanType;
import com.colaborativesaving.demo.loans.controllers.contracts.ResponseLoanType;
import com.colaborativesaving.demo.loans.controllers.contracts.ResponseLoanTypes;
import org.springframework.http.ResponseEntity;

public interface LoanTypeController {
    public ResponseEntity<ResponseLoanTypes> retriveLoanTypes();
    public ResponseEntity<ResponseLoanType> retriveLoanType(String loanTypeName);
    public ResponseEntity<ResponseLoanType> createLoanType(RequestLoanType requestLoanType);
    public ResponseEntity<ResponseLoanType> deleteLoanType(String loanTypeName);
}
