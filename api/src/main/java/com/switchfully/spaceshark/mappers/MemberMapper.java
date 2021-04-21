package com.switchfully.spaceshark.mappers;

import com.switchfully.spaceshark.dtos.*;
import com.switchfully.spaceshark.model.addresses.Address;
import com.switchfully.spaceshark.model.addresses.PostalCode;
import com.switchfully.spaceshark.model.people.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    private static final Logger logger = LoggerFactory.getLogger(MemberMapper.class);

    public Member createMemberDtoToMember(CreateMemberDto createMemberDto) {
        logger.info("Converting a CreateMemberDto to Member, return a Member.");
        return new Member(createMemberDto.getFirstName(), createMemberDto.getLastName(), createMemberDtoToAddress(createMemberDto),
                createMemberDto.getPhoneNumber(), createMemberDto.getEmail(), createMemberDto.getLicencePlate());
    }

    public MemberDto memberToMemberDto(Member member) {
        return new MemberDto().setFirstName(member.getFirstName()).setLastName(member.getLastName()).setAddress(addressToAddressDto(member.getAddress()))
                .setEmail(member.getEmail()).setId(member.getId()).setLicencePlate(member.getLicencePlate()).setPhoneNumber(member.getPhoneNumber())
                .setRegistrationDate(member.getRegistrationDate());
    }

    public Address createMemberDtoToAddress(CreateMemberDto createMemberDto) {
        return new Address(createMemberDto.getAddress().getStreetName(),createMemberDto.getAddress().getStreetNumber(),
                new PostalCode(createMemberDto.getAddress().getPostalCodeDTO().getPostalCode(),
                        createMemberDto.getAddress().getPostalCodeDTO().getCity()));
    }

    public AddressDto addressToAddressDto(Address address){
        return new AddressDto().setStreetName(address.getStreetName()).setStreetNumber(address.getStreetNumber())
                .setPostalCode(postalCodeToPostalCodeDto(address.getPostalCode())).setId(address.getId());

    }

    public PostalCodeDTO postalCodeToPostalCodeDto(PostalCode postalDetails){
        return new PostalCodeDTO().setPostalCode(postalDetails.getPostalCode()).setCity(postalDetails.getCity()).setId(postalDetails.getId());
    }

    public PostalCode createPostalCodeDtoToPostalCode(CreatePostalCodeDTO createPostalCodeDTO){
        return new PostalCode(createPostalCodeDTO.getPostalCode(), createPostalCodeDTO.getCity());
    }
}
