package com.switchfully.spaceshark.controllers;

import com.switchfully.spaceshark.dtos.parkinglots.CreateParkingSpotDTO;
import com.switchfully.spaceshark.dtos.parkinglots.ParkingSpotDTO;
import com.switchfully.spaceshark.mappers.ParkingSpotMapper;
import com.switchfully.spaceshark.service.ParkingSpotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkingspots")
public class ParkingSpotController {
    private final ParkingSpotService parkingSpotService;
    private final ParkingSpotMapper parkingSpotMapper;

    public ParkingSpotController(ParkingSpotService parkingSpotService, ParkingSpotMapper parkingSpotMapper) {
        this.parkingSpotService = parkingSpotService;
        this.parkingSpotMapper = parkingSpotMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingSpotDTO createParkingSpot(@RequestBody CreateParkingSpotDTO createParkingSpotDTO,
                                            @RequestHeader(value = "userId", required = false) String userId) {

        return parkingSpotMapper.parkingSpotToParkingSpotDTO(parkingSpotService.createParkingSpot(
                createParkingSpotDTO.getParkinglotId(),
                createParkingSpotDTO.getMemberId(),
                createParkingSpotDTO.getStartTime(),
                createParkingSpotDTO.getLicensePlate()));
    }

}
