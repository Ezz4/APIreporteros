package com.dailybugle.daily_bugle1.repository;

import com.dailybugle.daily_bugle1.model.Reportero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ReporteroRepository extends JpaRepository <Reportero, Long>{


    //Select * From Reportero where email = ...
    @Query("SELECT s FROM Reportero s WHERE s.email =?1")
    Optional<Reportero> findReporteroByEmail(String email);


}
