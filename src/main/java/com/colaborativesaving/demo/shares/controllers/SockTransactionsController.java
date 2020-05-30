package com.colaborativesaving.demo.shares.controllers;

import com.colaborativesaving.demo.shares.controllers.contracts.*;
import org.springframework.http.ResponseEntity;

public interface SockTransactionsController {
    public ResponseEntity<ResponseUserStock> purchaseStock(RequestStock requestStock) throws Exception;
    public ResponseEntity<ResponseUserStock> retireStock(RequestStock requestRetireStock);
    public ResponseEntity<ResponseUserStock> getStocksForShareAndUser(String userName, String shareName) throws Exception;
    public ResponseEntity<ResponseUserStock> getStocksForUserAndShare(String userName, String shareName) throws Exception;
    public ResponseEntity<ResponseUserStocks> getAllStocksForShare(String shareName);
    public ResponseEntity<ResponseUserStocks> getAllStocksForUser(String userName);
    public ResponseEntity<ResponseStocks> getAllStocks();
}
