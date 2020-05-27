package com.colaborativesaving.demo.shares.controllers.contracts;

import com.colaborativesaving.demo.shares.model.UserStock;

import java.util.List;

public class ResponseStocks {

    List<UserStock> userStocks;

    public ResponseStocks(List<UserStock> allStocks) {
        this.userStocks = allStocks;
    }

    public List<UserStock> getUserStocks() {
        return userStocks;
    }

    public void setUserStocks(List<UserStock> userStocks) {
        this.userStocks = userStocks;
    }
}
