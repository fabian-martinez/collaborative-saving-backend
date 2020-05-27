package com.colaborativesaving.demo.shares.controllers.contracts;

import com.colaborativesaving.demo.shares.model.ShareType;

public class ResponseShareType {

    private ShareType shareType;

    public ResponseShareType(ShareType shareType) {
        this.shareType = shareType;
    }

    public ShareType getShareType() {
        return shareType;
    }

    public void setShareType(ShareType shareType) {
        this.shareType = shareType;
    }
}
