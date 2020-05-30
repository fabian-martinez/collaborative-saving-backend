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

    @GetMapping(value = {"{userName}/{shareName}"})
    public ResponseEntity<ResponseUserStock> getStockForUser(
            @PathVariable(name = "userName") String userName,@PathVariable(name = "shareName") String shareName) throws Exception {
        return new ResponseEntity<ResponseUserStock>(
                new ResponseUserStock(sharesService.getStockForUser(userName, shareName)),HttpStatus.OK);
    }

    @GetMapping("{userName}")
    public ResponseEntity<ResponseUserStocks> getAllStocksForUser(@PathVariable(name = "userName") String userName) {
        return new ResponseEntity<ResponseUserStocks>(
                new ResponseUserStocks(sharesService.getAllStocksForUser(userName)),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ResponseStocks> getAllStocks() {
        return new ResponseEntity<ResponseStocks>(new ResponseStocks(sharesService.getAllStocks()),HttpStatus.OK);
    }
}
