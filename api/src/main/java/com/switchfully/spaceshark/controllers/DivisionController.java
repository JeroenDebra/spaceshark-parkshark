package com.switchfully.spaceshark.controllers;

import com.switchfully.spaceshark.dtos.CreateDivisionDTO;
import com.switchfully.spaceshark.dtos.DivisionDTO;
import com.switchfully.spaceshark.mappers.DivisionMapper;
import com.switchfully.spaceshark.model.Division;
import com.switchfully.spaceshark.service.DivisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/divisions")
public class DivisionController {

    private static final Logger logger = LoggerFactory.getLogger(DivisionController.class);

    private final DivisionService divisionService;
    private final DivisionMapper divisionMapper;

    public DivisionController(DivisionService divisionService, DivisionMapper divisionMapper) {
        this.divisionService = divisionService;
        this.divisionMapper = divisionMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DivisionDTO createDivision(@RequestBody CreateDivisionDTO createDivisionDTO){
        Division division = divisionService.save(divisionMapper.toDivision(createDivisionDTO));
        logger.info("Division is added: " + division);
        return divisionMapper.toDTO(division);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<DivisionDTO> getAllDivisions() {
        logger.info("Getting all divisions");
        return divisionMapper.toDTOList(divisionService.getAllDivisions());
    }

}
