package com.colaborativesaving.demo.shares.controllers.contracts;

import com.colaborativesaving.demo.shares.model.UserStock;

import java.util.List;

public class ResponseShareStocks {

    private List<UserStock> userStocks;

    public ResponseShareStocks(List<UserStock> allStocksForShareType) {
        this.userStocks = allStocksForShareType;
    }

    public List<UserStock> getUserStocks() {
        return userStocks;
    }

    public void setUserStocks(List<UserStock> userStocks) {
        this.userStocks = userStocks;
    }
}
