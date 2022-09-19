package com.example.pro_a.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainPageCon {

    @GetMapping("/")
    public String mainPage(Model model)
    {

        return "index";
    }

}
