package com.colaborativesaving.demo.users.controllers;

import com.colaborativesaving.demo.users.services.UsersService;
import com.colaborativesaving.demo.users.controllers.contracts.RequestUser;
import com.colaborativesaving.demo.users.controllers.contracts.ResponseUser;
import com.colaborativesaving.demo.users.controllers.contracts.ResponseUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserControllerImpl implements UserController{

    @Autowired
    private UsersService usersService;

    @GetMapping("")
    public ResponseEntity<ResponseUsers> retriveMembers(){
        return new ResponseEntity<ResponseUsers>(
                new ResponseUsers(usersService.getUsers()), HttpStatus.OK);
    }

    @GetMapping("{user}")
    public ResponseEntity<ResponseUser> retriveMember(@PathVariable(value = "user") String user) throws Exception {
        return new ResponseEntity<ResponseUser>(
               new ResponseUser(usersService.getUser(user)) , HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseUser> postMember(@RequestBody RequestUser requestUser) throws Exception {
        return new ResponseEntity<ResponseUser>(
                new ResponseUser(usersService.createUser(requestUser.getUser())), HttpStatus.OK);
    }

    @DeleteMapping("{user}")
    public ResponseEntity<ResponseUser> deleteMember(@PathVariable(value = "user") String user) throws Exception {
        return new ResponseEntity<ResponseUser>(
                new ResponseUser(usersService.deleteUser(user)), HttpStatus.OK);
    }
}
