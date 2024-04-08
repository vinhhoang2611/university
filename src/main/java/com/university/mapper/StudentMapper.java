package com.university.mapper;


import com.university.dto.StudentReq;
import com.university.dto.StudentRes;
import com.university.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface StudentMapper {
  StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
  StudentEntity reqToEntity(StudentReq req);
  @Mapping(source = "code",target = "code")
  StudentEntity updStudent(StudentReq studentReq, @MappingTarget StudentEntity studentEntity);
  StudentRes entityToRes(StudentEntity studentEntity);

}
