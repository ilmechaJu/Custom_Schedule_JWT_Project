package com.sparta.jpa_customschedule.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserRequestDto {

    private String userId;
    private String email;
    private String password;

}
