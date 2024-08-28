package com.sparta.jpa_customschedule.repository;

import com.sparta.jpa_customschedule.entity.Registor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface RegistorRepository extends JpaRepository<Registor, Long> {

}
