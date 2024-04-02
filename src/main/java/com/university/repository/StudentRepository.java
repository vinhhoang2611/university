package com.university.repository;

import com.university.entity.StudentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

  @Query("SELECT s FROM StudentEntity s WHERE s.code = :code")
  StudentEntity findByCode(@Param("code") String code);

  @Query("SELECT s.id, s.code, s.name, s.email, s.phone, s.universityCode, s.age, s.semester,\n"
      + "       (case s.sex when '0' then 'Male' when '1' then 'Female' end\n"
      + "        ) AS sex, s.birthdate, s.majorsCode FROM StudentEntity s WHERE (s.code ILIKE %:code% OR :code IS NULL)")
  List<StudentEntity> findByCodeOrNull(@Param("code") String code);


}
