package com.sparta.jpa_customschedule.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sparta.jpa_customschedule.entity.Register;
import com.sparta.jpa_customschedule.entity.Schedule;
import com.sparta.jpa_customschedule.entity.User;
import jakarta.persistence.Column;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final Long username;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final String title;
    private final int commentscount;
    private List<UserDto> users;


    public ScheduleResponseDto(Schedule savedSchedule) {
         this.id = savedSchedule.getId();
         this.username = savedSchedule.getUserId();
         this.contents = savedSchedule.getContents();
         this.createdAt = savedSchedule.getCreatedAt();
         this.modifiedAt = savedSchedule.getModifiedAt();
         this.title = savedSchedule.getTitle();
         this.commentscount = savedSchedule.getCommentsList().size();

    }


    public ScheduleResponseDto(Schedule schedule, List<Register> list) {
        this(schedule);
        this.users = new ArrayList<>();

        for(Register register : list) {
            User user = register.getUser();
            UserDto userDto = new UserDto(user.getId(), user.getUserId(), user.getEmail());
            this.users.add(userDto);
        }
    }


}
