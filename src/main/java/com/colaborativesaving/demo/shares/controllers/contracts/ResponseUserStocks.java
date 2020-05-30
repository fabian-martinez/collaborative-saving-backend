package com.colaborativesaving.demo.shares.controllers.contracts;

import com.colaborativesaving.demo.shares.model.UserStock;
import com.colaborativesaving.demo.shares.model.UserStockMapper;

import java.util.List;

public class ResponseUserStocks {

    private List<UserStockMapper> userStocks;


    public ResponseUserStocks(List<UserStockMapper> allStocksForUser) {
        this.userStocks = allStocksForUser;
    }

    public List<UserStockMapper> getUserStocks() {
        return userStocks;
    }

    public void setUserStocks(List<UserStockMapper> userStocks) {
        this.userStocks = userStocks;
    }
}
