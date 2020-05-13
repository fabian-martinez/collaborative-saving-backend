package com.colaborativesaving.demo.models.fundmember;

import com.colaborativesaving.demo.models.entities.FundMember;

public class ResponseMember {

    private FundMember fundMember;

    public FundMember getFundMember() {
        return fundMember;
    }

    public void setFundMember(FundMember fundMember) {
        this.fundMember = fundMember;
    }

    public ResponseMember(FundMember fundMember) {
        this.fundMember = fundMember;
    }
}
