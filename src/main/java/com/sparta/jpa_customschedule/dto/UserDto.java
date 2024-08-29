package com.sparta.jpa_customschedule.dto;

import lombok.Getter;

@Getter
public class UserDto {
    private Long id;
    private String username;
    private String email;



    public UserDto(Long id, String userId, String email) {
        this.id = id;
        this.username = userId;
        this.email = email;
    }

}
