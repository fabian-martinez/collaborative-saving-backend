package com.colaborativesaving.demo.shares.repository;


import org.springframework.data.repository.CrudRepository;

public interface ShareTypeRepository extends CrudRepository<ShareTypeDB, Long> {
    ShareTypeDB findByName(String shareName);
}
