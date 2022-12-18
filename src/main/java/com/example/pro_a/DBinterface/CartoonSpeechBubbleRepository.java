package com.example.pro_a.DBinterface;

import com.example.pro_a.Entity.Cartoon_speech_bubble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartoonSpeechBubbleRepository extends JpaRepository<Cartoon_speech_bubble,Long> {
    @Query(nativeQuery = true ,value = "select * from cartoon_speech_bubble where cartoon_id = :id ;")
    List<Cartoon_speech_bubble> findAllByCartoonId(Long id);
}
