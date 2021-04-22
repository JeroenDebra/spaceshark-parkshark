package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.customExeptions.NotAuthorizedException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final ManagerService managerService;

    public AuthorizationService(ManagerService managerService) {
        this.managerService = managerService;
    }


    public void throwExceptionIfNotManager(String userId){
        if (!managerService.managerExistsWithId(Integer.valueOf(userId))){
            throw new NotAuthorizedException("user with id " + userId + "is not a manager");
        }
    }


}
