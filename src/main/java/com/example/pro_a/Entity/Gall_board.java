package com.example.pro_a.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gall_board")
public class Gall_board {
    
    //보드 고유번호
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gall_number", nullable = false)
    private int id;

    //작성자 외래키 연결 : member >> member_code
    @Column(name = "writer",nullable = true)
    @JoinColumn(name="member_code")
    private int writer;
    
    //제목
    @Column(name = "title",nullable = true )
    private String board_title;
    
    //내용
    @Column(name = "content",nullable = true )
    private int board_content;
    
    //조회수
    @Column(name = "readcount",nullable = true)
    private int board_readCount;
    
    //파일 이름
    @Column(name = "filename",nullable = true )
    private String filename;
    
    //추천수
    @Column(name = "recommendation_count",nullable = true)
    private int recommendation_count;
    
    //삭제여부
    @Column(name = "elimination",nullable = true)
    private boolean elimination;
}
