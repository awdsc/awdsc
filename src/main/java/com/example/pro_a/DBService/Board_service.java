package com.example.pro_a.DBService;

import com.example.pro_a.DBinterface.BoardInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Board_service {
    @Autowired
    BoardInterface boardRepo;

    public void aa()
    {
        System.out.println(boardRepo.findAll().toString());
    }
}
