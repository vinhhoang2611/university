package com.university.service.Impl;

import com.university.dto.TeacherReq;
import com.university.dto.TeacherRes;
import com.university.entity.TeacherEntity;
import com.university.mapper.TeacherMapper;
import com.university.mapper.TeacherMapperImpl;
import com.university.repository.TeacherRepository;
import com.university.service.TeacherService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

  @Autowired
  TeacherRepository teacherRepository;
  TeacherMapper teacherMapper = new TeacherMapperImpl();

  @Override
  public TeacherRes create(TeacherReq teacherReq) {
    TeacherEntity teacherEntity = teacherMapper.teacherReqToEntity(teacherReq);

    TeacherEntity teacherEntitySave = teacherRepository.save(teacherEntity);
    return teacherMapper.teacherEntityToRes(teacherEntitySave);
  }

  @Override
  public TeacherRes update(String code, TeacherReq teacherReq) {
    TeacherEntity teacherEntity = teacherRepository.findByCode(code);

    teacherEntity.setCode(teacherReq.getCode());
    teacherEntity.setName(teacherReq.getName());
    teacherEntity.setAddress(teacherReq.getAddress());
    teacherEntity.setEmail(teacherReq.getEmail());
    teacherEntity.setPhone(teacherReq.getPhone());
    teacherEntity.setUniversity_code(teacherReq.getUniversity_code());
    teacherEntity.setAge(teacherReq.getAge());
    teacherEntity.setSex(teacherReq.getSex());
    teacherEntity.setBirthdate(teacherReq.getBirthdate());
    teacherEntity.setSubject(teacherReq.getSubject());
    teacherEntity.setSalary(teacherReq.getSalary());

    TeacherEntity teacherEntitySave = teacherRepository.save(teacherEntity);

    return teacherMapper.teacherEntityToRes(teacherEntitySave);
  }

  @Override
  public Map<String, Boolean> delete(String code) {
    TeacherEntity teacherEntity = teacherRepository.findByCode(code);
    teacherRepository.delete(teacherEntity);
    Map<String, Boolean> respone = new HashMap<>();
    respone.put("Delete", Boolean.TRUE);
    return respone;
  }

  @Override
  public List<TeacherEntity> getAll(String code) {
    List<TeacherEntity> teacherEntityList = teacherRepository.findByCodeOrNull(code);
    return teacherEntityList;
  }
}
