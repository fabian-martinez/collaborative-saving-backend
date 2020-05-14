package com.colaborativesaving.demo.controllers;

import com.colaborativesaving.demo.models.loan.RequestLoan;
import com.colaborativesaving.demo.models.loan.ResponseLoan;
import com.colaborativesaving.demo.models.loan.ResponseLoans;
import com.colaborativesaving.demo.services.loans.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loans")
public class loansController {

    @Autowired
    private LoansService loansService;

    @GetMapping("")
    public ResponseEntity<ResponseLoans> retriveLoans(){
        return new ResponseEntity<ResponseLoans>(loansService.getLoans(), HttpStatus.OK);
    }

    @GetMapping("/{loan}")
    public ResponseEntity<ResponseLoan> retriveLoan(@PathVariable(value = "loan") String loanType){
        return new ResponseEntity<ResponseLoan>(loansService.getLoan(loanType),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseLoan> createLoan(@RequestBody RequestLoan loan){
        return new ResponseEntity<ResponseLoan>(loansService.createLoan(loan),HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<ResponseLoan> deleteLoan(@PathVariable(value = "loan") String loanType){
        return new ResponseEntity<ResponseLoan>(loansService.deleteLoan(loanType),HttpStatus.OK);
    }
}
