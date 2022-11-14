package com.example.pro_a.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cartoon_speech_bubble")
public class Cartoon_speech_bubble {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartoon_id", nullable = false)
    private Long cartoonId;

    @Column(name = "img", nullable = true)
    private Long imgNumber;

    @Column(name = "speech_bubble_type", nullable = true)
    private String speechBubbleType;

    @Column(name = "position", nullable = true)
    private String position;

    @Column(name = "size", nullable = true)
    private String size;

    @Column(name = "content_text" , nullable = true)
    private String content_text;

    @Column(name = "class" , nullable = true)
    private String ClassList;
}
