package com.example.pro_a.Controller;

import com.example.pro_a.DBService.Board_service;
import com.example.pro_a.DBinterface.BoardInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainPageCon {

    @GetMapping("/")
    public String mainPage(Model model)
    {
        Board_service bo = new Board_service();

        bo.aa();




        return "index";
    }

}
