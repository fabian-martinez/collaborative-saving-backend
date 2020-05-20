package com.colaborativesaving.demo.loans.repository;

import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<LoanDB,Long> {
    LoanDB findById(long loanId);
}
