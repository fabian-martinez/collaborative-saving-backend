package com.colaborativesaving.demo.loans.repository;

import org.springframework.data.repository.CrudRepository;

public interface LoanTypeRepository extends CrudRepository<LoanTypeDB, Integer> {
    LoanTypeDB findByLoanTypeName(String loanTypeName);
}
