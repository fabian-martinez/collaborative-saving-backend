package com.colaborativesaving.demo.loans.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LoanRepository extends CrudRepository<LoanDB, UUID> {
    LoanDB findById(String loanId);
}
