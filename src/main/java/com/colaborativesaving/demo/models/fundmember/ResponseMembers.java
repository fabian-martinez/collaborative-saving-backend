package com.colaborativesaving.demo.models.fundmember;


import com.colaborativesaving.demo.models.entities.FundMember;

import java.util.ArrayList;
import java.util.List;

public class ResponseMembers {

    public List<FundMember> getMembers() {
        return members;
    }

    public void setMembers(List<FundMember> members) {
        this.members = members;
    }

    public ResponseMembers(List<FundMember> members) {
        this.members = members;
    }

    private List<FundMember> members;
}
