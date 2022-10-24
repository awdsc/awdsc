package com.example.pro_a.Controller;

import com.example.pro_a.DBService.Board_service;
import com.example.pro_a.Entity.Gall_board;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("cartoon")
@RequiredArgsConstructor
public class CartoonListCon {
    private final Board_service board_service;

    @GetMapping("list")
    public String f_list(Model model)
    {
        return "list";
    }

    @GetMapping("/list/{type}/{search}")
    public String s_list(Model model, @PathVariable String type,@PathVariable String search) throws ParseException {


        List<Gall_board> sList = board_service.search(type,search);

        model.addAttribute(sList);
        return "lista";
    }


}
