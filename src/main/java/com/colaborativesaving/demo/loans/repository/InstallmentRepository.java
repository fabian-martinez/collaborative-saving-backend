package com.colaborativesaving.demo.loans.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InstallmentRepository extends CrudRepository<InstallmentsDB,Long> {
    InstallmentsDB findByLoanDBId(UUID loanDBId);
    void deleteByLoanDBId(UUID loanDBId);
}
