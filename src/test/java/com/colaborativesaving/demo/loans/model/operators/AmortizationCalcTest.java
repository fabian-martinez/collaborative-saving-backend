package com.colaborativesaving.demo.loans.model.operators;

import com.colaborativesaving.demo.loans.model.Installment;
import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.loans.model.LoanType;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AmortizationCalcTest {

    @Autowired
    AmortizationCalc amortizationCalc;

    @Test
    void amortize() {
        List<Installment> amort = new ArrayList<Installment>();
        Loan loan = new Loan();
        LoanType loanType = new LoanType();
        amortizationCalc.Amortize(loan,450000.0);
    }
}