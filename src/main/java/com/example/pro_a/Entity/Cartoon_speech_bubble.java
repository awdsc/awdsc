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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cartoon_id", nullable = false)
    private Long cartoonId;

    @Column(name = "img", nullable = true)
    private Long imgNumber;

    @Column(name = "speech_bubble_type", nullable = true)
    private String speechBubbleType;


    @Column(name = "content_text" , nullable = true)
    private String content_text;

    @Column(name = "class" , nullable = true)
    private String classList;


    @Column(name = "width", nullable = true)
    private String width;

    @Column(name = "height", nullable = true)
    private String height;

    @Column(name = "top", nullable = true)
    private String top;

    @Column(name = "lefta", nullable = true)
    private String left;

    public void setId(Long id) {
        this.id = id;
    }

}
