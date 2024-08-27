package com.sparta.jpa_customschedule.service;

import com.sparta.jpa_customschedule.dto.CommentsResponseDto;
import com.sparta.jpa_customschedule.dto.ScheduleRequestDto;
import com.sparta.jpa_customschedule.dto.ScheduleResponseDto;
import com.sparta.jpa_customschedule.entity.Comments;
import com.sparta.jpa_customschedule.entity.Schedule;
import com.sparta.jpa_customschedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.data.domain.Pageable;

@Transactional
@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        // RequestDto -> entity
        Schedule schedule = new Schedule(requestDto);
        // DB저장
        Schedule savedSchedule = scheduleRepository.save(schedule);
        // Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(savedSchedule);
        return scheduleResponseDto;
    }

    public List<ScheduleResponseDto> getSchedules(Pageable pageable) {
        return scheduleRepository.findAllByOrderByModifiedAtDesc(pageable).stream().map(ScheduleResponseDto::new).toList();
    } // 메서드 이름으로 SQL 생성하는 Query Methods 기능.


    public Long updateSchedule(Long id, ScheduleRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Schedule schedule = findSchedule(id);
        // schedule 내용 수정
        schedule.update(requestDto);

        return id;
    }

    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }

    public Long deleteSchedule(Long id) {
        //해당 메모가 DB에 존재하는지 확인
        Schedule schedule = findSchedule(id);
        //schedule 삭제
        scheduleRepository.delete(schedule);
        return id;
    }

    public ScheduleResponseDto getSchedule(Long id) {
        Schedule schedule = find(id);
        ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
        return responseDto;
    }

    public Schedule find(Long id) {
        return scheduleRepository.findById(id).orElseThrow();
    }
}
