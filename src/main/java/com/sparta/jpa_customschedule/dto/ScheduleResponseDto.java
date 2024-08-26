package com.sparta.jpa_customschedule.dto;

import com.sparta.jpa_customschedule.entity.Schedule;
import jakarta.persistence.Column;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String username;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleResponseDto(Schedule savedSchedule) {
         this.id = savedSchedule.getId();
         this.username = savedSchedule.getUsername();
         this.title = savedSchedule.getTitle();
         this.contents = savedSchedule.getContents();
         this.createdAt = savedSchedule.getCreatedAt();
         this.modifiedAt = savedSchedule.getModifiedAt();

    }
}
