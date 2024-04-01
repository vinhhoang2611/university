package com.university.service;

import com.university.dto.StudentReq;
import com.university.dto.StudentRes;
import com.university.entity.StudentEntity;
import java.util.List;
import java.util.Map;

public interface StudentService {

  StudentRes create(StudentReq studentReq);

  StudentRes update(String code, StudentReq studentReq);

  Map<String, Boolean> delete(String code);

  List<StudentEntity> getAll(String code);
}
