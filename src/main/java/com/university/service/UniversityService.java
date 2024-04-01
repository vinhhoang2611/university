package com.university.service;

import com.university.dto.UniversityReq;
import com.university.dto.UniversityRes;
import com.university.entity.UniversityEntity;
import java.util.List;
import java.util.Map;

public interface UniversityService {

  UniversityRes create(UniversityReq universityReq);

  UniversityRes update(String code, UniversityReq universityReq);

  Map<String, Boolean> delete(String code);

  List<UniversityEntity> getAll(String code);
}
