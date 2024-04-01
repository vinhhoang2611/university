package com.university.repository;

import com.university.entity.TeacherEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {
  @Query("SELECT t FROM TeacherEntity t WHERE t.code LIKE %:code%")
  TeacherEntity findByCode(@Param("code") String code);

  @Query("SELECT t FROM TeacherEntity t WHERE (t.code LIKE %:code% OR :code IS NULL)")
  List<TeacherEntity> findByCodeOrNull(@Param("code") String code);
}
