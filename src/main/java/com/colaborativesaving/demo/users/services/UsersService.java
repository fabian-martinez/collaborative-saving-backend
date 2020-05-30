package com.colaborativesaving.demo.users.services;

import com.colaborativesaving.demo.users.controllers.contracts.ResponseUser;
import com.colaborativesaving.demo.users.model.User;
import com.colaborativesaving.demo.users.model.UserMapper;
import com.colaborativesaving.demo.users.model.UserMapperWithGeneralInfo;
import com.colaborativesaving.demo.users.model.UsersMapper;

import java.util.List;

public interface UsersService {
    public UsersMapper getUsers();
    public UserMapperWithGeneralInfo getUser(String user) throws Exception;
    public UserMapperWithGeneralInfo createUser(User user) throws Exception;
    public UserMapperWithGeneralInfo deleteUser(String user) throws Exception;
}
