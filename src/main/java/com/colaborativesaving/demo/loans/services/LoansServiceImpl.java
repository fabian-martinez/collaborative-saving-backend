package com.colaborativesaving.demo.loans.services;

import com.colaborativesaving.demo.loans.controllers.contracts.RequestAmortization;
import com.colaborativesaving.demo.loans.controllers.contracts.RequestLoan;
import com.colaborativesaving.demo.loans.controllers.contracts.ResponseAmortization;
import com.colaborativesaving.demo.loans.model.Amortization;
import com.colaborativesaving.demo.loans.model.Installment;
import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.loans.model.LoanType;
import com.colaborativesaving.demo.loans.model.operators.AmortizationCalc;
import com.colaborativesaving.demo.loans.repository.*;
import com.colaborativesaving.demo.users.repository.UserRepository;
import com.colaborativesaving.demo.users.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LoansServiceImpl implements LoansService {

    @Autowired
    private LoanTypeRepository loanTypeRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private InstallmentRepository installmentRepository;

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AmortizationCalc amortizationCalc;


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
    public UUID createLoan(RequestLoan loan) throws Exception {
        LoanDB loanDB = new LoanDB();
        loanDB.setUser(userRepository.findByUserName(loan.getUserName()));
        loanDB.setLoanType(loanTypeRepository.findByLoanTypeName(loan.getLoanType()));
        loanDB.setInterest(loanTypeRepository.findByLoanTypeName(loan.getLoanType()).getInterest());
        loanDB.setTotal(loan.getTotal());
        loanDB.setBalance(loan.getAdvance());
        return loanRepository.save(loanDB).getId();
    }

    @Override
    public Loan updateLoan(RequestLoan requestLoan, UUID loanId) throws Exception {
        LoanDB loanDB = loanRepository.findById(loanId);
        double balance = loanDB.getBalance() + requestLoan.getAdvance();
        loanDB.setBalance(balance);
        if (requestLoan.getTotal() >= balance)
            loanDB.setTotal(requestLoan.getTotal());
        return loanRepository.save(loanDB).getLoan();
    }

    @Override
    public Amortization amortizeLoan(RequestAmortization amortization, UUID loanId) throws Exception {
        Loan loan = loanRepository.findById(loanId).getLoan();
        loan.setTotal(loan.getBalance());
        if (amortization.getNumberInstallments() > 0 && amortization.getInstallmentValue() > 0) {
            amortizationCalc.Amortize(loan,amortization.getInstallmentValue(),amortization.getNumberInstallments());
        } else if (amortization.getNumberInstallments() > 0){
            amortizationCalc.Amortize(loan,amortization.getNumberInstallments());
        } else if (amortization.getInstallmentValue() > 0){
            amortizationCalc.Amortize(loan,amortization.getInstallmentValue());
        } else {
          //TODO: error
        }
        LoanDB loanDB = loanRepository.findById(loanId);
        Amortization amortization_ = new Amortization(loanRepository.save(loanDB).getLoan(),amortizationCalc.getAmortization(loan));
        installmentRepository.deleteByLoanDBId(loanDB.getId());
        for (Installment installment : amortization_.getInstallments()){
            InstallmentsDB installmentDB = new InstallmentsDB();
            installmentDB.setLoanDB(loanDB);
            installmentDB.setInstallment(installment);
            installmentRepository.save(installmentDB);
        }
        loanDB.setLoan(loan);
        return amortization_;
    }
}
