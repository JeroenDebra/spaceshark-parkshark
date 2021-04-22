package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.model.parkingLot.Parkinglot;
import com.switchfully.spaceshark.repositories.ParkinglotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkinglotService {

    private final ParkinglotRepository parkinglotRepository;


    public ParkinglotService(ParkinglotRepository parkinglotRepository) {
        this.parkinglotRepository = parkinglotRepository;
    }

    public Parkinglot save(Parkinglot parkinglot) {
        return parkinglotRepository.save(parkinglot);
    }

    public Parkinglot findParkinglotById(int id){
        Optional<Parkinglot> optionalPakinglot = parkinglotRepository.findById(id);
        return optionalPakinglot.orElseThrow(() -> new IllegalArgumentException("parkinglot with id " + id + " is not found"));
    }

}
