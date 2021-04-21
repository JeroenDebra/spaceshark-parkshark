package com.switchfully.spaceshark.controllers;

import com.switchfully.spaceshark.dtos.*;
import com.switchfully.spaceshark.mappers.MemberMapper;
import com.switchfully.spaceshark.service.MemberService;
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
class MemberControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void testCreateMember() {
        CreateMemberDto createMemberDto = new CreateMemberDto();
        CreateAddressDTO createAddressDTO = new CreateAddressDTO();
        CreatePostalCodeDTO createPostalCodeDTO = new CreatePostalCodeDTO();

        createPostalCodeDTO.setPostalCode("1234");
        createPostalCodeDTO.setCity("Leuven");

        createAddressDTO.setStreetName("street");
        createAddressDTO.setStreetNumber("12A");
        createAddressDTO.setPostalCodeDTO(createPostalCodeDTO);

        createMemberDto.setFirstName("first name")
                .setLastName("last name")
                .setEmail("first@last.com")
                .setLicencePlate("12 FD 457")
                .setPhoneNumber("+32045824684")
                .setAddress(createAddressDTO);

        ResponseEntity<MemberDto> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/members", createMemberDto, MemberDto.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotEquals(responseEntity.getBody(), null);
        assertEquals(responseEntity.getBody().getFirstName(), memberMapper.memberToMemberDto(memberMapper.createMemberDtoToMember(createMemberDto)).getFirstName());
    }

    @Test
    void givenInvalidInput_whenCreatingMember_thenReturnBadRequest() {
        CreateMemberDto createMemberDto = new CreateMemberDto();
        CreateAddressDTO createAddressDTO = new CreateAddressDTO();
        CreatePostalCodeDTO createPostalCodeDTO = new CreatePostalCodeDTO();

        createPostalCodeDTO.setPostalCode("1234");
        createPostalCodeDTO.setCity("Leuven");

        createAddressDTO.setStreetName("street");
        createAddressDTO.setStreetNumber("12A");
        createAddressDTO.setPostalCodeDTO(createPostalCodeDTO);

        createMemberDto.setFirstName("first name")
                .setLastName(null)
                .setEmail("first@last.com")
                .setLicencePlate("12 FD 457")
                .setPhoneNumber("+32045824684")
                .setAddress(createAddressDTO);

        ResponseEntity<MemberDto> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/members", createMemberDto, MemberDto.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}
