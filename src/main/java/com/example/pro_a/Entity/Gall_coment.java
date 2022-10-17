package com.example.pro_a.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gall_coment")
public class Gall_coment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coment_no",nullable = false)
    private Long coment_no;

    @Column(name = "board_no",nullable = false)
    @JoinColumn(name = "gall_number")
    private int bard_no;

    @Column(name = "writer",nullable = true)
    @JoinColumn(name="member_code")
    private int writer;

    @Column(name ="content")
    private String content;

    @Column(name = "redDate")
    private Date redDate;
}
