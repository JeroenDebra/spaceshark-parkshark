package com.switchfully.spaceshark.controller;

import com.switchfully.spaceshark.dto.CreateDivisionDTO;
import com.switchfully.spaceshark.dto.DivisionDTO;
import com.switchfully.spaceshark.mapper.DivisionMapper;
import com.switchfully.spaceshark.model.Division;
import com.switchfully.spaceshark.service.DivisionService;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

}
