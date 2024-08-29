package com.sparta.jpa_customschedule.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleRequestDto {

    private Long user_id;
    private String contents;
    // private String username;
    private String title;

}
