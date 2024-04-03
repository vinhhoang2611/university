package com.university.service;

import com.university.dto.SubjectReq;
import com.university.dto.SubjectRes;
import java.util.List;

public interface SubjectService {
  String create(SubjectReq subjectReq);
  String update(String code,SubjectReq subjectReq);
  String delete(String code);
  List<SubjectRes> getAll(String code);
}
