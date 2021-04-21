package com.switchfully.spaceshark.mappers;

import com.switchfully.spaceshark.controllers.DivisionController;
import com.switchfully.spaceshark.dtos.CreateMemberDto;
import com.switchfully.spaceshark.dtos.MemberDto;
import com.switchfully.spaceshark.model.addresses.Address;
import com.switchfully.spaceshark.model.people.Member;
import com.switchfully.spaceshark.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    private static final Logger logger = LoggerFactory.getLogger(MemberMapper.class);

/*    public Member dtoToMember(CreateMemberDto createMemberDto) {
        logger.info("Converting a CreateMemberDto to Member, return a Member.");
        return new Member(createMemberDto.getFirstName(), createMemberDto.getLastName(),createMemberDto.getAddress_id(),  )

    }*/
}
