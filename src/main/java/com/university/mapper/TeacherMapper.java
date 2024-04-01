package com.university.mapper;

import com.university.dto.TeacherReq;
import com.university.dto.TeacherRes;
import com.university.entity.TeacherEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TeacherMapper {

  TeacherEntity teacherReqToEntity(TeacherReq teacherReq);

  TeacherRes teacherEntityToRes(TeacherEntity teacherEntity);
}
