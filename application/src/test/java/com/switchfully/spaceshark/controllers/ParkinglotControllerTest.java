package com.switchfully.spaceshark.controllers;

import com.switchfully.spaceshark.dtos.addresses.CreateAddressDTO;
import com.switchfully.spaceshark.dtos.contactpersons.CreateContactPersonDTO;
import com.switchfully.spaceshark.dtos.divisions.CreateDivisionDTO;
import com.switchfully.spaceshark.dtos.divisions.DivisionDTO;
import com.switchfully.spaceshark.dtos.parkinglots.CreateParkinglotDTO;
import com.switchfully.spaceshark.dtos.parkinglots.OverviewParkinglotDTO;
import com.switchfully.spaceshark.dtos.parkinglots.ParkinglotDTO;
import com.switchfully.spaceshark.dtos.postalcodes.CreatePostalCodeDTO;
import com.switchfully.spaceshark.mappers.ParkinglotMapper;
import com.switchfully.spaceshark.service.ParkinglotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ParkinglotControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private ParkinglotService parkinglotService;
    @Autowired
    private ParkinglotMapper parkinglotMapper;

    @Test
    void createParkinglotTest() {
        CreateParkinglotDTO createParkinglotDTO = new CreateParkinglotDTO();
        CreatePostalCodeDTO createPostalCodeDTO = new CreatePostalCodeDTO();
        CreateAddressDTO createAddressDTO = new CreateAddressDTO();
        CreateContactPersonDTO createContactPersonDTO = new CreateContactPersonDTO();

        createContactPersonDTO.setName("name");
        createContactPersonDTO.setGsm("+12345678");
        createContactPersonDTO.setPhoneNumber("+1234567");
        createContactPersonDTO.setEmail("e@email.com");

        createPostalCodeDTO.setCode("1234");
        createPostalCodeDTO.setCity("city");

        createAddressDTO.setStreetName("streetName");
        createAddressDTO.setStreetNumber("1234");
        createAddressDTO.setPostalCodeDTO(createPostalCodeDTO);

        createParkinglotDTO.setName("name");
        createParkinglotDTO.setMaxCapacity(2);
        createParkinglotDTO.setCategory("UNDERGROUND_BUILDING");
        createParkinglotDTO.setAddress(createAddressDTO);
        createParkinglotDTO.setContactPerson(createContactPersonDTO);
        createParkinglotDTO.setPricePerHour(new BigDecimal(1));
        createParkinglotDTO.setCurrency("EUR");

        HttpHeaders header = new HttpHeaders();
        header.set("userId","1");

        HttpEntity<CreateParkinglotDTO> request = new HttpEntity<>(createParkinglotDTO, header);

        ResponseEntity<ParkinglotDTO> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/parkinglots", request, ParkinglotDTO.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotEquals(responseEntity.getBody(), null);
        assertEquals(responseEntity.getBody().getName(), parkinglotMapper.toParkinglotDTO(parkinglotMapper.createParkinglotDTOToParkinglot(createParkinglotDTO)).getName());
    }

    @Test
    void testGetAllParkingLots() {
        CreateParkinglotDTO createParkinglotDTO = new CreateParkinglotDTO();
        CreatePostalCodeDTO createPostalCodeDTO = new CreatePostalCodeDTO();
        CreateAddressDTO createAddressDTO = new CreateAddressDTO();
        CreateContactPersonDTO createContactPersonDTO = new CreateContactPersonDTO();

        createContactPersonDTO.setName("name");
        createContactPersonDTO.setGsm("+12345678");
        createContactPersonDTO.setPhoneNumber("+1234567");
        createContactPersonDTO.setEmail("e@email.com");

        createPostalCodeDTO.setCode("1234");
        createPostalCodeDTO.setCity("city");

        createAddressDTO.setStreetName("streetName");
        createAddressDTO.setStreetNumber("1234");
        createAddressDTO.setPostalCodeDTO(createPostalCodeDTO);

        createParkinglotDTO.setName("name");
        createParkinglotDTO.setMaxCapacity(2);
        createParkinglotDTO.setCategory("UNDERGROUND_BUILDING");
        createParkinglotDTO.setAddress(createAddressDTO);
        createParkinglotDTO.setContactPerson(createContactPersonDTO);
        createParkinglotDTO.setPricePerHour(new BigDecimal(1));
        createParkinglotDTO.setCurrency("EUR");

        HttpHeaders header = new HttpHeaders();
        header.set("userId","1");
        HttpEntity<String> request = new HttpEntity<>(header);

        int sizeBeforeAdding = parkinglotService.getAllParkingLots().size();
        parkinglotService.save(parkinglotMapper.createParkinglotDTOToParkinglot(createParkinglotDTO));

        ResponseEntity<OverviewParkinglotDTO[]> responseEntity = this.testRestTemplate
            .exchange("http://localhost:" + port + "/divisions", HttpMethod.GET, request, OverviewParkinglotDTO[].class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(sizeBeforeAdding + 1, parkinglotService.getAllParkingLots().size());
    }
}
