package com.university.service.Impl;

import com.university.dto.StudentReq;
import com.university.dto.StudentRes;
import com.university.entity.StudentEntity;
import com.university.mapper.StudentEntityReqMapper;
import com.university.repository.StudentRepository;
import com.university.service.StudentService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Override
  public StudentRes create(StudentReq studentReq) {

    StudentEntity studentEntity = StudentEntityReqMapper.INSTANCE.reqToEntity(studentReq);

    StudentEntity studentEntitySave = studentRepository.save(studentEntity);
    return StudentEntityReqMapper.INSTANCE.entityToRes(studentEntitySave);
  }

  @Override
  public StudentRes update(String code, StudentReq studentReq) {
    StudentEntity studentEntity = studentRepository.findByCode(code);

    studentEntity.setCode(studentReq.getCode());
    studentEntity.setName(studentReq.getName());
    studentEntity.setEmail(studentReq.getEmail());
    studentEntity.setPhone(studentReq.getPhone());
    studentEntity.setUniversityCode(studentReq.getUniversityCode());
    studentEntity.setAge(studentReq.getAge());
    studentEntity.setSemester(studentReq.getSemester());
    studentEntity.setSex(studentReq.getSex());
    studentEntity.setBirthdate(studentReq.getBirthdate());
    studentEntity.setMajorsCode(studentReq.getMajorsCode());

    StudentEntity studentEntitySave = studentRepository.save(studentEntity);

    return StudentEntityReqMapper.INSTANCE.entityToRes(studentEntitySave);
  }

  @Override
  public Map<String, Boolean> delete(String code) {
    StudentEntity studentEntity = studentRepository.findByCode(code);
    studentRepository.delete(studentEntity);
    Map<String, Boolean> respone = new HashMap<>();
    respone.put("Deleted", Boolean.TRUE);
    return respone;
  }

  @Override
  public List<StudentEntity> getAll(String code) {
    List<StudentEntity> studentEntityList = studentRepository.findByCodeOrNull(code);
    return studentEntityList;
  }
}
