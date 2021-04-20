package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.model.Director;
import com.switchfully.spaceshark.model.Division;
import com.switchfully.spaceshark.repositories.DirectorRepository;
import com.switchfully.spaceshark.repositories.DivisionRepository;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    private final DivisionRepository divisionRepository;
    private final DirectorRepository directorRepository;

    public DivisionService(DivisionRepository divisionRepository, DirectorRepository directorRepository) {
        this.divisionRepository = divisionRepository;
        this.directorRepository = directorRepository;
    }

    public Division save(Division division){

        Director director = new Director(division.getDirector().getFirstname(),division.getDirector().getLastname());
        directorRepository.save(director);

        division.setDirector(director);
        divisionRepository.save(division);
        return division;
    }
}
