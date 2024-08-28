package com.sparta.jpa_customschedule.service;

import com.sparta.jpa_customschedule.dto.UserRequestDto;
import com.sparta.jpa_customschedule.dto.UserResponseDto;
import com.sparta.jpa_customschedule.entity.User;
import com.sparta.jpa_customschedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto requestDto) {
        // RequestDto -> entity
        User user = new User(requestDto);
        // DB저장
        User savedUser = userRepository.save(user);
        // Entity -> ResponseDto
        UserResponseDto responseDto = new UserResponseDto(savedUser);
        return responseDto;
    }

    public List<UserResponseDto> getAllUser() {
        return userRepository.findAll().stream().map(UserResponseDto::new).toList();
    } // 메서드 이름으로 SQL 생성하는 Query Methods 기능.


    public Long updateUser(Long id, UserRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        User user = findUser(id);
        // schedule 내용 수정
        user.update(requestDto);

        return id;
    }

    private User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }

    public Long deleteUser(Long id) {
        //해당 메모가 DB에 존재하는지 확인
        User user = findUser(id);
        //schedule 삭제
        userRepository.delete(user);
        return id;
    }

    public UserResponseDto getUser(Long id) {
        User user = find(id);
        UserResponseDto responseDto = new UserResponseDto(user);
        return responseDto;
    }

    public User find(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
