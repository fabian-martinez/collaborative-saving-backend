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
@RequestMapping("/api/v1/members")
public class membersController {

    @Autowired
    private MembersService membersService;

    @GetMapping("")
    public ResponseEntity<ResponseMembers> retriveMembers(){
        return new ResponseEntity<ResponseMembers>(membersService.getMembers(), HttpStatus.OK);
    }

    @GetMapping("/{member}")
    public ResponseEntity<ResponseMember> retriveMember(@PathVariable(value = "member") String user){
        return new ResponseEntity<ResponseMember>(membersService.GetMember(user), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseMember> postMember(@RequestBody RequestMember requestMember){
        return new ResponseEntity<ResponseMember>(membersService.CreateMember(requestMember.getMember()), HttpStatus.OK);
    }

    @DeleteMapping("{member}")
    public ResponseEntity<ResponseMember> deleteMember(@PathVariable(value = "member") String user){
        return new ResponseEntity<ResponseMember>(membersService.DeleteMember(user), HttpStatus.OK);
    }
}
