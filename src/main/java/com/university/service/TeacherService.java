package com.university.service;

import com.university.dto.TeacherReq;
import com.university.dto.TeacherRes;
import com.university.entity.TeacherEntity;
import java.util.List;
import java.util.Map;

public interface TeacherService {

  TeacherRes create(TeacherReq teacherReq);

  TeacherRes update(String code, TeacherReq teacherReq);

  Map<String, Boolean> delete(String code);

  List<TeacherEntity> getAll(String code);
}
