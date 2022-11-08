package com.example.pro_a.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cartoon_img")
public class Cartoon_img {

    @Id
    @Column(name = "cartoon_id", nullable = false)
    private Long cartoon_id;

    @Column(name = "img_1",nullable = true)
    private String img1;

    @Column(name = "img_2",nullable = true)
    private String img2;

    @Column(name = "img_3",nullable = true)
    private String img3;

    @Column(name = "img_4",nullable = true)
    private String img4;

    @ManyToOne
    @JoinColumn(name = "member_code")
    private Member member;


}