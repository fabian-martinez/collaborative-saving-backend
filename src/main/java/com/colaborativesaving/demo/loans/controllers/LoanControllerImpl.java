package com.colaborativesaving.demo.loans.controllers;

import com.colaborativesaving.demo.loans.controllers.contracts.*;
import com.colaborativesaving.demo.loans.services.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
            @RequestBody RequestLoan requestLoan, @PathVariable(value = "loanId") String loanId) throws Exception {
        return new ResponseEntity<ResponseLoan>(new ResponseLoan(loansService.updateLoan(requestLoan,UUID.fromString(loanId))),HttpStatus.OK);
    }


    @PostMapping("{loanId}/amortization")
    public ResponseEntity<ResponseAmortization> amortizateLoan(
            @RequestBody RequestAmortization amortization, @PathVariable(value = "loanId") String loanId) throws Exception {
        return new ResponseEntity<ResponseAmortization>(new ResponseAmortization(loansService.amortizeLoan(amortization, UUID.fromString(loanId))),HttpStatus.OK);
    }

    @GetMapping("{loanId}/amortization")
    public ResponseEntity<ResponseAmortization> getAmotization(@PathVariable(value = "loanId") String loanID) {
        return null;
    }
}
