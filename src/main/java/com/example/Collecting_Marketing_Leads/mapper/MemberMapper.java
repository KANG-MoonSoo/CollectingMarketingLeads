package com.example.Collecting_Marketing_Leads.mapper;

import com.example.Collecting_Marketing_Leads.dto.MemberDto;
import com.example.Collecting_Marketing_Leads.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    default Member memberPostDtoToMember(MemberDto.Post post){
        Member member = new Member();
        member.setName(post.getName());
        member.setEmail(post.getEmail());
        member.setTel(post.getTel());
        member.setAgreement(post.getAgreement());
        return member;
    }
    default MemberDto.response memberToMemberResponseDto(Member member){
        MemberDto.response response = new MemberDto.response();
        response.setMemberId(member.getMemberId());
        response.setName(member.getName());
        response.setEmail(member.getEmail());
        response.setTel(member.getTel());
        response.setAgreement(member.getAgreement());
        response.setMemberStatus(member.getMemberStatus());
        return response;
    }
}
