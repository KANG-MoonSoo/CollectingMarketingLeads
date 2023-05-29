package com.example.Collecting_Marketing_Leads.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;

    @Email
    @Column(nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String tel;

    @Column(nullable = false)
    private Boolean agreement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "STATUS")
    private MemberStatus memberStatus = MemberStatus.MEMBER_EXIST;
    public enum MemberStatus{
        MEMBER_EXIST("존재하는 회원");

        @Getter
        private String status;

        MemberStatus(String status){
            this.status = status;
        }
    }
}
