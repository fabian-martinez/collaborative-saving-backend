package com.colaborativesaving.demo.loans.controllers.contracts;

import com.colaborativesaving.demo.loans.model.LoanType;

import java.util.List;

public class ResponseLoanTypes {

    List<LoanType> loanTypes;

    public ResponseLoanTypes(List<LoanType> loanTypeList) {
        this.loanTypes = loanTypeList;
    }

    public List<LoanType> getLoanTypes() {
        return loanTypes;
    }

    public void setLoanTypes(List<LoanType> loanTypes) {
        this.loanTypes = loanTypes;
    }
}
