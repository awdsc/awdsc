package com.example.pro_a.DBinterface;

import com.example.pro_a.Entity.Cartoon_speech_bubble;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartoonSpeechBubbleRepository extends JpaRepository<Cartoon_speech_bubble,Long> {
    List<Cartoon_speech_bubble> findAllByCartoonId(String id);
}
