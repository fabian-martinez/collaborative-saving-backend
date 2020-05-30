package com.colaborativesaving.demo.loans.repository;

import com.colaborativesaving.demo.loans.model.LoanType;
import org.springframework.data.repository.CrudRepository;

public interface LoanTypeRepository extends CrudRepository<LoanType, Integer> {
    LoanType findByLoanTypeName(String loanTypeName);
}
