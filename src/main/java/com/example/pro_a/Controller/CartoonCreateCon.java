package com.example.pro_a.Controller;


import com.example.pro_a.DBService.Board_service;
import com.example.pro_a.DBService.Cartoon_img_service;
import com.example.pro_a.DBService.Cartoon_speech_bubble_service;
import com.example.pro_a.Entity.Cartoon_img;
import com.example.pro_a.Entity.Cartoon_speech_bubble;
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
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/cartoon/create")
@RequiredArgsConstructor
public class CartoonCreateCon {
    private  final Cartoon_img_service cartoon_img_service;
    private  final Cartoon_speech_bubble_service cartoon_speech_bubble_service;
    private  final Board_service board_service;

    private  Cartoon_img cartoon_img  = new Cartoon_img();

    @GetMapping
    public String aa()
    {
        return "cartoonMakepage";
    }


    @PostMapping("/submit")
    @ResponseBody
    public String cartoonSave(@RequestParam("cimg") MultipartFile cimg, @RequestParam("cut") String cut, @RequestParam("cobj") String[] s ) throws ParseException {
        System.out.println(Arrays.toString(s));
        List<Cartoon_speech_bubble> cartoon_speech_bubbles = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        Long id = 1L; //test
        for (String value : s) {
            System.out.println(value);
            /*
            JSONObject jsonObject = (JSONObject) jsonParser.parse(value);
            Cartoon_speech_bubble cartoon_speech_bubble = Cartoon_speech_bubble.builder()
                    .imgNumber(Long.valueOf(cut))
                    .top((String) jsonObject.get("top"))
                    .left((String) jsonObject.get("left"))
                    .height((String) jsonObject.get("height"))
                    .width((String) jsonObject.get("width"))
                    .content_text((String) jsonObject.get("context"))
                    .classList((String) jsonObject.get("classes"))
                    .cartoonId(id)
                    .speechBubbleType((String) jsonObject.get("img"))
                    .build();
            cartoon_speech_bubbles.add(cartoon_speech_bubble);

             */
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss_");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String currentTime = dateFormat.format(timestamp);



        String localStorePath = "C:\\Users\\김규진\\IdeaProjects\\awdsc\\src\\main\\resources\\static\\assets\\img\\"+ currentTime  + cimg.getOriginalFilename();
        try {
            cimg.transferTo(new File(localStorePath));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //cartoon_img 에 save
        switch (cut) {
            case "1" -> {
                //db 행 생성
                cartoon_img.setImg1(localStorePath);
                cartoon_img_service.imgSave(cartoon_img);
                cartoon_img = cartoon_img_service.selectByImg1(localStorePath);
            }
            case "2" -> cartoon_img.setImg2(localStorePath);
            case "3" -> cartoon_img.setImg3(localStorePath);
            case "4" -> {
                cartoon_img.setImg4(localStorePath);
                cartoon_img_service.update(cartoon_img);
            }
        }


        //cartoon_speech 에 저장
        cartoon_speech_bubble_service.saveAll(cartoon_speech_bubbles);

        /*
        if(cut.equals("4"))
        {
            Gall_board gall_board = Gall_board.builder()
                    .boardTitle(cartoonSaveVo.getTitle())
                    .writer(cartoonSaveVo.getWriter())
                    .redDate(LocalDate.now())
                    .board_content(cartoonSaveVo.getContent())
                    .build();

            board_service.saveAuto(gall_board);
            return "redirect :/cartoon/list";

        }
        */


        return null;
    }

}
