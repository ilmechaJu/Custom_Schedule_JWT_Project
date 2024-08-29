package com.sparta.jpa_customschedule.entity;
import com.sparta.jpa_customschedule.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String email;
    private String password;



    public User(UserRequestDto requestDto, String userId, String email, String password) {
        this.userId = requestDto.getUserId();
        this.email = requestDto.getEmail();
        this.password = password;
    }

    public void update(UserRequestDto requestDto) {
        this.userId = requestDto.getUserId();
        this.email = requestDto.getEmail();
    }

    @OneToMany(mappedBy = "user") //중간 테이블 (Register)
    private List<Register> registerList = new ArrayList<>();
}
