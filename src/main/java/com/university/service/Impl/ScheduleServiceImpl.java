package com.university.service.Impl;

import com.university.dto.ScheduleReq;
import com.university.dto.ScheduleRes;
import com.university.entity.ScheduleEntity;
import com.university.mapper.ScheduleMapper;
import com.university.repository.ScheduleRepository;
import com.university.service.ScheduleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
  @Autowired
  ScheduleRepository scheduleRepository;
  @Override
  public String create(ScheduleReq scheduleReq) {
    ScheduleEntity scheduleEntity = ScheduleMapper.INSTANCE.reqToEntity(scheduleReq);

    scheduleRepository.save(scheduleEntity);
    return "Create!!";
  }

  @Override
  public String update(String code, ScheduleReq scheduleReq) {
    ScheduleEntity scheduleEntity;
    return null;
  }

  @Override
  public String delete(String code) {
    return null;
  }

  @Override
  public List<ScheduleRes> getAll(String code) {
    return null;
  }
}
