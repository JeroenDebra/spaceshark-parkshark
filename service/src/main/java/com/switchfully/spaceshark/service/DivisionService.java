package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.model.Division;
import com.switchfully.spaceshark.repositories.DivisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {
    private final DivisionRepository divisionRepository;

    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Division save(Division division){
        divisionRepository.save(division);
        return division;
    }

    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }
}
