package com.colaborativesaving.demo.users.services;

import com.colaborativesaving.demo.users.model.User;
import com.colaborativesaving.demo.users.controllers.contracts.ResponseUser;
import com.colaborativesaving.demo.users.controllers.contracts.ResponseUsers;

import java.util.List;

public interface UsersService {
    public List<User> getUsers();
    public User getUser(String user) throws Exception;
    public User createUser(User user);
    public User deleteUser(String user) throws Exception;
}
