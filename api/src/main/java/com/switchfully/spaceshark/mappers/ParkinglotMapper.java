package com.switchfully.spaceshark.mappers;

import com.switchfully.spaceshark.dtos.CreateParkinglotDTO;
import com.switchfully.spaceshark.model.parkingLot.Parkinglot;
import org.springframework.stereotype.Component;

@Component
public class ParkinglotMapper {
    public Parkinglot toParkinglot(CreateParkinglotDTO createParkinglotDTO){
        return new Parkinglot(createParkinglotDTO.getName(), createParkinglotDTO.getCategory(), createParkinglotDTO.getMaxCapacity());
    }
}
