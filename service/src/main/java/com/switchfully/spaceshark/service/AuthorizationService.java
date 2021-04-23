package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.customExeptions.NotAuthorizedException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final ManagerService managerService;
    private final MemberService memberService;

    public AuthorizationService(ManagerService managerService, MemberService memberService) {
        this.managerService = managerService;
        this.memberService = memberService;
    }

    public void throwExceptionIfNotManager(String userId){
        if (!managerService.managerExistsWithId(Integer.valueOf(userId))){
            throw new NotAuthorizedException("user with id " + userId + "is not a manager");
        }
    }
    public void throwExceptionIfNotMember(String userId){
        if (!memberService.memberExistsWithId(Integer.valueOf(userId))){
            throw new NotAuthorizedException("user with id " + userId + "is not a member");
        }
    }


}
