package com.example.Collecting_Marketing_Leads.controller;

import com.example.Collecting_Marketing_Leads.dto.MemberDto;
import com.example.Collecting_Marketing_Leads.entity.Member;
import com.example.Collecting_Marketing_Leads.mapper.MemberMapper;
import com.example.Collecting_Marketing_Leads.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/member")
@Validated
@Slf4j
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;


    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post post){
        Member member = memberService.createMember(memberMapper.memberPostDtoToMember(post));
        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(member), HttpStatus.CREATED);
    }
}
