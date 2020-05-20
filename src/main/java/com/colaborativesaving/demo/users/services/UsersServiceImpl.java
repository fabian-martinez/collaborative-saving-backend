package com.colaborativesaving.demo.users.services;

import com.colaborativesaving.demo.users.controllers.contracts.ResponseUser;
import com.colaborativesaving.demo.users.controllers.contracts.ResponseUsers;
import com.colaborativesaving.demo.users.model.User;
import com.colaborativesaving.demo.users.model.UserStatusEnum;
import com.colaborativesaving.demo.users.repository.UserDB;
import com.colaborativesaving.demo.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {

        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(userDB -> {
            try {
                users.add(userDB.getUser());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return users;
    }

    @Override
    public User getUser(String userName) throws Exception {
        User user = userRepository.findByUserName(userName).getUser();
        return user;
    }

    @Override
    public User createUser(User user) {
        UserDB userDB = new UserDB();
        user.setStatus(UserStatusEnum.FREE);
        user.setUpdate(new Date());
        userDB.setUser(user);
        userRepository.save(userDB);
        return user;
    }

    @Override
    public User deleteUser(String userName) throws Exception {
        UserDB deletedUser = userRepository.findByUserName(userName);
        userRepository.delete(deletedUser);
        return deletedUser.getUser();
    }
}
