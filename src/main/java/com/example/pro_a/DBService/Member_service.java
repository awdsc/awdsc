package com.example.pro_a.DBService;

import com.example.pro_a.DBinterface.MemberRepository;
import com.example.pro_a.Entity.Member;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Member_service {

    private final MemberRepository memberRepository;

    public Long findByNameToId(String name)
    {
      Member member = memberRepository.findByMemId(name);
      return member.getMemberCode();
    }

}
