package com.example.pro_a.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_code", nullable = false)
    private Long memberCode;

    @Column(name ="mem_id")
    private String  memId;

    @Column(name = "mem_pass")
    private Long memPass;


}
