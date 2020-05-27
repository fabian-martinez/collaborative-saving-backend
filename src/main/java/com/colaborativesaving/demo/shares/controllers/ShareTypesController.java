package com.colaborativesaving.demo.shares.controllers;

import com.colaborativesaving.demo.shares.controllers.contracts.RequestShareType;
import com.colaborativesaving.demo.shares.controllers.contracts.ResponseShareType;
import com.colaborativesaving.demo.shares.controllers.contracts.ResponseShareTypes;
import com.colaborativesaving.demo.shares.model.ShareType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShareTypesController {
    public ResponseEntity<ResponseShareType> createShareType(RequestShareType requestShareType);
    public ResponseEntity<ResponseShareType> getShareType(String shareName);
    public ResponseEntity<ResponseShareTypes> getSharesType();
    public ResponseEntity<ResponseShareType> updateShareType(String shareName, RequestShareType requestShareType);
}
