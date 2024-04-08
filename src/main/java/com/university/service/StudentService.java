package com.university.service;

import com.university.dto.StudentReq;
import com.university.dto.StudentRes;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface StudentService {

  ResponseEntity<String> create(StudentReq studentReq);

  ResponseEntity<String> update(String code, StudentReq studentReq);

  ResponseEntity<String> delete(String code);

  List<StudentRes> getAll(String code);
}
