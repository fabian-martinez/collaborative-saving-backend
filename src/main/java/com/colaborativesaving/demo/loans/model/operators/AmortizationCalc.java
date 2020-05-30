package com.colaborativesaving.demo.loans.model.operators;

import com.colaborativesaving.demo.loans.model.Installment;
import com.colaborativesaving.demo.loans.model.Loan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmortizationCalc {

    private static final double NORMILIZER = 10000;


    public void Amortize(Loan loan, double installmentValue, int installmentsNumber){
        double iniInstallment = loan.getTotal() - (installmentValue * installmentsNumber);
        installmentsNumber = installmentsNumber + 1;
        loan.setPayment(iniInstallment);
        loan.setInstallmentValue(installmentValue);
        loan.setTotalInstallments(installmentsNumber);
        loan.setPendingInstallments(installmentsNumber);
    }

    public void Amortize(Loan loan, int installmentsNumber){
        double totalLoan = loan.getTotal();
        double installmentValue = Math.round((totalLoan/installmentsNumber)/NORMILIZER)*NORMILIZER;
        installmentsNumber = (int) Math.ceil(totalLoan/installmentValue);
        double iniInstallment = totalLoan - installmentValue*(installmentsNumber-1);
        loan.setPayment(iniInstallment);
        loan.setInstallmentValue(installmentValue);
        loan.setTotalInstallments(installmentsNumber);
        loan.setPendingInstallments(installmentsNumber);
    }

    public void Amortize(Loan loan, double installmentValue){
        double totalLoan = loan.getTotal();
        int installmentsNumber = (int) Math.ceil(totalLoan/installmentValue);
        double iniInstallment = totalLoan - installmentValue*(installmentsNumber-1);
        loan.setPayment(iniInstallment);
        loan.setInstallmentValue(installmentValue);
        loan.setTotalInstallments(installmentsNumber);
        loan.setPendingInstallments(installmentsNumber);
    }

    public List<Installment> getAmortization(Loan loan){
        List<Installment> installments = new ArrayList<Installment>();
        installments.add(getIniInstallment(loan));
        double balace = loan.getTotal() - loan.getPayment();
        for (int i = 1 ; i < loan.getTotalInstallments(); i++){
            double interest = balace*(loan.getInterest()/100);
            double total = interest + loan.getInstallmentValue();
            balace = balace - loan.getInstallmentValue();
            installments.add(new Installment(loan, balace,loan.getInstallmentValue(),interest,total,i+1));
        }
        return installments;
    }

    private Installment getIniInstallment(Loan loan){
        double interest = loan.getInterest()/100.0;
        double balace = loan.getTotal() - loan.getPayment();
        double interestValue = Math.round(loan.getTotal()*interest);
        double total = loan.getInstallmentValue()+interestValue;

        return new Installment(loan,balace,loan.getPayment(),interestValue,total,1);
    }

}
