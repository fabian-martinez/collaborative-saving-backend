package com.colaborativesaving.demo.loans.services;

import com.colaborativesaving.demo.loans.controllers.contracts.RequestAmortization;
import com.colaborativesaving.demo.loans.controllers.contracts.RequestLoan;
import com.colaborativesaving.demo.loans.controllers.contracts.ResponseAmortization;
import com.colaborativesaving.demo.loans.model.Amortization;
import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.loans.model.LoanMapper;
import com.colaborativesaving.demo.loans.model.LoanType;

import java.util.List;
import java.util.UUID;

public interface LoansService {
    public List<LoanType> getTypes();
    public LoanType createType(LoanType type);
    public LoanType getType(String loanTypeName);
    public List<LoanMapper> getLoansForUser(String username);
    public LoanType deleteType(String loanTypeName);
    public UUID createLoan(RequestLoan loan) throws Exception;
    public Loan updateLoan(RequestLoan loan, UUID loanId) throws Exception;
    public Amortization amortizeLoan(RequestAmortization amortization, UUID loanID) throws Exception;

    //TODO: amortizeLoan(loanId, requestAmortization) -> retorna tabla amotizada deacuerdo a parametros y reglas
    //          RequesAmortization: numero de cuotas, valor cuotas
    //TODO: getAllLoans() -> Retorna los prestamos existentes con typo y usuario
    //TODO: getLoansByType() -> Retorna los prestamos que existen por tipo
    //TODO: payLoan(idPrestamo, "abono a capital", "intereses") ->
    //   Retorna  valor Cuota(si se pago todoa es 0), Valor, Saldo,
    //   numero de cuotas restantes si pago mas de una se reduce el numero que pago completo, total cuotas
    //TODO: getLoan(idPrestamo) -> Retorna valor Cuota, Valor, Saldo, numero de cuotas restantes, total cuotas
    //TODO: cancelLoan(id, reason) -> no retorna nada
}
