package com.switchfully.spaceshark.mappers;

import com.switchfully.spaceshark.dtos.addresses.AddressDto;
import com.switchfully.spaceshark.dtos.members.CreateMemberDto;
import com.switchfully.spaceshark.dtos.members.MemberDto;
import com.switchfully.spaceshark.dtos.members.OverviewMemberDTO;
import com.switchfully.spaceshark.dtos.postalcodes.CreatePostalCodeDTO;
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

    public MemberDto memberToMemberDto(Member member) {
        logger.info("Converting a Member to MemberDTO, return a MemberDTO.");
        return new MemberDto()
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
        logger.info("Using a CreateMemberDto to get Address, return an Adress.");
        return new Address(createMemberDto.getAddress().getStreetName(), createMemberDto.getAddress().getStreetNumber(),
                new PostalCode(createMemberDto.getAddress().getPostalCodeDTO().getPostalCode(),
                        createMemberDto.getAddress().getPostalCodeDTO().getCity()));
    }

    public AddressDto addressToAddressDto(Address address) {
        logger.info("Converting an Address to a AddressDto, return an AddressDto.");
        return new AddressDto().setStreetName(address.getStreetName()).setStreetNumber(address.getStreetNumber())
                .setPostalCode(postalCodeToPostalCodeDto(address.getPostalCode())).setId(address.getId());
    }

    public PostalCodeDTO postalCodeToPostalCodeDto(PostalCode postalDetails) {
        logger.info("Converting a PostalCode to PostalCodeDto, return a PostalCodeDto.");
        return new PostalCodeDTO().setPostalCode(postalDetails.getPostalCode()).setCity(postalDetails.getCity()).setId(postalDetails.getId());
    }

    public List<OverviewMemberDTO> toOverviewMemberDtoList(List<Member> allMembers) {
        logger.info("Converting a list of Members to a List of OverviewMemberDtos, return a List of OverviewMemberDtos.");
        return allMembers.stream().map(member -> memberToOverviewMemberDto(member)).collect(Collectors.toList());
    }

    public OverviewMemberDTO memberToOverviewMemberDto(Member member) {
        logger.info("Converting a Member to an OverviewMemberDto, return an OverviewMemberDto.");
        return new OverviewMemberDTO()
                .setFirstName(member.getFirstName())
                .setLastName(member.getLastName())
                .setEmail(member.getEmail())
                .setId(member.getId())
                .setLicencePlate(member.getLicencePlate())
                .setPhoneNumber(member.getPhoneNumber())
                .setRegistrationDate(member.getRegistrationDate());
    }
}
