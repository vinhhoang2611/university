package com.university.repository;

import com.university.entity.SubjectEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

  @Query("SELECT sb FROM SubjectEntity sb WHERE sb.code = :code")
  SubjectEntity findByCode(@Param("code") String code);

  @Query("SELECT sb FROM SubjectEntity sb WHERE (sb.code ILIKE %:code% OR :code is null)")
  List<SubjectEntity> findByCodeOrNul(@Param("code") String code);
}
