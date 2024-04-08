package com.university.service;

import com.university.dto.TeacherReq;
import com.university.dto.TeacherRes;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface TeacherService {

  ResponseEntity<String> create(TeacherReq teacherReq);

  ResponseEntity<String> update(String code, TeacherReq teacherReq);

  ResponseEntity<String> delete(String code);

  List<TeacherRes> getAll(String code);
}
