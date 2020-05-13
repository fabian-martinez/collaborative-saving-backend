package com.colaborativesaving.demo.repositories;

import com.colaborativesaving.demo.models.entities.FundMember;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FundMemberRepostory extends CrudRepository<FundMember,Long> {
    List<FundMember>findByName(String name);
}
