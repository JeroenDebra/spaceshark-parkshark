package com.switchfully.spaceshark.controllers;

import com.switchfully.spaceshark.dtos.parkinglots.CreateParkingSpotDTO;
import com.switchfully.spaceshark.dtos.parkinglots.ParkingSpotDTO;
import com.switchfully.spaceshark.mappers.ParkingSpotMapper;
import com.switchfully.spaceshark.model.Price;
import com.switchfully.spaceshark.model.addresses.Address;
import com.switchfully.spaceshark.model.addresses.PostalCode;
import com.switchfully.spaceshark.model.parkingLot.Category;
import com.switchfully.spaceshark.model.parkingLot.Currency;
import com.switchfully.spaceshark.model.parkingLot.Parkinglot;
import com.switchfully.spaceshark.model.parkingallocation.ParkingSpot;
import com.switchfully.spaceshark.model.people.ContactPerson;
import com.switchfully.spaceshark.model.people.Member;
import com.switchfully.spaceshark.service.MemberService;
import com.switchfully.spaceshark.service.ParkingSpotService;
import com.switchfully.spaceshark.service.ParkinglotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ParkingSpotControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ParkingSpotService parkingSpotService;

    @Autowired
    private ParkinglotService parkinglotService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ParkingSpotMapper parkingSpotMapper;

    @Test
    void testCreateParkingSpot() {
        Parkinglot parkinglot = new Parkinglot("name", Category.ABOVE_GROUND_BUILDING, 10,
                new Price(new BigDecimal(2.0), Currency.EUR),
                new ContactPerson("name", "+0125647894", "+12458545452", "test@test.com"),
                new Address("street name", " 12",
                        new PostalCode("3000", "Leuven")));
        parkinglotService.save(parkinglot);


        Member member = new Member("name", "last name",
                new Address("street name", " 13", new PostalCode("3000", "Leuven")),
                "+12345678615", "test2@test.com", "DC 12 456");

        memberService.save(member);

        CreateParkingSpotDTO createParkingSpotDTO = new CreateParkingSpotDTO();
        createParkingSpotDTO.setParkinglotId(parkinglot.getId());
        createParkingSpotDTO.setMemberId(member.getId());
        createParkingSpotDTO.setStartTime(LocalDateTime.of(2021, 3, 20, 10,55));
        createParkingSpotDTO.setLicensePlate("DC 12 456");

        HttpHeaders header = new HttpHeaders();
        header.set("userId", "" + member.getId());

        HttpEntity<CreateParkingSpotDTO> request = new HttpEntity<>(createParkingSpotDTO, header);

        ResponseEntity<ParkingSpotDTO> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/parkingspots", request, ParkingSpotDTO.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotEquals(responseEntity.getBody(), null);
        assertEquals(responseEntity.getBody().getMember().getFirstName(), member.getFirstName());
        assertEquals(responseEntity.getBody().getParkinglot().getId(), parkinglot.getId());
    }

    @Test
    void testGetAllParkingSpots() {
        Parkinglot parkinglot = new Parkinglot("name", Category.ABOVE_GROUND_BUILDING, 10,
                new Price(new BigDecimal(2.0), Currency.EUR),
                new ContactPerson("name", "+0125647894", "+12458545452", "test@test.com"),
                new Address("street name", " 12",
                        new PostalCode("3000", "Leuven")));

        parkinglotService.save(parkinglot);

        Member member = new Member("name", "last name",
                new Address("street name", " 13", new PostalCode("3000", "Leuven")),
                "+12345678615", "test2@test.com", "DC 12 456");

        memberService.save(member);

        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkinglot(parkinglot);
        parkingSpot.setMember(member);
        parkingSpot.setStartTime(LocalDateTime.of(2021, 3, 20, 10,55));

        int sizeBeforeAdding = parkingSpotService.getAllParkingSpots(1000).size();

        parkingSpotService.createParkingSpot(parkingSpot.getParkinglot().getId(), parkingSpot.getMember().getId(),
                parkingSpot.getStartTime(), parkingSpot.getMember().getLicencePlate());

        HttpHeaders header = new HttpHeaders();
        header.set("userId","1");
        HttpEntity<String> request = new HttpEntity<>(header);

        ResponseEntity<ParkingSpotDTO[]> responseEntity = this.testRestTemplate
                .exchange("http://localhost:" + port + "/parkingspots?limit=1000", HttpMethod.GET, request, ParkingSpotDTO[].class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(sizeBeforeAdding + 1, parkingSpotService.getAllParkingSpots(1000).size());
        assertEquals(parkingSpotService.getAllParkingSpots(1000).size(), responseEntity.getBody().length);
    }
}
