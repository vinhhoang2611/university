package com.university.mapper;

import com.university.dto.TeacherReq;
import com.university.dto.TeacherRes;
import com.university.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
  TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);
  TeacherEntity teacherReqToEntity(TeacherReq teacherReq);

  TeacherRes teacherEntityToRes(TeacherEntity teacherEntity);
}
