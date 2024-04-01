package com.university.service;

import com.university.dto.TeacherReq;
import com.university.entity.TeacherEntity;
import java.util.List;

public interface TeacherService {

  String create(TeacherReq teacherReq);

  String update(String code, TeacherReq teacherReq);

  String delete(String code);

  List<TeacherEntity> getAll(String code);
}
