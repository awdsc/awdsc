package com.example.pro_a.VO;

import com.example.pro_a.Entity.Cartoon_speech_bubble;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartoonSaveVo {
    private List<String> img; //img 영역
    private List<Cartoon_speech_bubble> cartoon_speech_bubbleList;
    private int writer;
    private String title;
    private String content;
}
