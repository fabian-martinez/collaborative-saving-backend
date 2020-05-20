package com.colaborativesaving.demo.loans.controllers;

import com.colaborativesaving.demo.loans.controllers.contracts.RequestLoanType;
import com.colaborativesaving.demo.loans.controllers.contracts.ResponseLoanType;
import com.colaborativesaving.demo.loans.controllers.contracts.ResponseLoanTypes;
import com.colaborativesaving.demo.loans.services.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loans/types")
public class LoanTypeControllerImpl implements LoanTypeController {

    @Autowired
    private LoansService loansService;

    @GetMapping("")
    public ResponseEntity<ResponseLoanTypes> retriveLoanTypes() {
        return new ResponseEntity<ResponseLoanTypes>(new ResponseLoanTypes(loansService.getTypes()), HttpStatus.OK);
    }

    @GetMapping("{loanTypeName}")
    public ResponseEntity<ResponseLoanType> retriveLoanType(@PathVariable(value = "loanTypeName")String loanTypeName) {
        return new ResponseEntity<ResponseLoanType>(new ResponseLoanType(loansService.getType(loanTypeName)), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseLoanType> createLoanType(@RequestBody RequestLoanType requestLoanType) {
        return new ResponseEntity<ResponseLoanType>(new ResponseLoanType(loansService.createType(requestLoanType.getType())), HttpStatus.OK);
    }


    @DeleteMapping("{loanTypeName}")
    public ResponseEntity<ResponseLoanType> deleteLoanType(@PathVariable(value = "loanTypeName")String loanTypeName) {
        return new ResponseEntity<ResponseLoanType>(new ResponseLoanType(loansService.deleteType(loanTypeName)), HttpStatus.OK);
    }
}
