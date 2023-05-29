package com.example.Collecting_Marketing_Leads.service;

import com.example.Collecting_Marketing_Leads.entity.Member;
import com.example.Collecting_Marketing_Leads.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    public Member createMember(Member member){
        return memberRepository.save(member);
    }
}
