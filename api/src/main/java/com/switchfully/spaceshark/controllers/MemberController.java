package com.switchfully.spaceshark.controllers;

import com.switchfully.spaceshark.dtos.members.CreateMemberDto;
import com.switchfully.spaceshark.dtos.members.MemberDto;
import com.switchfully.spaceshark.dtos.members.OverviewMemberDTO;
import com.switchfully.spaceshark.mappers.MemberMapper;
import com.switchfully.spaceshark.model.people.Member;
import com.switchfully.spaceshark.service.AuthorizationService;
import com.switchfully.spaceshark.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/members")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberService memberService;
    private final MemberMapper memberMapper;
    private final AuthorizationService authorizationService;

    public MemberController(MemberService memberService, MemberMapper memberMapper,AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<OverviewMemberDTO> getAllMembers( @RequestHeader(value = "userId", required = false) String userId) {
        authorizationService.throwExceptionIfNotManager(userId);
        logger.info("Getting all members");
        return memberMapper.toOverviewMemberDtoList(memberService.getAllMembers());
    }

}
