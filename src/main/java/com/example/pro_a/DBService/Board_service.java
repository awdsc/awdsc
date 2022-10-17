package com.example.pro_a.DBService;

import com.example.pro_a.DBinterface.BoardRepository;
import com.example.pro_a.Entity.Gall_board;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Board_service {

    @Autowired
    private  BoardRepository boardRepository;

    public List<Gall_board> findAll()
    {
        return boardRepository.findAll();
    }


}
