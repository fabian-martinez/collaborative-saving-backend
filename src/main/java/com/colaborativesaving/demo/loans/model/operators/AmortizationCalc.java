package com.colaborativesaving.demo.loans.model.operators;

import com.colaborativesaving.demo.loans.model.Installment;

import java.util.ArrayList;
import java.util.List;

public class AmortizationCalc {

    public List<Installment> Amortize(
            long totalLoan, float interest, int installmentsNumber){

        long installmentValue = (totalLoan * (interest / (1 - Math.pow(1 + interest, -1 * installmentsNumber))));
        installmentValue = Math.round(installmentValue*100.0)/100.0;

        for (int i = 0 ; i < plazo ; i++){
            double interes = Math.round(saldo*tasaInteresMes*100.0)/100.0;
            double abono = cuota - interes;
            responseCredito.AddCuota(Math.round(saldo - abono),Math.round(abono),interes,cuota,i+1);
            saldo = saldo - abono;
            saldo = Math.round(saldo);
        }
    }

    }

    public List<Installment> Amortize(
            long totalLoan, double interest, long installmentValue){
        while (saldo > 0){
            double interes = Math.round(saldo*tasaInteresMes*100.0)/100.0;
            double abono = (saldo > cuota)?cuota - interes:saldo;
            abono = Math.round(abono*100.0)/100.0;
            responseCredito.AddCuota(Math.round(saldo - abono),abono,interes,abono + interes,numCuota);
            numCuota++;
            saldo = saldo - abono;

    }

    public List<Installment> Amortize(
            long totalLoan, double interest, long installmentValue, int installmentsNumber){

    }



}
