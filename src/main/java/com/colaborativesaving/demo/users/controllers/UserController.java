package com.colaborativesaving.demo.users.controllers;

import com.colaborativesaving.demo.users.controllers.contracts.RequestUser;
import com.colaborativesaving.demo.users.controllers.contracts.ResponseUser;
import com.colaborativesaving.demo.users.controllers.contracts.ResponseUsers;
import org.springframework.http.ResponseEntity;

public interface UserController {
    public ResponseEntity<ResponseUsers> retriveMembers();
    public ResponseEntity<ResponseUser> retriveMember(String user) throws Exception;
    public ResponseEntity<ResponseUser> postMember(RequestUser requestMember);
    public ResponseEntity<ResponseUser> deleteMember(String user) throws Exception;
}
