package com.sparta.jpa_customschedule.dto;
import com.sparta.jpa_customschedule.dto.UserResponseDto;
import lombok.Getter;


@Getter
public class UserSaveResponseDto {
    private final String bearerToken;


    public UserSaveResponseDto(String BearerToken) {
        this.bearerToken = BearerToken;
    }
}
