package com.sparta.jpa_customschedule.entity;

import com.sparta.jpa_customschedule.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "schedule") // 매핑할 테이블의 이름을 지정
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Schedule extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    @Column(name = "username", nullable = false)
    private Long userId;


    public Schedule(ScheduleRequestDto requestDto) {
        this.userId = requestDto.getUser_id();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }


    public void update(ScheduleRequestDto requestDto) {
        this.userId = requestDto.getUser_id();
        this.contents = requestDto.getContents();
    }

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.REMOVE) //Cascade추후에 필요없으면 빼자
    private List<Comments> commentsList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

