package com.colaborativesaving.demo.users.repository;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserDB,Long> {
    UserDB findByUserName(String userName);

}
