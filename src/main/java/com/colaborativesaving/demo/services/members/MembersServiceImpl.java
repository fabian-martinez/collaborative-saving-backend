package com.colaborativesaving.demo.services.members;

import com.colaborativesaving.demo.models.MemberStatusEnum;
import com.colaborativesaving.demo.models.entities.FundMember;
import com.colaborativesaving.demo.models.fundmember.ResponseMember;
import com.colaborativesaving.demo.models.fundmember.ResponseMembers;
import com.colaborativesaving.demo.repositories.FundMemberRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MembersServiceImpl implements MembersService {

    @Autowired
    private FundMemberRepostory fundMemberRepostory;

    @Override
    public ResponseMembers getMembers() {

        List<FundMember> fundMembers = new ArrayList<FundMember>();
        fundMemberRepostory.findAll().forEach(fundMembers::add);

        return new ResponseMembers(fundMembers);
    }

    @Override
    public ResponseMember GetMember(String name) {
        return new ResponseMember(fundMemberRepostory.findByName(name).get(0));
    }

    @Override
    public ResponseMember CreateMember(FundMember fundMember) {
        fundMember.setStatus(MemberStatusEnum.FREE.getCode());
        fundMember.setUpdte(new Date().getTime());
        return new ResponseMember(fundMemberRepostory.save(fundMember));
    }

    @Override
    public ResponseMember DeleteMember(String name) {
        FundMember deletedMember = fundMemberRepostory.findByName(name).get(0);
        fundMemberRepostory.delete(deletedMember);
        return new ResponseMember(deletedMember);
    }
}
