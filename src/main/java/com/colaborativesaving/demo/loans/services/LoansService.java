package com.colaborativesaving.demo.loans.services;

import com.colaborativesaving.demo.loans.controllers.contracts.RequestLoan;
import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.loans.model.LoanType;

import java.util.List;

public interface LoansService {
    public List<LoanType> getTypes();
    public LoanType createType(LoanType type);
    public LoanType getType(String loanTypeName);
    public LoanType deleteType(String loanTypeName);
    public long createLoan(RequestLoan loan) throws Exception;
    public Loan updateLoan(RequestLoan loan, long loanId) throws Exception;

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
