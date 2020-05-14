package com.colaborativesaving.demo.controllers;

import com.colaborativesaving.demo.models.share.RequestShare;
import com.colaborativesaving.demo.models.share.ResponseShare;
import com.colaborativesaving.demo.models.share.ResponseShares;
import com.colaborativesaving.demo.services.shares.SharesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shares")
public class sharesController {
    
    @Autowired
    private SharesService sharesService;

    @GetMapping("")
    public ResponseEntity<ResponseShares> retriveShares(){
        return new ResponseEntity<ResponseShares>(sharesService.GetShares(), HttpStatus.OK);
    }

    @GetMapping("/{share}")
    public ResponseEntity<ResponseShare> retriveShare(@PathVariable(value = "member") String user){
        return new ResponseEntity<ResponseShare>(sharesService.GetShare(user), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseShare> postShare(@RequestBody RequestShare requestShare){
        return new ResponseEntity<ResponseShare>(sharesService.CreateShare(requestShare.getShare()), HttpStatus.OK);
    }

    @DeleteMapping("{share}")
    public ResponseEntity<ResponseShare> deleteShare(@PathVariable(value = "member") String user){
        return new ResponseEntity<ResponseShare>(sharesService.DeleteShare(user), HttpStatus.OK);
    }

}
