package com.switchfully.spaceshark.mappers;

import com.switchfully.spaceshark.dtos.addresses.AddressDTO;
import com.switchfully.spaceshark.dtos.members.CreateMemberDto;
import com.switchfully.spaceshark.dtos.members.MemberDTO;
import com.switchfully.spaceshark.dtos.members.OverviewMemberDTO;
import com.switchfully.spaceshark.dtos.postalcodes.PostalCodeDTO;
import com.switchfully.spaceshark.model.addresses.Address;
import com.switchfully.spaceshark.model.addresses.PostalCode;
import com.switchfully.spaceshark.model.people.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    private static final Logger logger = LoggerFactory.getLogger(MemberMapper.class);

    public Member createMemberDtoToMember(CreateMemberDto createMemberDto) {
        logger.info("Converting a CreateMemberDto to Member, return a Member.");
        return new Member(createMemberDto.getFirstName(), createMemberDto.getLastName(), createMemberDtoToAddress(createMemberDto),
                createMemberDto.getPhoneNumber(), createMemberDto.getEmail(), createMemberDto.getLicencePlate());
    }

    public MemberDTO memberToMemberDto(Member member) {
        logger.info("Converting a Member to a MemberDto, return a MemberDto.");
        return new MemberDTO()
                .setFirstName(member.getFirstName())
                .setLastName(member.getLastName())
                .setAddress(addressToAddressDto(member.getAddress()))
                .setEmail(member.getEmail())
                .setId(member.getId())
                .setLicencePlate(member.getLicencePlate())
                .setPhoneNumber(member.getPhoneNumber())
                .setRegistrationDate(member.getRegistrationDate());
    }

    public Address createMemberDtoToAddress(CreateMemberDto createMemberDto) {
        logger.info("Passing a CreateMemberDto to get Address, return an Address.");
        return new Address(createMemberDto.getAddress().getStreetName(),createMemberDto.getAddress().getStreetNumber(),
                new PostalCode(createMemberDto.getAddress().getPostalCodeDTO().getCode(),
                        createMemberDto.getAddress().getPostalCodeDTO().getCity()));
    }

    public AddressDTO addressToAddressDto(Address address){
        logger.info("Converting an Address to an AddressDto, return a AddressDto.");
        return new AddressDTO().setStreetName(address.getStreetName()).setStreetNumber(address.getStreetNumber())
                .setPostalCode(postalCodeToPostalCodeDto(address.getPostalCode())).setId(address.getId());
    }

    public PostalCodeDTO postalCodeToPostalCodeDto(PostalCode postalDetails){
        logger.info("Converting PostalCode to a PostalCodeDto, return a PostalCodeDto.");
        return new PostalCodeDTO().setCode(postalDetails.getCode()).setCity(postalDetails.getCity()).setId(postalDetails.getId());
    }

    public List<OverviewMemberDTO> toOverviewMemberDtoList(List<Member> allMembers) {
        logger.info("Converting a list of Members to a List of OverviewMemberDto, return a List of OverviewMemberDto.");
        return allMembers.stream().map(member -> memberToOverviewMemberDto(member)).collect(Collectors.toList());
    }

    public OverviewMemberDTO memberToOverviewMemberDto(Member member){
        logger.info("Converting a Member to an OverviewMemberDto, return an OverviewMemberDto.");
        return new OverviewMemberDTO().setFirstName(member.getFirstName()).setLastName(member.getLastName())
                .setEmail(member.getEmail()).setId(member.getId()).setLicencePlate(member.getLicencePlate())
                .setPhoneNumber(member.getPhoneNumber()).setRegistrationDate(member.getRegistrationDate());
    }
}
