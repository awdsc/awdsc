package com.example.pro_a.Controller;


import com.example.pro_a.DBService.Board_service;
import com.example.pro_a.DBService.Cartoon_img_service;
import com.example.pro_a.DBService.Cartoon_speech_bubble_service;
import com.example.pro_a.Entity.Cartoon_img;
import com.example.pro_a.Entity.Cartoon_speech_bubble;
import com.example.pro_a.Entity.Gall_board;
import com.example.pro_a.VO.CartoonSaveVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/cartoon/create")
@RequiredArgsConstructor
public class CartoonCreateCon {
    private  final Cartoon_img_service cartoon_img_service;
    private  final Cartoon_speech_bubble_service cartoon_speech_bubble_service;
    private  final Board_service board_service;
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
    public String cartoonSave(@RequestBody CartoonSaveVo cartoonSaveVo)
    {

        //cartoon_img 에 save
        List<String> urlList = cartoonSaveVo.getImg();

        Cartoon_img cartoon_img =  Cartoon_img.builder()
                .img1(urlList.get(1))
                .img2(urlList.get(2))
                .img3(urlList.get(3))
                .img4(urlList.get(4))
                .build();

        cartoon_img_service.imgSave(cartoon_img);
        //json에서 말풍선 분리
        //cartoon_speech 에 저장
        List<Cartoon_speech_bubble> cartoon_speech_bubbles = cartoonSaveVo.getCartoon_speech_bubbleList();
        cartoon_speech_bubble_service.saveAll(cartoon_speech_bubbles);

        Gall_board gall_board = Gall_board.builder()
                .boardTitle(cartoonSaveVo.getTitle())
                .writer(cartoonSaveVo.getWriter())
                .redDate(LocalDate.now())
                .board_content(cartoonSaveVo.getContent())
                .build();

        board_service.saveAuto(gall_board);
        return "redirect :/cartoon/list";
    }

}
