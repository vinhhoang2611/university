package com.university.repository;

import com.university.entity.UniversityEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UniversityRepository extends JpaRepository<UniversityEntity, Long> {

  @Query("SELECT u FROM UniversityEntity u WHERE u.code = :code")
  UniversityEntity findByCode(@Param("code") String code);

  @Query("SELECT u FROM UniversityEntity u WHERE (u.code LIKE %:code% OR :code IS NULL)")
  List<UniversityEntity> findByCodeOrNull(@Param("code") String code);
}
