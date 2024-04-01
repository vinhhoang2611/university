package com.university.mapper;

import com.university.dto.UniversityReq;
import com.university.dto.UniversityRes;
import com.university.entity.UniversityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UniversityMapper {

  UniversityMapper INSTANCE = Mappers.getMapper(UniversityMapper.class);

  UniversityEntity universityReqToEntity(UniversityReq universityReq);

  UniversityRes universityEntityToRes(UniversityEntity university);
}
