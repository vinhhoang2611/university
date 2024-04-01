package com.university.service;

import com.university.dto.UniversityReq;
import com.university.dto.UniversityRes;
import java.util.List;

public interface UniversityService {

  String create(UniversityReq universityReq);

  String update(String code, UniversityReq universityReq);

  String delete(String code);

  List<UniversityRes> getAll(String code);
}
