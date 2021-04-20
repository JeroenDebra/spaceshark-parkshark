package com.switchfully.spaceshark;

import com.switchfully.spaceshark.dto.CreateDivisionDTO;
import com.switchfully.spaceshark.dto.DivisionDTO;
import com.switchfully.spaceshark.mapper.DivisionMapper;
import com.switchfully.spaceshark.service.DivisionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        ResponseEntity<DivisionDTO> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/divisions", createDivisionDTO, DivisionDTO.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotEquals(responseEntity.getBody(), null);
        assertEquals(responseEntity.getBody().getName(), divisionMapper.toDTO(divisionMapper.toDivision(createDivisionDTO)).getName());
    }

}
