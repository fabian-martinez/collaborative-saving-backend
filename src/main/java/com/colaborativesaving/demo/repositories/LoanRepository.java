package com.colaborativesaving.demo.repositories;

import com.colaborativesaving.demo.models.entities.Loan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loan,Long> {
    List<Loan> findByType(String loanType);
}
