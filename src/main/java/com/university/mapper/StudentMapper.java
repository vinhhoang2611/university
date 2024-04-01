package com.university.mapper;


import com.university.dto.StudentReq;
import com.university.dto.StudentRes;
import com.university.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
  StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
  StudentEntity reqToEntity(StudentReq req);

  StudentRes entityToRes(StudentEntity studentEntity);

}
