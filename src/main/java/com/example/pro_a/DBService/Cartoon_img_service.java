package com.example.pro_a.DBService;


import com.example.pro_a.DBinterface.CartoonImgRepository;
import com.example.pro_a.Entity.Cartoon_img;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Cartoon_img_service {
    private final CartoonImgRepository cartoonImgRepository;



    public Cartoon_img selectById(Long id)
    {
        Optional<Cartoon_img> cartoon_img = cartoonImgRepository.findById(id);
        return cartoon_img.orElse(null);
    }

    public void imgSave(Cartoon_img cartoon_img)
    {
        cartoonImgRepository.save(cartoon_img);
    }


    public Cartoon_img selectByImg1(String localStorePath) {
        return cartoonImgRepository.findByImg1(localStorePath);
    }

    public void update(Cartoon_img cartoon_img) {
        cartoonImgRepository.update(cartoon_img.getCartoon_id(),cartoon_img.getImg1(),cartoon_img.getImg2(),cartoon_img.getImg3(),cartoon_img.getImg4());
    }

    public Cartoon_img selectLast() {
        return cartoonImgRepository.lastIndex();
    }

    public Cartoon_img getLastNum() {
        return cartoonImgRepository.lastIndex();
    }


    public String findFirstUrl(String filename) {
        return cartoonImgRepository.findByIdT(Long.valueOf(filename));
    }
}
