package com.university.service;

import com.university.dto.StudentReq;
import com.university.dto.StudentRes;
import java.util.List;

public interface StudentService {

  String create(StudentReq studentReq);

  String update(String code, StudentReq studentReq);

  String delete(String code);

  List<StudentRes> getAll(String code);
}
