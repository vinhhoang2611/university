package com.university.service.Impl;

import com.university.dto.UniversityReq;
import com.university.dto.UniversityRes;
import com.university.entity.UniversityEntity;
import com.university.mapper.UniversityMapper;
import com.university.repository.UniversityRepository;
import com.university.service.CommonException;
import com.university.service.UniversityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {

  @Autowired
  UniversityRepository universityRepository;


  @Override
  public String create(UniversityReq universityReq) {
    UniversityEntity university = UniversityMapper.INSTANCE.universityReqToEntity(universityReq);
    getException(universityReq.getCode(), universityReq.getEmail(), university,
        universityReq.getPhone());
    universityRepository.save(university);
    return "Created!!";
  }

  @Override
  public String update(String code, UniversityReq universityReq) {
    UniversityEntity universityEntity = universityRepository.findByCode(code);

    getException(code, universityReq.getEmail(), null, universityReq.getPhone());

    universityEntity.setName(universityReq.getName());
    universityEntity.setEmail(universityReq.getEmail());
    universityEntity.setManager(universityReq.getManager());
    universityEntity.setPhone(universityReq.getPhone());
    universityEntity.setAddress(universityReq.getAddress());
    universityEntity.setQuantityStudent(universityReq.getQuantityStudent());

    universityRepository.save(universityEntity);
    return "Update Successful!!";
  }

  @Override
  public String delete(String code) {
    UniversityEntity university = universityRepository.findByCode(code);
    universityRepository.delete(university);

    return "Deleted!!";
  }

  @Override
  public List<UniversityRes> getAll(String code) {
    List<UniversityEntity> universityEntityList = universityRepository.findByCodeOrNull(code);
    List<UniversityRes> listRes = new ArrayList<>();
    for(UniversityEntity uniEntity : universityEntityList){
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
