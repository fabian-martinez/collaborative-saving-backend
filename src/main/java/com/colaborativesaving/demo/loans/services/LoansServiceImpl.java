package com.colaborativesaving.demo.loans.services;

import com.colaborativesaving.demo.loans.controllers.contracts.RequestAmortization;
import com.colaborativesaving.demo.loans.controllers.contracts.RequestLoan;
import com.colaborativesaving.demo.loans.model.*;
import com.colaborativesaving.demo.loans.model.operators.AmortizationCalc;
import com.colaborativesaving.demo.loans.repository.*;
import com.colaborativesaving.demo.users.repository.UserRepository;
import com.colaborativesaving.demo.users.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
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
    private UserRepository userRepository;

    @Autowired
    private AmortizationCalc amortizationCalc;


    @Override
    public List<LoanType> getTypes() {
        List<LoanType> loanTypeList = new ArrayList<LoanType>();
        loanTypeRepository.findAll().forEach(loanType -> {
            try {
                loanTypeList.add(loanType);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return loanTypeList;
    }

    @Override
    public LoanType createType(LoanType type) {
        LoanType loanType = new LoanType();
        loanType.setLoanTypeName(type.getLoanTypeName());
        loanType.setMaxNumberInstallments(type.getMaxNumberInstallments());
        loanType.setMinInstallmentValue(type.getMinInstallmentValue());
        loanType.setInterest(type.getInterest());
        loanTypeRepository.save(loanType);
        return type;
    }

    @Override
    public LoanType getType(String loanTypeName) {
        LoanType loanType = loanTypeRepository.findByLoanTypeName(loanTypeName);
        return loanType;
    }

    @Override
    public List<LoanMapper> getLoansForUser(String username) {
        List<LoanMapper> loanMappers = new ArrayList<>();
        loanRepository.findByUserId(
                userRepository.findByUserName(username).getId()
        ).forEach(loan -> {
            try {
                loanMappers.add(new LoanMapper(loan));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return loanMappers;
    }

    @Override
    public LoanType deleteType(String loanTypeName) {
        LoanType loanType = loanTypeRepository.findByLoanTypeName(loanTypeName);
        loanTypeRepository.delete(loanType);
        return loanType;
    }

    @Override
    public UUID createLoan(RequestLoan requestLoan) throws Exception {
        Loan loan = new Loan();
        loan.setUser(userRepository.findByUserName(requestLoan.getUserName()));
        loan.setLoanType(loanTypeRepository.findByLoanTypeName(requestLoan.getLoanType()));
        loan.setInterest(loanTypeRepository.findByLoanTypeName(requestLoan.getLoanType()).getInterest());
        loan.setTotal(requestLoan.getTotal());
        loan.setBalance(requestLoan.getAdvance());
        loan.setState(LoanStateEnum.PAYING_OUT.getCode());
        return loanRepository.save(loan).getId();
    }

    @Override
    public Loan updateLoan(RequestLoan requestLoan, UUID loanId) throws Exception {
        Loan loan = loanRepository.findById(loanId);
        double balance = loan.getBalance() + requestLoan.getAdvance();
        loan.setBalance(balance);
        if (requestLoan.getTotal() >= balance)
            loan.setTotal(requestLoan.getTotal());
        return loanRepository.save(loan);
    }

    @Override
    public Amortization amortizeLoan(RequestAmortization requestAmortization, UUID loanId) throws Exception {
        Loan loan = loanRepository.findById(loanId);
        loan.setTotal(loan.getBalance());
        if (requestAmortization.getNumberInstallments() > 0 && requestAmortization.getInstallmentValue() > 0) {
            amortizationCalc.Amortize(loan,requestAmortization.getInstallmentValue(),requestAmortization.getNumberInstallments());
        } else if (requestAmortization.getNumberInstallments() > 0){
            amortizationCalc.Amortize(loan,requestAmortization.getNumberInstallments());
        } else if (requestAmortization.getInstallmentValue() > 0){
            amortizationCalc.Amortize(loan,requestAmortization.getInstallmentValue());
        } else {
          throw new InvalidParameterException();
        }

        //Elimina amortizaciones anteriores
        installmentRepository.deleteByLoanId(loan.getId());
        //
        loan.setState(LoanStateEnum.PAYING.getCode());
        Amortization amortization = new Amortization(loanRepository.save(loan),amortizationCalc.getAmortization(loan));
        for (Installment installment : amortization.getInstallments()){
            installmentRepository.save(installment);
        }
        return amortization;
    }
}
