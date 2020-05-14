package com.colaborativesaving.demo.services.members;

import com.colaborativesaving.demo.models.entities.FundMember;
import com.colaborativesaving.demo.models.fundmember.ResponseMember;
import com.colaborativesaving.demo.models.fundmember.ResponseMembers;

public interface MembersService {
    public ResponseMembers getMembers();
    public ResponseMember GetMember(String user);
    public ResponseMember CreateMember(FundMember fundMember);
    public ResponseMember DeleteMember(String user);
}
