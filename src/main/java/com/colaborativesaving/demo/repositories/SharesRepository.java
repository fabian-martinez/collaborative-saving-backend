package com.colaborativesaving.demo.repositories;

import com.colaborativesaving.demo.models.entities.Share;
import org.springframework.data.repository.CrudRepository;

public interface SharesRepository extends CrudRepository<Share, Long> {
    Share findByType(String type);
}
