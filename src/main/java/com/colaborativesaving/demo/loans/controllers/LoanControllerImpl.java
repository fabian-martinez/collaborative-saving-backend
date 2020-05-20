package com.colaborativesaving.demo.loans.controllers;

import com.colaborativesaving.demo.loans.controllers.contracts.RequestLoan;
import com.colaborativesaving.demo.loans.controllers.contracts.ResponseLoan;
import com.colaborativesaving.demo.loans.controllers.contracts.ResponseLoanID;
import com.colaborativesaving.demo.loans.services.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanControllerImpl implements LoanController {
    
    @Autowired
    LoansService loansService;

    @PostMapping("")
    public ResponseEntity<ResponseLoanID> createLoan(@RequestBody RequestLoan requestLoan) throws Exception {
        return new ResponseEntity<ResponseLoanID>(new ResponseLoanID(loansService.createLoan(requestLoan)), HttpStatus.OK);
    }

    @PutMapping("{loanId}")
    public ResponseEntity<ResponseLoan> updateLoan(
            @RequestBody RequestLoan requestLoan, @PathVariable(value = "loanId")long loanId) throws Exception {
        return new ResponseEntity<ResponseLoan>(new ResponseLoan(loansService.updateLoan(requestLoan,loanId)),HttpStatus.OK);
    }
}
