package com.colaborativesaving.demo.shares.controllers.contracts;

import com.colaborativesaving.demo.shares.model.ShareType;

public class RequestShareType {
    private String name;
    private double contribution;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }

    public ShareType getShareType() {
        ShareType shareType = new ShareType();
        shareType.setName(this.name);
        shareType.setContribution(this.contribution);
        return shareType;
    }
}
