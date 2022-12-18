package com.example.pro_a.DBService;

import com.example.pro_a.DBinterface.BoardRepository;
import com.example.pro_a.Entity.Gall_board;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class Board_service {
    private final BoardRepository boardRepository;
    //이거 아니거 같은데..
    private final Member_service member_service;

    //초기 호출
    public List<Gall_board> findAll()
    {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC,"boardReadCount"));
    }

    public List<Gall_board> search(String type,String search) throws ParseException {
        List<Gall_board> result = null;
        //제목검색 정확히 입력했을때?
        switch (type) {
            case "title":
                //제목 검색
                result = boardRepository.findByBoardTitleContaining(search);
                break;
            case "writer":
                //작성자가 만든 것들 검색
                Long memCode = member_service.findByNameToId(search);
                result = boardRepository.findByWriter(memCode);

                break;
            case "readcount":
                //단순 오름차순 내림차순 정렬
                if (search.equals("DESC")) {
                    result = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "readcount"));
                } else if (search.equals("ASC")) {
                    result = boardRepository.findAll(Sort.by(Sort.Direction.ASC, "readcount"));
                }

                break;
            case "redDate_after": {
                //날짜 이후
                SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                Date sDate = format.parse(search);
                result = boardRepository.findByRedDateAfter(sDate);

                break;
            }
            case "redDate_before": {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                Date sDate = format.parse(search);
                result = boardRepository.findByRedDateBefore(sDate);

                break;
            }
            case "recommendation_count_more":
                //추천수 이상
                result = boardRepository.findByRecommendationCountGreaterThan(Integer.parseInt(search));
                break;
            case "recommendation_count_less":
                //추천수 이하
                result = boardRepository.findByRecommendationCountLessThan(Integer.parseInt(search));
                break;
            case "view_count_more":
                //조회수 이상
                result = boardRepository.findByBoardReadCountGreaterThan(Integer.parseInt(search));
                break;
            case "view_count_less":
                //조회수 이하
                result = boardRepository.findByBoardReadCountLessThan(Integer.parseInt(search));
                break;
        }
        
        return result;
    }

    public Gall_board findOneBoard(Long id)
    {
        Optional<Gall_board> gall_board = boardRepository.findById(id);
        return gall_board.orElse(null);
    }

    public void saveAuto(Gall_board gall_board) {
        boardRepository.save(gall_board);
    }
}
