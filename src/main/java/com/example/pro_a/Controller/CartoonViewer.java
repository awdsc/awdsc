package com.example.pro_a.Controller;

import com.example.pro_a.DBService.Board_coment_service;
import com.example.pro_a.DBService.Board_service;
import com.example.pro_a.DBService.Cartoon_img_service;
import com.example.pro_a.DBService.Cartoon_speech_bubble_service;
import com.example.pro_a.Entity.Cartoon_img;
import com.example.pro_a.Entity.Cartoon_speech_bubble;
import com.example.pro_a.Entity.Gall_board;
import com.example.pro_a.Entity.Gall_coment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cartoon")
@RequiredArgsConstructor
public class CartoonViewer {
    private final Board_service board_service;
    private final Board_coment_service board_coment_service;

    private final Cartoon_img_service cartoon_img_service;

    private  final Cartoon_speech_bubble_service cartoon_speech_bubble_service;
    @RequestMapping("/cartoonviewer/{id}")
    public String cartoonViewr(@PathVariable Long id, ModelMap mm)
    {
        Gall_board gall_board = board_service.findOneBoard(id);
        List<Gall_coment> coments = board_coment_service.comentList(id);
        Cartoon_img cartoon_img = cartoon_img_service.selectById(id);
        List<Cartoon_speech_bubble> cartoon_speech_bubbles = cartoon_speech_bubble_service.selectById(String.valueOf(id));

        mm.addAttribute("cartoon",gall_board);
        mm.addAttribute("cartoonImg",cartoon_img);
        mm.addAttribute("carttonBubble",cartoon_speech_bubbles);
        mm.addAttribute("conment",coments);

        return "/cartoonViewer";
    }
}
