package com.university.service;

import com.university.dto.UniversityReq;
import com.university.dto.UniversityRes;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface UniversityService {

  ResponseEntity<String> create(UniversityReq universityReq);

  ResponseEntity<String> update(String code, UniversityReq universityReq);

  ResponseEntity<String> delete(String code);

  List<UniversityRes> getAll(String code);
}
