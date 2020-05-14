package com.colaborativesaving.demo.models.share;

import com.colaborativesaving.demo.models.entities.Share;

public class RequestShare {
    public Share share;

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    public RequestShare(Share share) {
        this.share = share;
    }
}
