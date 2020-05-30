package com.colaborativesaving.demo.shares.controllers.contracts;

import com.colaborativesaving.demo.shares.model.UserStock;
import com.colaborativesaving.demo.shares.model.UserStockMapper;

import java.util.List;

public class ResponseStocks {

    List<UserStockMapper> userStocks;

    public ResponseStocks(List<UserStockMapper> allStocks) {
        this.userStocks = allStocks;
    }

    public List<UserStockMapper> getUserStocks() {
        return userStocks;
    }

    public void setUserStocks(List<UserStockMapper> userStocks) {
        this.userStocks = userStocks;
    }
}
