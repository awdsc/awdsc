package com.example.pro_a.DBService;


import com.example.pro_a.DBinterface.ComentRepository;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Board_coment_service {


    private final ComentRepository comentRepository;

}
