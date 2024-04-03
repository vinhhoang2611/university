package com.university.service.Impl;

import com.university.dto.StudentReq;
import com.university.dto.StudentRes;
import com.university.entity.StudentEntity;
import com.university.entity.UniversityEntity;
import com.university.mapper.StudentMapper;
import com.university.repository.StudentRepository;
import com.university.repository.UniversityRepository;
import com.university.service.CommonException;
import com.university.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service

public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository studentRepository;
  @Autowired
  UniversityRepository universityRepository;

  @Override
  public String create(StudentReq studentReq) {
    StudentEntity studentEntityCheck = studentRepository.findByCode(studentReq.getCode());
    getException(studentReq.getCode(), studentReq.getEmail(), studentEntityCheck,
        studentReq.getPhone(), studentReq.getUniversityCode());
    StudentEntity studentEntity = StudentMapper.INSTANCE.reqToEntity(studentReq);

    studentRepository.save(studentEntity);
    return "Created!!";
  }

  @Override
  public String update(String code, StudentReq studentReq) {
    StudentEntity studentEntity = studentRepository.findByCode(code);
    getException(code, studentReq.getEmail(), null,
        studentReq.getPhone(),studentReq.getUniversityCode());

    StudentEntity studentEntitySave = StudentMapper.INSTANCE.updStudent(studentReq,studentEntity);

    studentRepository.save(studentEntitySave);

    return "Update Successful!!";
  }

  @Override
  public String delete(String code) {
    StudentEntity studentEntity = studentRepository.findByCode(code);
    if (code.isEmpty()) {
      throw new CommonException("Code is not null", HttpStatus.BAD_REQUEST, "202");
    }
    studentRepository.delete(studentEntity);
    return "Deleted!!";
  }

  @Override
  public List<StudentRes> getAll(String code) {
    List<StudentEntity> studentEntityList = studentRepository.findByCodeOrNull(code);
    List<StudentRes> listStudent = new ArrayList<>();
    for (StudentEntity student : studentEntityList) {
      StudentRes studentRes;
      studentRes = StudentMapper.INSTANCE.entityToRes(student);
      listStudent.add(studentRes);
    }
    return listStudent;
  }

  private void getException(String code, String email, StudentEntity studentEntity,
      Integer phone, String universityCode) {
    String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    String codeRegex = "^[A-Za]{2}+[0-9]{5}$";
    UniversityEntity university = universityRepository.findByCode(universityCode);
    if (code.isEmpty()) {
      throw new CommonException("code is not null", HttpStatus.BAD_REQUEST, "1001");
    } else if (studentEntity != null) {
      throw new CommonException("Code already exists", HttpStatus.BAD_REQUEST, "1001");
    } else if (!email.matches(emailRegex)) {
      throw new CommonException("Email Wrong Format!", HttpStatus.BAD_REQUEST, "1001");
    } else if (!code.matches(codeRegex)) {
      throw new CommonException("Code Wrong Format!", HttpStatus.BAD_REQUEST, "1001");
    } else if (phone.toString().length() < 10) {
      throw new CommonException("Phone number with minimum 10 characters!", HttpStatus.BAD_REQUEST,
          "202");
    } else if (university == null) {
      throw new CommonException("University does not exists!!", HttpStatus.BAD_REQUEST, "202");
    }
  }
}
