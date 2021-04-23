package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.model.people.Member;
import com.switchfully.spaceshark.repositories.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member save(Member member){
        Member memberAdded = memberRepository.save(member);
        logger.info("Creating a Member." + memberAdded);
        return memberAdded;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    public Member findMemberById(int id){
        Optional<Member> optionalMember = memberRepository.findById(id);
        return optionalMember.orElseThrow(() -> new IllegalArgumentException("member with id " + id + " could not be found."));
    }

    public boolean memberExistsWithId(int id){
        return memberRepository.findById(id).isPresent();
    }

}
