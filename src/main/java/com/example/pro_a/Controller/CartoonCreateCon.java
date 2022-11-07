package com.example.pro_a.Controller;


import com.example.pro_a.DBService.Cartoon_img_service;
import com.example.pro_a.DBService.Cartoon_speech_bubble_service;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cartoon/create")
@RequiredArgsConstructor
public class CartoonCreateCon {
    private  final Cartoon_img_service cartoon_img_service;
    private  final Cartoon_speech_bubble_service cartoon_speech_bubble_service;

    @GetMapping
    public String aa()
    {
        return "cartoonMakepage";
    }

    @GetMapping("/{id}")
    public String cartoonCreate(Long id){

        return "cartoonMakePage";
    }

    @PostMapping("/{id}/submit")
    @ResponseBody
    public String cartoonSave(Long id, @PathVariable JSONPObject cartoon)
    {
        //json 에서 이미지 분리
        //json 에서 이미지 저장
        //cartoon_img 에 save

        //json에서 말풍선 분리
        //cartoon_speech 에 저장
        return "redirect :/cartoon/list";
    }

}
