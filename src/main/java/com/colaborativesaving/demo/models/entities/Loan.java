package com.colaborativesaving.demo.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "type", unique = true)
    private String type;

    @Column(name = "pct")
    private double pct;

    @Column(name = "min_fee_value")
    private long minPayment;

    @Column(name = "max_fees_number")
    private int maxFeesNumber;

    @Column(name = "balance")
    private double balance;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPct() { return pct; }

    public void setPct(double pct) {
        this.pct = pct;
    }

    public long getMinPayment() {
        return minPayment;
    }

    public void setMinPayment(long minPayment) {
        this.minPayment = minPayment;
    }

    public int getMaxFeesNumber() {
        return maxFeesNumber;
    }

    public void setMaxFeesNumber(int maxFeesNumber) {
        this.maxFeesNumber = maxFeesNumber;
    }

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }
}
