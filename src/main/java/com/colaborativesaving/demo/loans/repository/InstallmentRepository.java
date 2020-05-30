package com.colaborativesaving.demo.loans.repository;

import com.colaborativesaving.demo.loans.model.Installment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InstallmentRepository extends CrudRepository<Installment,String> {
    Installment findByLoanId(UUID loanId);
    void deleteByLoanId(UUID loanId);
}
