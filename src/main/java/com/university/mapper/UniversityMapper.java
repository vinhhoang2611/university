package com.university.mapper;

import com.university.dto.UniversityReq;
import com.university.dto.UniversityRes;
import com.university.entity.UniversityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UniversityMapper {

  UniversityMapper INSTANCE = Mappers.getMapper(UniversityMapper.class);

  UniversityEntity universityReqToEntity(UniversityReq universityReq);

  UniversityRes universityEntityToRes(UniversityEntity university);

  @Mapping(source = "code", target = "code")
  UniversityEntity updUniver(UniversityReq universityReq,
      @MappingTarget UniversityEntity universityEntity);
}
