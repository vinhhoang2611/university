package com.university.mapper;

import com.university.dto.InformationReq;
import com.university.dto.InformationRes;
import com.university.entity.InformationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InformationMapper {
    InformationMapper INSTANCE = Mappers.getMapper(InformationMapper.class);
    @Mapping(source = "code",target = "code")
    InformationEntity mapInformation(InformationReq informationReq, @MappingTarget InformationEntity informationEntity);
    InformationEntity inforReqToEntity(InformationReq informationReq);

    InformationRes inforEntityToRes(InformationEntity informationEntity);
}
