package com.example.pro_a.Controller;


import com.example.pro_a.DBService.Board_service;
import com.example.pro_a.DBService.Cartoon_img_service;
import com.example.pro_a.DBService.Cartoon_speech_bubble_service;
import com.example.pro_a.Entity.Cartoon_img;
import com.example.pro_a.Entity.Cartoon_speech_bubble;
import com.example.pro_a.Entity.Gall_board;
import com.example.pro_a.Entity.Member;
import com.example.pro_a.VO.BackgraoundImg;
import lombok.RequiredArgsConstructor;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/cartoon/create")
@RequiredArgsConstructor
public class CartoonCreateCon {
    private  final Cartoon_img_service cartoon_img_service;
    private  final Cartoon_speech_bubble_service cartoon_speech_bubble_service;
    private  final Board_service board_service;
    private static List<Cartoon_speech_bubble> cartoon_speech_bubbles = new ArrayList<>();
    private static Cartoon_img cartoon_img = new Cartoon_img();
    private Long cartoonNum;

    private String ona = "off";
    @GetMapping
    public String aa()
    {

        System.out.println(ona);
        if(ona.equals("off")) {
            cartoon_img = cartoon_img_service.getLastNum();
            if (cartoon_img != null) {
                cartoonNum = cartoon_img.getCartoon_id();
                cartoonNum++;
            } else {
                cartoonNum = 1L;
            }
            cartoon_img = Cartoon_img.builder()
                    .cartoon_id(cartoonNum)
                    .build();
            ona = "on";
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(cartoonNum);
        return "/cartoonMakepage";
    }


    @PostMapping("/submit")
    @ResponseBody
    public String cartoonSave(@RequestParam("cimg") MultipartFile cimg,
                              @RequestParam("cut") String cut,
                              @RequestParam("cobj") String[] s
                              ) throws ParseException {

        //cobj json parse
        JSONParser jsonParser = new JSONParser();

        for (String value : s) {
            System.out.println(value);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(value);
            Cartoon_speech_bubble cartoon_speech_bubble = Cartoon_speech_bubble.builder()
                    .imgNumber(Long.valueOf(cut))
                    .top((String) jsonObject.get("top"))
                    .left((String) jsonObject.get("left"))
                    .height((String) jsonObject.get("height"))
                    .width((String) jsonObject.get("width"))
                    .content_text((String) jsonObject.get("context"))
                    .classList((String) jsonObject.get("classes"))
                    .cartoonId(cartoonNum)
                    .speechBubbleType((String) jsonObject.get("img"))
                    .build();
            cartoon_speech_bubbles.add(cartoon_speech_bubble);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss_");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String currentTime = dateFormat.format(timestamp);
        //집 C:\Users\김규진\IdeaProjects\awdsc\src\main\resources\static\assets\img\
        //학교 C:\Users\km\IdeaProjects\Pro_A\src\main\resources\static\assets\img\
        String localStorePath = "C:\\Users\\김규진\\IdeaProjects\\awdsc\\src\\main\\resources\\static\\assets\\img\\" + currentTime + cimg.getOriginalFilename();
        try {
            cimg.transferTo(new File(localStorePath));
            localStorePath = "http://localhost:8081/static/assets/img/" + currentTime + cimg.getOriginalFilename();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //cartoon_img 에 save
        switch (cut) {
            case "1" -> cartoon_img.setImg1(localStorePath);
            case "2" -> cartoon_img.setImg2(localStorePath);
            case "3" -> cartoon_img.setImg3(localStorePath);
            case "4" -> {
                cartoon_img.setImg4(localStorePath);
                cartoon_img.setCartoon_id(cartoonNum);
                System.out.println(cartoon_img.getCartoon_id());
                cartoon_img_service.imgSave(cartoon_img);
                cartoon_speech_bubble_service.saveAll(cartoon_speech_bubbles);
            }
        }
        return "clear";
    }

    @PostMapping("board")
    @ResponseBody
    public String createBoard(@RequestBody String s)
    {
        //보드 만들기
        Gall_board gall_board = Gall_board.builder()
                .boardTitle(s)
                .filename(String.valueOf(cartoonNum))
                .build();
        board_service.saveAuto(gall_board);
        ona = "off";
        return "/cartoon/list";
    }

}
