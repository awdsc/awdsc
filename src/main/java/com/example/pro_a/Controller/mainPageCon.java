package com.example.pro_a.Controller;

import com.example.pro_a.DBService.Board_coment_service;
import com.example.pro_a.DBService.Board_service;
import com.example.pro_a.DBinterface.ComentRepository;
import com.example.pro_a.Entity.Gall_board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class mainPageCon {

    @Autowired
    private Board_service board_service;

    @GetMapping("/")
    public String mainPage(Model model)
    {

        List<Gall_board> list = board_service.findAll();
        System.out.println(list.get(0).getBoard_content());
        return "index";
    }

}
