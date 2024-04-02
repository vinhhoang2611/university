package com.university.mapper;

import com.university.dto.InformationReq;
import com.university.dto.InformationRes;
import com.university.entity.InformationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InformationMapper {
    InformationMapper INSTANCE = Mappers.getMapper(InformationMapper.class);

    InformationEntity inforReqToEntity(InformationReq informationReq);

    InformationRes inforEntityToRes(InformationEntity informationEntity);
}
