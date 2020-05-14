package com.colaborativesaving.demo.models.share;

import com.colaborativesaving.demo.models.entities.Share;

import java.util.List;

public class ResponseShares {

    private List<Share> shares;

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public ResponseShares(List<Share> shares) {
        this.shares = shares;
    }
}
