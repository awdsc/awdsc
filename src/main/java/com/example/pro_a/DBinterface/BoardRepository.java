package com.example.pro_a.DBinterface;

import com.example.pro_a.Entity.Gall_board;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface BoardRepository extends JpaRepository<Gall_board, Long> {
    List<Gall_board> findByBoardTitleContaining(String search);
    List<Gall_board> findByWriter(Long writer);

    //추천수 이상 이하
    List<Gall_board> findByRecommendationCountGreaterThan(int recommendationCount);
    List<Gall_board> findByRecommendationCountLessThan(int recommendationCount);
    
    //조회수 이상 이하
    List<Gall_board> findByBoardReadCountGreaterThan(int boardReadCount);
    List<Gall_board> findByBoardReadCountLessThan(int boardReadCount);
    
    //날짜 이전 이후
    List<Gall_board> findByRedDateBefore(Date date);
    List<Gall_board> findByRedDateAfter(Date date);

}
