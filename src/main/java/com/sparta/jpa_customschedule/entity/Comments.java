package com.sparta.jpa_customschedule.entity;

import com.sparta.jpa_customschedule.dto.CommentsRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comment") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Comments extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "schedule")
    private Schedule schedule;

    public Comments(CommentsRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.comments = requestDto.getComments();
    }

    public void update(CommentsRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.comments = requestDto.getComments();
    }

}
