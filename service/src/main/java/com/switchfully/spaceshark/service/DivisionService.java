package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.model.Director;
import com.switchfully.spaceshark.model.Division;
import com.switchfully.spaceshark.repositories.DirectorRepository;
import com.switchfully.spaceshark.repositories.DivisionRepository;
import com.switchfully.spaceshark.utils.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {
    private final DivisionRepository divisionRepository;
    private final DirectorService directorService;

    public DivisionService(DivisionRepository divisionRepository, DirectorService directorService) {
        this.divisionRepository = divisionRepository;
        this.directorService = directorService;
    }

    public Division save(Division division){

        Director director = new Director(division.getDirector().getFirstname(),division.getDirector().getLastname());
        directorService.createDirector(director);

        division.setDirector(director);
        divisionRepository.save(division);
        return division;
    }

    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }
}
