package com.university.mapper;

import com.university.dto.UniversityReq;
import com.university.dto.UniversityRes;
import com.university.entity.UniversityEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UniversityMapper {

  UniversityEntity universityReqToEntity(UniversityReq universityReq);

  UniversityRes universityEntityToRes(UniversityEntity university);
}
