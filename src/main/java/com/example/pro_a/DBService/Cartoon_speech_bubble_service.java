package com.example.pro_a.DBService;

import com.example.pro_a.DBinterface.CartoonSpeechBubbleRepository;
import com.example.pro_a.Entity.Cartoon_speech_bubble;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class Cartoon_speech_bubble_service {
    private final CartoonSpeechBubbleRepository cartoonSpeechBubbleRepository;

    public List<Cartoon_speech_bubble> selectById(String id)
    {
        return cartoonSpeechBubbleRepository.findAllByCartoonId(id);
    }
    public void save(List<Cartoon_speech_bubble> cartoon_speech_bubbles)
    {
        cartoonSpeechBubbleRepository.saveAll(cartoon_speech_bubbles);
    }

    public void saveAll(List<Cartoon_speech_bubble> cartoon_speech_bubbles) {
        cartoonSpeechBubbleRepository.saveAll(cartoon_speech_bubbles);
    }
}
