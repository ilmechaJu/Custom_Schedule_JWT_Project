package com.sparta.jpa_customschedule.repository;

import com.sparta.jpa_customschedule.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    List<Register> findAllBySchedule_Id(Long schedule_id);
}
