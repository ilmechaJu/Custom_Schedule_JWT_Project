package com.sparta.jpa_customschedule.controller;

import com.sparta.jpa_customschedule.dto.UserRequestDto;
import com.sparta.jpa_customschedule.dto.UserResponseDto;
import com.sparta.jpa_customschedule.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    //단건 조회
    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    //전체 조회
    @GetMapping
    public List<UserResponseDto> getAllUser() {
        return userService.getAllUser();
    }

    //수정
    @PutMapping("/{id}") //반환타입 메서드
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        return userService.getUser(userService.updateUser(id, requestDto));
    }

    //삭제
    @DeleteMapping("/{id}")
    public Long deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
