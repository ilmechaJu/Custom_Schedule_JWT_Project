package com.sparta.jpa_customschedule.controller;

import com.sparta.jpa_customschedule.dto.ScheduleRequestDto;
import com.sparta.jpa_customschedule.dto.ScheduleResponseDto;
import com.sparta.jpa_customschedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    @Autowired
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedules(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.createSchedule(scheduleRequestDto);
    }

    //전체 조회
    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getAllSchedules(@RequestParam Integer page, @RequestParam(defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return scheduleService.getSchedules(pageable);
    }

    //일정 단건조회
    @GetMapping("/schedules/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable Long id) {
        return scheduleService.getSchedule(id);
    }

    @PutMapping("/schedules/{id}")
    public Long updateSchedules(@PathVariable Long id, @RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.updateSchedule(id, scheduleRequestDto);
    }

    @DeleteMapping("/schedules/{id}") //already complete
    public Long deleteSchedules(@PathVariable Long id) {
        return scheduleService.deleteSchedule(id);
    }
}


