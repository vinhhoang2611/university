package com.university.mapper;

import com.university.dto.TeacherReq;
import com.university.dto.TeacherRes;
import com.university.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TeacherMapper {

  TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

  TeacherEntity teacherReqToEntity(TeacherReq teacherReq);

  TeacherRes teacherEntityToRes(TeacherEntity teacherEntity);

  @Mapping(source = "code", target = "code")
  TeacherEntity updTeacher(TeacherReq teacherReq, @MappingTarget TeacherEntity teacherEntity);
}
