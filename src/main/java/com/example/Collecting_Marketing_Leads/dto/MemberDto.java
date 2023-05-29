package com.example.Collecting_Marketing_Leads.dto;

import com.example.Collecting_Marketing_Leads.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class MemberDto {
    @Getter
    @Setter
    public static class Post{
        @NotBlank(message = "The name must not be blank")
        private String name;

        @NotBlank(message = "The email must not be blank")
        private String email;

        @NotBlank(message = "The tel must not be blank")
        private String tel;

        private Boolean agreement;
    }
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    public static class Patch{
//        @NotBlank(message = "The name must not be blank")
//        private String name;
//
//        @NotBlank(message = "The email must not be blank")
//        private String email;
//
//        @NotBlank(message = "The tel must not be blank")
//        private String tel;
//
//        private Boolean agreement;
//    }
    @Getter
    @Setter
    public static class response{
        private Long memberId;
        private String name;
        private String email;
        private String tel;
        private Boolean agreement;
        private Member.MemberStatus memberStatus;
    }
}
