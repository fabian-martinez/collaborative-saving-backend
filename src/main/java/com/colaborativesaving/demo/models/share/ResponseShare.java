package com.colaborativesaving.demo.models.share;

import com.colaborativesaving.demo.models.entities.Share;

public class ResponseShare {

    private Share share;

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    public ResponseShare(Share share) {
        this.share = share;
    }
}
