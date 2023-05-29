package com.example.Collecting_Marketing_Leads.controller;

import com.example.Collecting_Marketing_Leads.dto.MemberDto;
import com.example.Collecting_Marketing_Leads.entity.Member;
import com.example.Collecting_Marketing_Leads.mapper.MemberMapper;
import com.example.Collecting_Marketing_Leads.service.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {
//    @Autowired
//    MemberMapper memberMapper;
//    @Autowired
//    MockMvc mvc;
    private final MemberService memberService = Mockito.mock(MemberService.class);
    private final MemberMapper memberMapper = Mockito.mock(MemberMapper.class);

    @Test
    void postMember() {
        //given
//        String name = "qwer";
//        String email = "qwer@gmail.com";
//        String tel = "82+1111-2222";
//        Boolean agreement = true;

        //when

        //then

        MemberDto.Post post = new MemberDto.Post();
        Member member = new Member();
        MemberDto.response response = new MemberDto.response();

        when(memberMapper.memberPostDtoToMember(post)).thenReturn(member);
        when(memberService.createMember(member)).thenReturn(member);
        when(memberMapper.memberToMemberResponseDto(member)).thenReturn(response);

        MemberController memberController = new MemberController(memberService, memberMapper);
        ResponseEntity<MemberDto.response> result = memberController.postMember(post);

        assert result != null;
        assert result.getStatusCode() == HttpStatus.CREATED;
        assert result.getBody() == response;

        Mockito.verify(memberMapper).memberPostDtoToMember(post);
        Mockito.verify(memberService).createMember(member);
        Mockito.verify(memberMapper).memberToMemberResponseDto(member);
    }
}