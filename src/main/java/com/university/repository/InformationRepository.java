package com.university.repository;

import com.university.entity.InformationEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InformationRepository extends JpaRepository<InformationEntity, Long> {

  @Query("SELECT i FROM InformationEntity i WHERE i.code = :code")
  InformationEntity getByCode(@Param("code") String code);

  @Query("SELECT i FROM InformationEntity i WHERE (i.username LIKE %:username% OR :username is null)")
  List<InformationEntity> getByCodeOrNull(@Param("username") String username);
  @Query("SELECT i.username FROM InformationEntity  i WHERE i.username = :username")
  String getByName(@Param("username") String username);
}
