package com.sparta.jpa_customschedule.service;

import com.sparta.jpa_customschedule.dto.CommentsRequestDto;
import com.sparta.jpa_customschedule.dto.CommentsResponseDto;
import com.sparta.jpa_customschedule.entity.Comments;
import com.sparta.jpa_customschedule.entity.Schedule;
import com.sparta.jpa_customschedule.repository.CommentsRepository;
import com.sparta.jpa_customschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final ScheduleRepository scheduleRepository;
    public CommentsResponseDto createComments(Long id, CommentsRequestDto requestDto) {
        //RequestDto -> Entity
        Comments comments = new Comments(requestDto);

        //등록할 Id값에 해당하는 Schedule Entity 불러오기
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();

        //연관관계 설정
        comments.setSchedule(schedule);

        //DB에 저장
        Comments saveComments = commentsRepository.save(comments);

        //ResponseDto에 반환
        CommentsResponseDto responseDto = new CommentsResponseDto(saveComments);
        return responseDto;
    }

    // 전체 조회
    @Transactional
    public List<CommentsResponseDto> getComments() {
        return commentsRepository.findAll().stream().map(CommentsResponseDto::new).toList();
    }
    // 단건 조회
    public CommentsResponseDto getComment(Long id) {
        Comments comments = find(id);
        CommentsResponseDto responseDto = new CommentsResponseDto(comments);
        return responseDto;
    }

    @Transactional
    public CommentsResponseDto updateComments(Long id, CommentsRequestDto requestDto) {
        Comments comments = find(id);
        comments.update(requestDto);
        CommentsResponseDto responseDto = new CommentsResponseDto(comments);
        return responseDto;
    }
    public Long deleteComments(Long id) {
        Comments comments = find(id);
        commentsRepository.delete(comments);
        return id;
    }

    private Comments find(Long id) {
        return commentsRepository.findById(id).orElseThrow();
    }

}
