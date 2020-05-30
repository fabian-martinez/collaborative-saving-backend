package com.colaborativesaving.demo.loans.repository;

import com.colaborativesaving.demo.loans.model.Loan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface LoanRepository extends CrudRepository<Loan, String> {
    Loan findById(UUID loanId);
    List<Loan> findByUserId(long userId);
}
