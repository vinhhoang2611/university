package com.university.service.Impl;

import com.university.dto.SubjectReq;
import com.university.dto.SubjectRes;
import com.university.entity.SubjectEntity;
import com.university.mapper.SubjectMapper;
import com.university.repository.SubjectRepository;
import com.university.service.SubjectService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
  @Autowired
  SubjectRepository subjectRepository;
  @Override
  public String create(SubjectReq subjectReq) {
    SubjectEntity subjectEntity = SubjectMapper.INSTANCE.reqToEntity(subjectReq);

    subjectRepository.save(subjectEntity);
    return "Created!!";
  }

  @Override
  public String update(String code, SubjectReq subjectReq) {
    SubjectEntity subjectEntity = subjectRepository.findByCode(code);

    SubjectEntity subjectEntitySave = SubjectMapper.INSTANCE.updSubject(subjectReq,subjectEntity);

    subjectRepository.save(subjectEntitySave);
    return "Update Successful!!";
  }

  @Override
  public String delete(String code) {
    SubjectEntity subjectEntity = subjectRepository.findByCode(code);

    subjectRepository.delete(subjectEntity);
    return "Deleted!!";
  }

  @Override
  public List<SubjectRes> getAll(String code) {
    List<SubjectEntity> entityList = subjectRepository.findByCodeOrNul(code);
    List<SubjectRes> subjectResList = new ArrayList<>();
    for(SubjectEntity subjectEntity : entityList){
      SubjectRes subjectRes;
      subjectRes = SubjectMapper.INSTANCE.entityToRes(subjectEntity);
      subjectResList.add(subjectRes);
    }
    return subjectResList;
  }
}
