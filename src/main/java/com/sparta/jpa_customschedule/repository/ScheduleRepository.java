package com.sparta.jpa_customschedule.repository;

import com.sparta.jpa_customschedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    //어떤 함수를 쓸건지 나열되는 형식 ex)save, find, update, delete 나열
}
