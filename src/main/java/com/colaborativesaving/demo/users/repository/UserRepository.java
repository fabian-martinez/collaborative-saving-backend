package com.colaborativesaving.demo.users.repository;

import com.colaborativesaving.demo.users.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {
    User findByUserName(String userName);

}
