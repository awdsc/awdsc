package com.example.pro_a.DBService;


import com.example.pro_a.DBinterface.ComentRepository;

import com.example.pro_a.Entity.Gall_coment;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Board_coment_service {


    private final ComentRepository comentRepository;

    public List<Gall_coment> comentList(Long boardNumber)
    {
        List<Gall_coment> coments = null;
        coments = comentRepository.findAllById(Collections.singleton(boardNumber));
        return coments;
    }


}
