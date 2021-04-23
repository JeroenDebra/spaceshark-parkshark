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

    public void throwExceptionIfIdNotParsable(String userId){

        try {
            Integer.valueOf(userId);
        } catch (NumberFormatException e) {
            throw new NotAuthorizedException("user with id " + userId + " is not a valid id");
        }
    }

    public void throwExceptionIfNotManager(String userId){
        throwExceptionIfIdNotParsable(userId);

        if (!managerService.managerExistsWithId(Integer.valueOf(userId))){
            throw new NotAuthorizedException("user with id " + userId + " is not a manager");
        }
    }
    public void throwExceptionIfNotMember(String userId){
        if (!memberService.memberExistsWithId(Integer.valueOf(userId))){
            throwExceptionIfIdNotParsable(userId);

            throw new NotAuthorizedException("user with id " + userId + " is not a member");
        }
    }


}
