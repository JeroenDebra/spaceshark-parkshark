package com.switchfully.spaceshark.mappers;

import com.switchfully.spaceshark.dtos.divisions.CreateDivisionDTO;
import com.switchfully.spaceshark.dtos.divisions.DivisionDTO;
import com.switchfully.spaceshark.model.people.Director;
import com.switchfully.spaceshark.model.Division;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<DivisionDTO> toDTOList(List<Division> allDivisions) {
        return allDivisions.stream().map(this::toDTO).collect(Collectors.toList());
    }
}