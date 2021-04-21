package com.switchfully.spaceshark.controller;

import com.switchfully.spaceshark.dto.CreateParkinglotDTO;
import com.switchfully.spaceshark.mapper.ParkinglotMapper;
import com.switchfully.spaceshark.model.parkingLot.Parkinglot;
import com.switchfully.spaceshark.service.ParkinglotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/parkinglots")
public class ParkinglotController {

    private final ParkinglotService parkinglotService;
    private final ParkinglotMapper parkinglotMapper;

    public ParkinglotController(ParkinglotService parkinglotService, ParkinglotMapper parkinglotMapper) {
        this.parkinglotService = parkinglotService;
        this.parkinglotMapper = parkinglotMapper;
    }

    @PostMapping(consumes = "Application/JSON")
    @ResponseStatus(HttpStatus.CREATED)
    public void createParkinglot(@RequestBody CreateParkinglotDTO createParkinglotDTO) {
        Parkinglot parkinglot = parkinglotMapper.toParkinglot(createParkinglotDTO);
        parkinglotService.save(parkinglot, createParkinglotDTO.getAddressId(), createParkinglotDTO.getContactPersonId());
    }
}
