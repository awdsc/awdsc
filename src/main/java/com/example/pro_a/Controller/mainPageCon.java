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

    @GetMapping("/main")
    public String mainPage(Model model)
    {
        return "index";
    }

}
