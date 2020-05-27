package com.colaborativesaving.demo.shares.controllers.contracts;

import com.colaborativesaving.demo.shares.model.UserStock;

import java.util.List;

public class ResponseUserStock {

    private UserStock userStock;

    public ResponseUserStock(UserStock purchaseStock) {
        this.userStock = purchaseStock;
    }


    public UserStock getUserStock() {
        return userStock;
    }

    public void setUserStock(UserStock userStock) {
        this.userStock = userStock;
    }
}
