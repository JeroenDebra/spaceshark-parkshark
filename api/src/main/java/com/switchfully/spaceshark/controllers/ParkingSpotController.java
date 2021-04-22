package com.switchfully.spaceshark.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkingspots")
public class ParkingSpotController {

    @PostMapping("")
    public ParkingSpotDTO createParkingSpot(@RequestBody CreateParkingSpotDTO createParkingSpotDTO){
        return null;
    }


}
