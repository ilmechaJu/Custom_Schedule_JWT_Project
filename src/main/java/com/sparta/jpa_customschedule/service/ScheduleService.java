package com.sparta.jpa_customschedule.service;

import com.sparta.jpa_customschedule.dto.ScheduleRequestDto;
import com.sparta.jpa_customschedule.dto.ScheduleResponseDto;
import com.sparta.jpa_customschedule.entity.Comments;
import com.sparta.jpa_customschedule.entity.Register;
import com.sparta.jpa_customschedule.entity.Schedule;
import com.sparta.jpa_customschedule.entity.User;
import com.sparta.jpa_customschedule.repository.RegisterRepository;
import com.sparta.jpa_customschedule.repository.ScheduleRepository;
import com.sparta.jpa_customschedule.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.data.domain.Pageable;

@Transactional
@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final RegisterRepository registerRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository, RegisterRepository registerRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
        this.registerRepository = registerRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        // RequestDto -> entity
        Schedule schedule = new Schedule(requestDto);
        User user = userRepository.findById(requestDto.getUser_id()).orElseThrow(()-> new IllegalArgumentException("id 구하는거 어렵죠?")) ; //requestDto에 id를 불러오자.

        // DB저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        // 레지스터 객체 -인스턴스화 -> 생성자 초기화
        Register register = new Register(savedSchedule, user);
        registerRepository.save(register);
        // Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(savedSchedule);

        return scheduleResponseDto;
        //mapping 될 user id,name,email 입력. -> 스케줄 사용자 정보는 별도 API만들기( )
        //@Jsoninclude Dto 위에 사용 (  ) -> but empty가 있는가?( )
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

    @Transactional
    public ScheduleResponseDto getSchedule(Long id) {
        Schedule schedule = find(id);
        List<Register> list = registerRepository.findAllBySchedule_Id(id);
        ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule, list);
        return responseDto;
    }

    public Schedule find(Long id) {
        return scheduleRepository.findById(id).orElseThrow();
    }
}
