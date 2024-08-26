package com.sparta.jpa_customschedule.controller;

import com.sparta.jpa_customschedule.dto.CommentsRequestDto;
import com.sparta.jpa_customschedule.dto.CommentsResponseDto;
import com.sparta.jpa_customschedule.service.CommentsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentsController {

    private final CommentsService commentsService;

    //일정 저장
    //등록할 일정의 id를 @PathVariable로, 댓글의 내용을 body로 받아오기
    @PostMapping("/schedule/{id}")
    public CommentsResponseDto createComments(@PathVariable Long id, @RequestBody CommentsRequestDto requestDto) {
        return commentsService.createComments(id, requestDto);
    }

    //단건 조회
    @GetMapping("/{id}")
    public CommentsResponseDto getComments(@PathVariable Long id) {
        return commentsService.getComment(id);
    }

    //전체 조회
    @GetMapping
    public List<CommentsResponseDto> getAllComments() {
        return commentsService.getComments();
    }

    //수정
    @PutMapping("/{id}")
    public CommentsResponseDto updateComments(@PathVariable Long id, @RequestBody CommentsRequestDto requestDto) {
        return commentsService.updateComments(id, requestDto);
    }
    //삭제
    @DeleteMapping("/{id}")
    public Long deleteComments(@PathVariable Long id) {
        return commentsService.deleteComments(id);
    }

}
