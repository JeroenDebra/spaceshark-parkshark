package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.model.people.Member;
import com.switchfully.spaceshark.repositories.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    private final MemberRepository memberRepository;
    private final AddressService addressService;

    @Autowired
    public MemberService(MemberRepository memberRepository, AddressService addressService) {
        this.memberRepository = memberRepository;
        this.addressService = addressService;
    }

    public Member save(Member member){
        Member memberAdded = memberRepository.save(member);
        logger.info("Creating a Member." + memberAdded);
        return memberAdded;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
