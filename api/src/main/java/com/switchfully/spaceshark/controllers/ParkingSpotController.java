package com.switchfully.spaceshark.controllers;

import com.switchfully.spaceshark.dtos.parkinglots.CreateParkingSpotDTO;
import com.switchfully.spaceshark.dtos.parkinglots.ParkingSpotDTO;
import com.switchfully.spaceshark.mappers.ParkingSpotMapper;
import com.switchfully.spaceshark.service.AuthorizationService;
import com.switchfully.spaceshark.service.ParkingSpotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkingspots")
public class ParkingSpotController {
    private static final Logger logger = LoggerFactory.getLogger(ParkingSpotController.class);


    private final ParkingSpotService parkingSpotService;
    private final ParkingSpotMapper parkingSpotMapper;
    private final AuthorizationService authorizationService;

    public ParkingSpotController(ParkingSpotService parkingSpotService, ParkingSpotMapper parkingSpotMapper, AuthorizationService authorizationService) {
        this.parkingSpotService = parkingSpotService;
        this.parkingSpotMapper = parkingSpotMapper;
        this.authorizationService = authorizationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingSpotDTO createParkingSpot(@RequestBody CreateParkingSpotDTO createParkingSpotDTO,
                                            @RequestHeader(value = "userId", required = false) String userId) {

        logger.info("Creating a parking spot: " + createParkingSpotDTO);
        authorizationService.throwExceptionIfNotMember(userId);
        return parkingSpotMapper.parkingSpotToParkingSpotDTO(parkingSpotService.createParkingSpot(
                createParkingSpotDTO.getParkinglotId(),
                createParkingSpotDTO.getMemberId(),
                createParkingSpotDTO.getStartTime(),
                createParkingSpotDTO.getLicensePlate()));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ParkingSpotDTO> getAllParkingSpots(@RequestParam(required = false) Integer limit, @RequestHeader(value = "userId", required = false) String userId) {
        authorizationService.throwExceptionIfNotManager(userId);
        logger.info("Getting all the parking spots");
        return parkingSpotMapper.parkingSpotListToParkingSpotDTOList(parkingSpotService.getAllParkingSpots(limit));
    }

}
