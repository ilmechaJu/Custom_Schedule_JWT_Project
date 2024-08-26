package com.sparta.jpa_customschedule.dto;

import com.sparta.jpa_customschedule.entity.Schedule;
import jakarta.persistence.Column;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String username;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final String title;

    public ScheduleResponseDto(Schedule savedSchedule) {
         this.id = savedSchedule.getId();
         this.username = savedSchedule.getUsername();
         this.contents = savedSchedule.getContents();
         this.createdAt = savedSchedule.getCreatedAt();
         this.modifiedAt = savedSchedule.getModifiedAt();
         this.title = savedSchedule.getTitle();

    }
}
