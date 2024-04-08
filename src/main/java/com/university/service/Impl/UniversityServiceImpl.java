package com.university.service.Impl;

import com.university.dto.UniversityReq;
import com.university.dto.UniversityRes;
import com.university.entity.UniversityEntity;
import com.university.mapper.UniversityMapper;
import com.university.repository.UniversityRepository;
import com.university.service.CommonException;
import com.university.service.UniversityService;
import com.university.service.exception.GlobalException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {

  @Autowired
  UniversityRepository universityRepository;
  @Autowired
  GlobalException globalException;

  @Override
  public ResponseEntity<String> create(UniversityReq universityReq) {
    UniversityEntity university = UniversityMapper.INSTANCE.universityReqToEntity(universityReq);
    try {
      getException(universityReq.getCode(), universityReq.getEmail(), university,
          universityReq.getPhone());
    } catch (CommonException e) {
      return globalException.handleCommonException(e);
    }
    universityRepository.save(university);

    return new ResponseEntity<>("Created!!", HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> update(String code, UniversityReq universityReq) {
    UniversityEntity universityEntity = universityRepository.findByCode(code);
    try {
      getException(code, universityReq.getEmail(), null, universityReq.getPhone());
    } catch (CommonException e) {
      return globalException.handleCommonException(e);
    }
    UniversityEntity universityEntitySave = UniversityMapper.INSTANCE.updUniver(universityReq,
        universityEntity);

    universityRepository.save(universityEntitySave);
    return new ResponseEntity<>("Update Successful!!", HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> delete(String code) {
    UniversityEntity university = universityRepository.findByCode(code);
    try {
      if (code.isEmpty()) {
        throw new CommonException("Code is not null!!", HttpStatus.BAD_REQUEST, "1001");
      }
    } catch (CommonException e) {
      return globalException.handleCommonException(e);
    }
    universityRepository.delete(university);
    return new ResponseEntity<>("Deleted!!", HttpStatus.OK);
  }

  @Override
  public List<UniversityRes> getAll(String code) {
    List<UniversityEntity> universityEntityList = universityRepository.findByCodeOrNull(code);
    List<UniversityRes> listRes = new ArrayList<>();
    for (UniversityEntity uniEntity : universityEntityList) {
      UniversityRes universityRes;
      universityRes = UniversityMapper.INSTANCE.universityEntityToRes(uniEntity);
      listRes.add(universityRes);
    }
    return listRes;
  }

  private void getException(String code, String email, UniversityEntity universityEntity,
      Integer phone) {
    String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    String codeRegex = "^[A-Za]{2}+[0-9]{5}$";
    if (code.isEmpty()) {
      throw new CommonException("code is not null", HttpStatus.BAD_REQUEST, "1001");
    } else if (universityEntity != null) {
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
