package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.repositories.ManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public boolean managerExistsWithId(int id){
        return managerRepository.findById(id).isPresent();
    }

}
