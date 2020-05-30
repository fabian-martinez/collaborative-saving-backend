package com.colaborativesaving.demo.shares.model;

public class UserStockMapper {

    private String user;
    private String share;
    private double contribution;
    private int cnt;
    private double value;

    public UserStockMapper(UserStock userStock) {
        this.user = userStock.getUser().getUserName();
        this.share = userStock.getShare().getName();
        this.contribution = userStock.getCnt()* userStock.getShare().getContribution();
        this.cnt = userStock.getCnt();
        this.value = userStock.getCnt()* userStock.getShare().getValue();
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
