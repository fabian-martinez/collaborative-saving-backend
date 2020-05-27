package com.colaborativesaving.demo.shares.controllers.contracts;

import com.colaborativesaving.demo.shares.model.UserStock;

import java.util.List;

public class ResponseUserStocks {

    private List<UserStock> userStocks;


    public ResponseUserStocks(List<UserStock> allStocksForUser) {
        this.userStocks = allStocksForUser;
    }

    public List<UserStock> getUserStocks() {
        return userStocks;
    }

    public void setUserStocks(List<UserStock> userStocks) {
        this.userStocks = userStocks;
    }
}
