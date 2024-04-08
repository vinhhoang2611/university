package com.university.service.Impl;

import com.university.dto.TeacherReq;
import com.university.dto.TeacherRes;
import com.university.entity.TeacherEntity;
import com.university.mapper.TeacherMapper;
import com.university.repository.TeacherRepository;
import com.university.service.CommonException;
import com.university.service.TeacherService;
import com.university.service.exception.GlobalException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

  @Autowired
  TeacherRepository teacherRepository;
  @Autowired
  GlobalException globalException;

  @Override
  public ResponseEntity<String> create(TeacherReq teacherReq) {
    TeacherEntity teacherEntity = TeacherMapper.INSTANCE.teacherReqToEntity(teacherReq);
    try {
      getException(teacherReq.getCode(), teacherReq.getEmail(), teacherEntity,
          teacherReq.getPhone());
    }catch (CommonException e){
      return globalException.handleCommonException(e);
    }
    teacherRepository.save(teacherEntity);
    return new ResponseEntity<>("Created!!",HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> update(String code, TeacherReq teacherReq) {
    TeacherEntity teacherEntity = teacherRepository.findByCode(code);
    try {
      getException(code, teacherReq.getEmail(), null, teacherReq.getPhone());
    }catch (CommonException e){
      return globalException.handleCommonException(e);
    }
    TeacherEntity teacherEntitySave = TeacherMapper.INSTANCE.updTeacher(teacherReq, teacherEntity);

    teacherRepository.save(teacherEntitySave);

    return new ResponseEntity<>("Update Successful!!",HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> delete(String code) {
    TeacherEntity teacherEntity = teacherRepository.findByCode(code);
    try{
      if(code.isEmpty()){
        throw new CommonException("Code is not null", HttpStatus.BAD_REQUEST,"1001");
      }
    }catch (CommonException e){
      return globalException.handleCommonException(e);
    }
    teacherRepository.delete(teacherEntity);
    return new ResponseEntity<>("Deleted!!",HttpStatus.OK);
  }

  @Override
  public List<TeacherRes> getAll(String code) {
    List<TeacherEntity> teacherEntityList = teacherRepository.findByCodeOrNull(code);
    List<TeacherRes> listTeacher = new ArrayList<>();
    for (TeacherEntity teacher : teacherEntityList) {
      TeacherRes teacherRes;
      teacherRes = TeacherMapper.INSTANCE.teacherEntityToRes(teacher);
      listTeacher.add(teacherRes);
    }
    return listTeacher;
  }

  private void getException(String code, String email, TeacherEntity teacherEntity, Integer phone) {
    String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    String codeRegex = "^[A-Za]{2}+[0-9]{5}$";
    if (code.isEmpty()) {
      throw new CommonException("code is not null", HttpStatus.BAD_REQUEST, "1001");
    } else if (teacherEntity != null) {
      throw new CommonException("Code already exists", HttpStatus.BAD_REQUEST, "1001");
    } else if (!email.matches(emailRegex)) {
      throw new CommonException("Email Wrong Format!", HttpStatus.BAD_REQUEST, "1001");
    } else if (!code.matches(codeRegex)) {
      throw new CommonException("Code Wrong Format!", HttpStatus.BAD_REQUEST, "1001");
    } else if (phone.toString().length() < 10) {
      throw new CommonException("Phone number with minimum 10 characters!", HttpStatus.BAD_REQUEST,
          "202");
    }
  }
}
