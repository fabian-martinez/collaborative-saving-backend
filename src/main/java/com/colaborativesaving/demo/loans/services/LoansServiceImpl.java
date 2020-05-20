package com.colaborativesaving.demo.loans.services;

import com.colaborativesaving.demo.loans.controllers.contracts.RequestLoan;
import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.loans.model.LoanType;
import com.colaborativesaving.demo.loans.repository.LoanDB;
import com.colaborativesaving.demo.loans.repository.LoanRepository;
import com.colaborativesaving.demo.loans.repository.LoanTypeDB;
import com.colaborativesaving.demo.loans.repository.LoanTypeRepository;
import com.colaborativesaving.demo.users.repository.UserRepository;
import com.colaborativesaving.demo.users.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoansServiceImpl implements LoansService {

    @Autowired
    private LoanTypeRepository loanTypeRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<LoanType> getTypes() {
        List<LoanType> loanTypeList = new ArrayList<LoanType>();
        loanTypeRepository.findAll().forEach(loanTypeDB -> {
            try {
                loanTypeList.add(loanTypeDB.getLoanType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return loanTypeList;
    }

    @Override
    public LoanType createType(LoanType type) {
        LoanTypeDB loanTypeDB = new LoanTypeDB();
        loanTypeDB.setLoanTypeName(type.getLoanTypeName());
        loanTypeDB.setMaxNumberInstallments(type.getMaxNumberInstallments());
        loanTypeDB.setMinInstallmentValue(type.getMinInstallmentValue());
        loanTypeDB.setInterest(type.getInterest());
        loanTypeRepository.save(loanTypeDB);
        return type;
    }

    @Override
    public LoanType getType(String loanTypeName) {
        LoanType loanType = loanTypeRepository.findByLoanTypeName(loanTypeName).getLoanType();
        return loanType;
    }

    @Override
    public LoanType deleteType(String loanTypeName) {
        LoanTypeDB loanTypeDB = loanTypeRepository.findByLoanTypeName(loanTypeName);
        loanTypeRepository.delete(loanTypeDB);
        return loanTypeDB.getLoanType();
    }

    @Override
    public long createLoan(RequestLoan loan) throws Exception {
        LoanDB loanDB = new LoanDB();
        loanDB.setUser(userRepository.findByUserName(loan.getUserName()));
        loanDB.setLoanType(loanTypeRepository.findByLoanTypeName(loan.getLoanType()));
        loanDB.setInterest(loanTypeRepository.findByLoanTypeName(loan.getLoanType()).getInterest());
        loanDB.setTotal(loan.getTotal());
        loanDB.setBalance(loan.getAdvance());
        return loanRepository.save(loanDB).getId();
    }

    @Override
    public Loan updateLoan(RequestLoan requestLoan, long loanId) throws Exception {
        LoanDB loanDB = loanRepository.findById(loanId);
        loanDB.setBalance(loanDB.getBalance() + requestLoan.getAdvance());
        if (requestLoan.getTotal() > 0)
            loanDB.setTotal(requestLoan.getTotal());
        return loanRepository.save(loanDB).getLoan();
    }
}
