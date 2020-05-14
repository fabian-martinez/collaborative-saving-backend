package com.colaborativesaving.demo.services.loans;

import com.colaborativesaving.demo.models.loan.RequestLoan;
import com.colaborativesaving.demo.models.loan.ResponseLoan;
import com.colaborativesaving.demo.models.loan.ResponseLoans;
import org.springframework.http.HttpStatus;

public interface LoansService {
    ResponseLoans getLoans();

    ResponseLoan getLoan(String loanType);

    ResponseLoan createLoan(RequestLoan loan);

    ResponseLoan deleteLoan(String loanType);
}
