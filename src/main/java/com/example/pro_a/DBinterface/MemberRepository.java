package com.example.pro_a.DBinterface;

import com.example.pro_a.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
