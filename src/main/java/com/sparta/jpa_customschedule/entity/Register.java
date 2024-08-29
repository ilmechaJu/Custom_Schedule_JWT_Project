package com.sparta.jpa_customschedule.entity;

import com.sparta.jpa_customschedule.dto.ScheduleRequestDto;
import com.sparta.jpa_customschedule.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "register")
@NoArgsConstructor
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Register(Schedule schedule, User user) {
        this.schedule = schedule;
        this.user = user;
    }


}

//id (외래키) 찾아서, 객체를 불러와서 create Register 에 객체를 넣어라.