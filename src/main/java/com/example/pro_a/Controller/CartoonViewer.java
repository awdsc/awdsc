package com.example.pro_a.Controller;

import com.example.pro_a.DBService.Board_service;
import com.example.pro_a.Entity.Gall_board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cartoon")
@RequiredArgsConstructor
public class CartoonViewer {
    private final Board_service board_service;

    @RequestMapping("/cartoonviewer/{id}")
    public String cartoonViewr(@PathVariable Long id, ModelMap mm)
    {
        Gall_board gall_board = board_service.findOneBoard(id);
        mm.addAttribute("cartoon",gall_board);
        return "/cartoonViewer";
    }
}
