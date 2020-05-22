package com.colaborativesaving.demo.loans.model.operators;

import com.colaborativesaving.demo.loans.model.Installment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AmortizationCalcTest {

    @Autowired
    AmortizationCalc amortizationCalc;

    @Test
    void amortize() {
        List<Installment> amort = new ArrayList<Installment>();
        amortizationCalc = new AmortizationCalc();
        amort = amortizationCalc.Amortize(10000000, (float)(1.5/100.0),450000,(short) 20);
        System.out.println(amort.toString());
    }
}