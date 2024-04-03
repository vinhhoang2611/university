package com.university.service;

import com.university.dto.ScheduleReq;
import com.university.dto.ScheduleRes;
import java.util.List;

public interface ScheduleService {
  String create(ScheduleReq scheduleReq);
  String update(String code, ScheduleReq scheduleReq);
  String delete(String code);
  List<ScheduleRes> getAll(String code);
}
