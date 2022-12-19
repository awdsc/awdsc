package com.example.pro_a.Controller;

import com.example.pro_a.DBService.Board_service;
import com.example.pro_a.DBService.Cartoon_img_service;
import com.example.pro_a.Entity.Cartoon_img;
import com.example.pro_a.Entity.Gall_board;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cartoon")
@RequiredArgsConstructor
public class CartoonListCon {
    private final Board_service board_service;
    private final Cartoon_img_service cartoon_img_service;
    @GetMapping("/list")
    public String f_list(Model model , @PageableDefault(size = 20) Pageable pageable , ModelMap mm)
    {
        List<Gall_board> gall_boards = board_service.findAll();
        List<String> imgUrl = new ArrayList<>();
        for (Gall_board u: gall_boards) {
            imgUrl.add(cartoon_img_service.findFirstUrl(u.getFilename()));
        }

        mm.addAttribute("board",gall_boards);
        mm.addAttribute("imgUrls",imgUrl);
        return "/list";
    }

    @GetMapping("/search")
    public String s_list(Model model,@RequestParam("search") String search) throws ParseException {
        String type = "title";
        System.out.println("=====================================================================");
        System.out.println(search);
        List<Gall_board> sList = board_service.search(type,search);
        model.addAttribute("board", sList);
        return "/list";
    }


}
