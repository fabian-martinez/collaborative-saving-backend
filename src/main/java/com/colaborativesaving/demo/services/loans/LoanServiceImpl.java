package com.colaborativesaving.demo.services.loans;

import com.colaborativesaving.demo.models.entities.Loan;
import com.colaborativesaving.demo.models.loan.RequestLoan;
import com.colaborativesaving.demo.models.loan.ResponseLoan;
import com.colaborativesaving.demo.models.loan.ResponseLoans;
import com.colaborativesaving.demo.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanServiceImpl implements LoansService {

    @Autowired
    LoanRepository loanRepository;

    @Override
    public ResponseLoans getLoans() {
        List<Loan> loans = new ArrayList<Loan>();
        loanRepository.findAll().forEach(loans::add);

        return new ResponseLoans(loans);
    }

    @Override
    public ResponseLoan getLoan(String loanType) {
        return new ResponseLoan(loanRepository.findByType(loanType).get(0));
    }

    @Override
    public ResponseLoan createLoan(RequestLoan loan) {
        return new ResponseLoan(loanRepository.save(loan.getLoan()));
    }

    @Override
    public ResponseLoan deleteLoan(String loanType) {
        Loan loan = loanRepository.findByType(loanType).get(0);
        loanRepository.delete(loan);
        return new ResponseLoan(loan);
    }

}
