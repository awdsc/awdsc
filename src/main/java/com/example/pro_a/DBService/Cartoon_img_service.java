package com.example.pro_a.DBService;


import com.example.pro_a.DBinterface.CartoonImgRepository;
import com.example.pro_a.Entity.Cartoon_img;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Cartoon_img_service {
    private final CartoonImgRepository cartoonImgRepository;

    public Cartoon_img selectById(Long id)
    {
        Optional<Cartoon_img> cartoon_img = cartoonImgRepository.findById(id);
        return cartoon_img.get();
    }

    public void imgSave(Object obj)
    {
        Cartoon_img cartoon_img = Cartoon_img.builder()

                .build();

        //cartoonImgRepository.save()
    }


}
