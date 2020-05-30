package com.colaborativesaving.demo.shares.controllers.contracts;

import com.colaborativesaving.demo.shares.model.UserStock;
import com.colaborativesaving.demo.shares.model.UserStockMapper;

public class ResponseUserStock {

    private String user;
    private String share;
    private double contribution;
    private int cnt;
    private double value;

    public ResponseUserStock(UserStockMapper userStock) {
       this.user = userStock.getUser();
       this.share = userStock.getShare();
       this.contribution = userStock.getContribution();
       this.cnt = userStock.getCnt();
       this.value = userStock.getValue();
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

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }
}
