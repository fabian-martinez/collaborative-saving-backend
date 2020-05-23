package com.colaborativesaving.demo.shares.controllers.contracts;

public class RequestShare {
    private String name;
    private double contribution;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }
}
