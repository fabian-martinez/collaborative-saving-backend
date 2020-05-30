package com.colaborativesaving.demo.shares.repository;


import com.colaborativesaving.demo.shares.model.ShareType;
import org.springframework.data.repository.CrudRepository;

public interface ShareTypeRepository extends CrudRepository<ShareType, Long> {
    ShareType findByName(String shareName);
}
