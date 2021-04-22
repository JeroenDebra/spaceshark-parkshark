package com.switchfully.spaceshark.controllers;


import com.switchfully.spaceshark.dtos.parkinglots.CreateParkinglotDTO;
import com.switchfully.spaceshark.dtos.parkinglots.OverviewParkinglotDTO;
import com.switchfully.spaceshark.dtos.parkinglots.ParkinglotDTO;
import com.switchfully.spaceshark.mappers.ParkinglotMapper;
import com.switchfully.spaceshark.model.parkingLot.Parkinglot;
import com.switchfully.spaceshark.service.ParkinglotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/parkinglots")
public class ParkinglotController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final ParkinglotService parkinglotService;
    private final ParkinglotMapper parkinglotMapper;

    public ParkinglotController(ParkinglotService parkinglotService, ParkinglotMapper parkinglotMapper) {
        this.parkinglotService = parkinglotService;
        this.parkinglotMapper = parkinglotMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ParkinglotDTO createParkinglot(@RequestBody CreateParkinglotDTO createParkinglotDTO) {
        logger.info("parkinglot is being added: " + createParkinglotDTO.toString());
        Parkinglot parkinglot = parkinglotService.save(parkinglotMapper.createParkinglotDTOToParkinglot(createParkinglotDTO));

        return parkinglotMapper.toParkinglotDTO(parkinglot);
    }

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus (HttpStatus.OK)
    public List<OverviewParkinglotDTO> getAllParkinglots (){
        logger.info ("Getting list of all parkinglots...");
        return parkinglotMapper.toOverviewParkingLotDto(parkinglotService.getAllParkingLots());
    }
}
