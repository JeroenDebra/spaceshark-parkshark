package com.switchfully.spaceshark.controllers;

import com.switchfully.spaceshark.dtos.divisions.CreateDivisionDTO;
import com.switchfully.spaceshark.dtos.divisions.DivisionDTO;
import com.switchfully.spaceshark.mappers.DivisionMapper;
import com.switchfully.spaceshark.service.DivisionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DivisionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private DivisionMapper divisionMapper;

    @Test
    void testAddDivision() {
        CreateDivisionDTO createDivisionDTO = new CreateDivisionDTO();
        createDivisionDTO.setName("name");
        createDivisionDTO.setOriginalName("originalName");
        createDivisionDTO.setDirector_firstname("firstName");
        createDivisionDTO.setDirector_lastname("lastName");

        HttpHeaders header = new HttpHeaders();
        header.set("userId","1");

        HttpEntity<CreateDivisionDTO> request = new HttpEntity<>(createDivisionDTO, header);

        ResponseEntity<DivisionDTO> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/divisions", request, DivisionDTO.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotEquals(responseEntity.getBody(), null);
        assertEquals(responseEntity.getBody().getName(), divisionMapper.divisionToDivisionDTO(divisionMapper.createDivisionDTOToDivision(createDivisionDTO)).getName());
    }

    @Test
    void givenInvalidInput_whenCreatingDivision_thenReturnBadRequest() {
        CreateDivisionDTO createDivisionDTO = new CreateDivisionDTO();
        createDivisionDTO.setName(null);
        createDivisionDTO.setOriginalName("originalName");
        createDivisionDTO.setDirector_firstname("firstName");
        createDivisionDTO.setDirector_lastname("lastName");

        HttpHeaders header = new HttpHeaders();
        header.set("userId","1");

        HttpEntity<CreateDivisionDTO> request = new HttpEntity<>(createDivisionDTO, header);

        ResponseEntity<DivisionDTO> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/divisions", request, DivisionDTO.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void testGetAllDivisions() {
        CreateDivisionDTO createDivisionDTO = new CreateDivisionDTO();
        createDivisionDTO.setName("name");
        createDivisionDTO.setOriginalName("originalName");
        createDivisionDTO.setDirector_firstname("firstName");
        createDivisionDTO.setDirector_lastname("lastName");

        int sizeBeforeAdding = divisionService.getAllDivisions().size();

        divisionService.save(divisionMapper.createDivisionDTOToDivision(createDivisionDTO));

        HttpHeaders header = new HttpHeaders();
        header.set("userId","1");
        HttpEntity<String> request = new HttpEntity<>(header);

        ResponseEntity<DivisionDTO[]> responseEntity = this.testRestTemplate
                .exchange("http://localhost:" + port + "/divisions", HttpMethod.GET, request, DivisionDTO[].class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(sizeBeforeAdding + 1, divisionService.getAllDivisions().size());
        assertEquals(divisionService.getAllDivisions().size(), responseEntity.getBody().length);
    }

}
