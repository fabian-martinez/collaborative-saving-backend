package com.colaborativesaving.demo.controllers;

import com.colaborativesaving.demo.models.fundmember.RequestMember;
import com.colaborativesaving.demo.models.fundmember.ResponseMember;
import com.colaborativesaving.demo.models.fundmember.ResponseMembers;
import com.colaborativesaving.demo.services.members.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class membersController {

    @Autowired
    private MembersService membersService;

    @GetMapping("/members")
    public ResponseEntity<ResponseMembers> retriveMembers(){
        return new ResponseEntity<ResponseMembers>(membersService.getMembers(), HttpStatus.OK);
    }

    @GetMapping("/members/{member}")
    public ResponseEntity<ResponseMember> retriveMember(@PathVariable(value = "member") String name){
        return new ResponseEntity<ResponseMember>(membersService.GetMember(name), HttpStatus.OK);
    }

    @PostMapping("/members")
    public ResponseEntity<ResponseMember> postMember(@RequestBody RequestMember requestMember){
        return new ResponseEntity<ResponseMember>(membersService.CreateMember(requestMember.getMember()), HttpStatus.OK);
    }

    @DeleteMapping("/members/{member}")
    public ResponseEntity<ResponseMember> deleteMember(@PathVariable(value = "member") String name){
        return new ResponseEntity<ResponseMember>(membersService.DeleteMember(name), HttpStatus.OK);
    }
}
