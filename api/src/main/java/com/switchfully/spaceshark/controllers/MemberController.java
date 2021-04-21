package com.switchfully.spaceshark.controllers;

import com.switchfully.spaceshark.dtos.CreateMemberDto;
import com.switchfully.spaceshark.dtos.MemberDto;
import com.switchfully.spaceshark.mappers.MemberMapper;
import com.switchfully.spaceshark.model.people.Member;
import com.switchfully.spaceshark.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/members")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto createMember(@RequestBody CreateMemberDto createMemberDto){
        Member member = memberService.save(memberMapper.createMemberDtoToMember(createMemberDto));
        logger.info("Member is added: " + member);
        return memberMapper.memberToMemberDto(member);
    }
}
