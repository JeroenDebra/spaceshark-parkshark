package com.switchfully.spaceshark.services;

import com.switchfully.spaceshark.model.people.Director;
import com.switchfully.spaceshark.repositories.DirectorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    private static final Logger logger = LoggerFactory.getLogger(DivisionService.class);
    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public Director createDirector(Director director) {
        Director directorToSave = directorRepository.save(director);
        logger.info("Director is created: " + directorToSave);
        return directorToSave;
    }
}
