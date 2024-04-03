package com.university.mapper;

import com.university.dto.ScheduleReq;
import com.university.dto.ScheduleRes;
import com.university.entity.ScheduleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ScheduleMapper {

  ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

  ScheduleEntity reqToEntity(ScheduleReq scheduleReq);

  ScheduleRes entiyToRes(ScheduleEntity scheduleEntity);

  @Mapping(source = "code", target = "code")
  ScheduleEntity updSchedule(ScheduleReq scheduleReq,@MappingTarget ScheduleEntity scheduleEntity);
}
