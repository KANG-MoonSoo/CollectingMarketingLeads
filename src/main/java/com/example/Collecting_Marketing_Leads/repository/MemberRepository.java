package com.example.Collecting_Marketing_Leads.repository;

import com.example.Collecting_Marketing_Leads.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
