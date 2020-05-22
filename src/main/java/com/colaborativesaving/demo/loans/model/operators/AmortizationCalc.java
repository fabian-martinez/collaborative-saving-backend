package com.colaborativesaving.demo.loans.model.operators;

import com.colaborativesaving.demo.loans.model.Installment;

import java.util.ArrayList;
import java.util.List;

public class AmortizationCalc {


    public List<Installment> Amortize(
            double totalLoan, float interest, double installmentValue, short installmentsNumber){

        List<Installment> installments = new ArrayList<Installment>();
        double iniInstalment = totalLoan - (installmentsNumber*installmentValue);
        double balance = totalLoan - iniInstalment;
        double interestValue = Math.round(totalLoan*interest);
        double total = balance + interestValue;
        installments.add(new Installment(
                balance,iniInstalment,interestValue,total, (short) 1));

        for (short i = 1; i <= installmentsNumber; i++){
            interestValue = Math.round(balance*interest);
            balance = balance - installmentValue;
            total = balance + interestValue;
            installments.add(new Installment(balance,installmentValue,interestValue,total,(short)(i+1)));
        }

        return installments;
    }



}
