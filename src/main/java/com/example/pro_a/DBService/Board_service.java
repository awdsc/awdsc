package com.example.pro_a.DBService;

import com.example.pro_a.DBinterface.BoardRepository;
import com.example.pro_a.Entity.Gall_board;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class Board_service {
    private final BoardRepository boardRepository;
    //이거 아니거 같은데..
    private final Member_service member_service;

    public List<Gall_board> findAll()
    {
        return boardRepository.findAll();
    }

    public List<Gall_board> search(String type,String search) throws ParseException {
        List<Gall_board> result = null;
        //제목검색 정확히 입력했을때?
        if(type.equals("title")) {result = boardRepository.findByBoardTitle(search);}
        else if (type.equals("writer")) {
            //작성자가 만든 것들 검색
            Long memCode = member_service.findByNameToId(search);
            result = boardRepository.findByWriter(memCode);

        }else if(type.equals("readcount")){
            //단순 오름차순 내림차순 정렬
            if(search.equals("DESC")){result = boardRepository.findAll(Sort.by(Sort.Direction.DESC,"readcount"));}
            else if (search.equals("ASC")) {result = boardRepository.findAll(Sort.by(Sort.Direction.ASC,"readcount"));}

        } else if (type.equals("redDate_after")) {
            //날짜 이후
            SimpleDateFormat  format = new SimpleDateFormat("yyyy-mm-dd");
            Date sDate = format.parse(search);
            result = boardRepository.findByRedDateAfter(sDate);
        } else if (type.equals("redDate_before")) {
            SimpleDateFormat  format = new SimpleDateFormat("yyyy-mm-dd");
            Date sDate = format.parse(search);
            result = boardRepository.findByRedDateBefore(sDate);
        }else if(type.equals("recommendation_count_more")) {
            //추천수 이상
            result = boardRepository.findByRecommendationCountGreaterThan(Integer.parseInt(search));
        }else if(type.equals("recommendation_count_less")) {
            //추천수 이하
            result = boardRepository.findByRecommendationCountLessThan(Integer.parseInt(search));
        }
        return result;
    }

}
