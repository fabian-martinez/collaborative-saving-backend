package com.colaborativesaving.demo.shares.controllers;

import com.colaborativesaving.demo.shares.controllers.contracts.*;
import org.springframework.http.ResponseEntity;

public interface UserShareController {
    public ResponseEntity<ResponseUserStock> purchaseStock(RequestStock requestStock) throws Exception;
    public ResponseEntity<ResponseUserStock> retireStock(RequestStock requestRetireStock);
    public ResponseEntity<ResponseUserStock> getStockForUser(String userName, String shareName) throws Exception;
    public ResponseEntity<ResponseUserStocks> getAllStocksForUser(String userName);
    public ResponseEntity<ResponseStocks> getAllStocks();
}
