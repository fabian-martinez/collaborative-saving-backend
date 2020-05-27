package com.colaborativesaving.demo.shares.controllers.contracts;

import com.colaborativesaving.demo.shares.model.ShareType;

import java.util.List;

public class ResponseShareTypes {

    private List<ShareType> shareTypes;

    public ResponseShareTypes(List<ShareType> shareTypes) {
        this.shareTypes = shareTypes;
    }

    public List<ShareType> getShareTypes() {
        return shareTypes;
    }

    public void setShareTypes(List<ShareType> shareTypes) {
        this.shareTypes = shareTypes;
    }
}
