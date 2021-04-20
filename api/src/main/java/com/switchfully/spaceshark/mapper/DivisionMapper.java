package com.switchfully.spaceshark.mapper;

import com.switchfully.spaceshark.dto.CreateDivisionDTO;
import com.switchfully.spaceshark.dto.DivisionDTO;
import com.switchfully.spaceshark.model.Director;
import com.switchfully.spaceshark.model.Division;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {

    public Division toDivision(CreateDivisionDTO createDivisionDTO){
        return new Division(createDivisionDTO.getName(),createDivisionDTO.getOriginalName(),
                new Director(createDivisionDTO.getDirector_firstname(), createDivisionDTO.getDirector_lastname()));
    }

    public DivisionDTO toDTO(Division division){
        return new DivisionDTO()
                .setId(division.getId())
                .setName(division.getName())
                .setOriginalName(division.getOriginalName())
                .setDirectorFirstname(division.getDirector().getFirstname())
                .setDirectorLastname(division.getDirector().getLastname());
    }



}
