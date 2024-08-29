package com.sparta.jpa_customschedule.dto;

import com.sparta.jpa_customschedule.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private final String userId;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    //리스트 만들기


    public UserResponseDto(User savedUser) {
        this.userId = savedUser.getUserId();
        this.email = savedUser.getEmail();
        this.createdAt = savedUser.getCreatedAt();
        this.modifiedAt = savedUser.getModifiedAt();
    }
}
