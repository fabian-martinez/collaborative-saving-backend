package com.colaborativesaving.demo.shares.controllers;

import com.colaborativesaving.demo.shares.controllers.contracts.*;
import com.colaborativesaving.demo.shares.services.SharesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shares")
public class SockTransactionsControllerImpl implements SockTransactionsController {

    @Autowired
    SharesService sharesService;

    @PostMapping("purchase")
    public ResponseEntity<ResponseUserStock> purchaseStock(@RequestBody RequestStock requestStock) throws Exception {
        return new ResponseEntity<ResponseUserStock>(
                new ResponseUserStock(sharesService.purchaseStock(requestStock)), HttpStatus.OK);
    }

    @PostMapping("retire")
    public ResponseEntity<ResponseUserStock> retireStock(@RequestBody RequestStock requestRetireStock) {
        return new ResponseEntity<ResponseUserStock>(
                new ResponseUserStock(sharesService.retireStock(requestRetireStock)),HttpStatus.OK);
    }

    @GetMapping(value = {"user/{userName}/{shareName}"})
    public ResponseEntity<ResponseUserStock> getStocksForUserAndShare(
            @PathVariable(name = "userName") String userName,@PathVariable(name = "shareName") String shareName) throws Exception {
        return new ResponseEntity<ResponseUserStock>(
                new ResponseUserStock(sharesService.getStockForUserAndShare(userName, shareName)),HttpStatus.OK);
    }

    @GetMapping(value = {"share/{shareName}/{shareName}"})
    public ResponseEntity<ResponseUserStock> getStocksForShareAndUser(
            @PathVariable(name = "userName") String userName,@PathVariable(name = "shareName") String shareName) throws Exception {
        return new ResponseEntity<ResponseUserStock>(
                new ResponseUserStock(sharesService.getStockForUserAndShare(userName, shareName)),HttpStatus.OK);
    }

    @GetMapping("user/{userName}")
    public ResponseEntity<ResponseUserStocks> getAllStocksForUser(@PathVariable(name = "userName") String userName) {
        return new ResponseEntity<ResponseUserStocks>(
                new ResponseUserStocks(sharesService.getAllStocksForUser(userName)),HttpStatus.OK);
    }

    @GetMapping("share/{shareName}")
    public ResponseEntity<ResponseUserStocks> getAllStocksForShare(@PathVariable(name = "userShare") String userName) {
        return new ResponseEntity<ResponseUserStocks>(
                new ResponseUserStocks(sharesService.getAllStocksForShare(userName)),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ResponseStocks> getAllStocks() {
        return new ResponseEntity<ResponseStocks>(new ResponseStocks(sharesService.getAllStocks()),HttpStatus.OK);
    }
}
