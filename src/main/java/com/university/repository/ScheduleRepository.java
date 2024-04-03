package com.university.repository;

import com.university.entity.ScheduleEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

  @Query("SELECT s FROM ScheduleEntity s WHERE s.code = :code")
  ScheduleEntity findByCode(@Param("code") String code);

  @Query("SELECT s FROM ScheduleEntity s WHERE (s.code ILIKE %:code% OR :code IS NULL)")
  List<ScheduleEntity> findbyCodeOrNull(@Param("code") String code);
}
