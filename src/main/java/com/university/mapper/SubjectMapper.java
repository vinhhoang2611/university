package com.university.mapper;

import com.university.dto.SubjectReq;
import com.university.dto.SubjectRes;
import com.university.entity.SubjectEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SubjectMapper {

  SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

  SubjectEntity reqToEntity(SubjectReq subjectReq);

  SubjectRes entityToRes(SubjectEntity subjectEntity);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  SubjectEntity updSubject(SubjectReq subjectReq, @MappingTarget SubjectEntity subjectEntity);
}
