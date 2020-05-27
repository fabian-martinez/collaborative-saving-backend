package com.colaborativesaving.demo.shares.controllers;

import com.colaborativesaving.demo.shares.controllers.contracts.RequestShareType;
import com.colaborativesaving.demo.shares.controllers.contracts.ResponseShareType;
import com.colaborativesaving.demo.shares.controllers.contracts.ResponseShareTypes;
import com.colaborativesaving.demo.shares.services.SharesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shares/type")
public class ShareTypesControllerImpl implements ShareTypesController {

    @Autowired
    private SharesService sharesService;

    @PostMapping("")
    public ResponseEntity<ResponseShareType> createShareType(@RequestBody RequestShareType requestShareType) {
        return new ResponseEntity<ResponseShareType>(
                new ResponseShareType(sharesService.createShareType(
                        requestShareType.getShareType())), HttpStatus.OK) ;
    }

    @GetMapping("{shareName}")
    public ResponseEntity<ResponseShareType> getShareType(@PathVariable(name = "shareName") String shareName) {
        return new ResponseEntity<ResponseShareType>(
                new ResponseShareType(sharesService.getShareType(shareName)), HttpStatus.OK) ;
    }

    @GetMapping("")
    public ResponseEntity<ResponseShareTypes> getSharesType() {
        return new ResponseEntity<ResponseShareTypes>(
                new ResponseShareTypes(sharesService.getShareTypes()), HttpStatus.OK) ;
    }

    @PutMapping("{shareName}")
    public ResponseEntity<ResponseShareType> updateShareType(
            @PathVariable( name = "shareName" ) String shareName, @RequestBody RequestShareType requestShareType) {
        return new ResponseEntity<ResponseShareType>(
                new ResponseShareType(sharesService.setShareType(shareName,requestShareType.getShareType())), HttpStatus.OK);
    }

}
