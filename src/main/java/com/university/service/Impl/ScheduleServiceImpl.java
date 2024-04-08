package com.university.service.Impl;

import com.university.dto.ScheduleReq;
import com.university.dto.ScheduleRes;
import com.university.entity.ScheduleEntity;
import com.university.mapper.ScheduleMapper;
import com.university.repository.ScheduleRepository;
import com.university.service.ScheduleService;
import java.util.ArrayList;
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
    ScheduleEntity scheduleEntity = scheduleRepository.findByCode(code);

    ScheduleEntity scheduleEntitySave = ScheduleMapper.INSTANCE.updSchedule(scheduleReq,scheduleEntity);
    scheduleRepository.save(scheduleEntitySave);
    return "Update Successful!!";
  }

  @Override
  public String delete(String code) {
    ScheduleEntity scheduleEntity = scheduleRepository.findByCode(code);

    scheduleRepository.delete(scheduleEntity);
    return "Deleted!!";
  }

  @Override
  public List<ScheduleRes> getAll(String code) {
    List<ScheduleEntity> scheduleEntity = scheduleRepository.findbyCodeOrNull(code);
    List<ScheduleRes> scheduleResList = new ArrayList<>();
    for (ScheduleEntity schedule : scheduleEntity){
      ScheduleRes scheduleRes;
      scheduleRes = ScheduleMapper.INSTANCE.entityToRes(schedule);
      scheduleResList.add(scheduleRes);
    }
    return scheduleResList;
  }
}
