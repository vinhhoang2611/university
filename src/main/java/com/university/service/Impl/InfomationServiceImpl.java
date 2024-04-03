package com.university.service.Impl;

import com.university.dto.InformationReq;
import com.university.dto.InformationRes;
import com.university.entity.InformationEntity;
import com.university.mapper.InformationMapper;
import com.university.repository.InformationRepository;
import com.university.service.CommonException;
import com.university.service.InformationService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service // component
public class InfomationServiceImpl implements InformationService {

  @Autowired
  InformationRepository informationRepository;


  @Override
  public String create(InformationReq informationReq) {
    InformationEntity informationEntity = InformationMapper.INSTANCE.inforReqToEntity(
        informationReq);
    getException(informationReq.getUsername(), informationReq.getPassword(),
        informationReq.getRePassword(), informationReq.getEmail());
    informationRepository.save(informationEntity);
    return "Created!!";
  }

  @Override
  public String update(String code, InformationReq informationReq) {
    InformationEntity informationEntity = informationRepository.getByCode(code);

    InformationEntity informationEntitySave = InformationMapper.INSTANCE.mapInformation(
        informationReq, informationEntity);

    informationRepository.save(informationEntitySave);
    return "Update Successful!!";
  }

  @Override
  public String delete(String code) {
    InformationEntity informationEntity = informationRepository.getByCode(code);

    informationRepository.delete(informationEntity);

    return "Deleted!!";
  }

  @Override
  public List<InformationRes> getAll(String username) {
    List<InformationEntity> entityList = informationRepository.getByCodeOrNull(username);
    List<InformationRes> resList = new ArrayList<>();
    for (InformationEntity entity : entityList) {
      InformationRes informationRes;
      informationRes = InformationMapper.INSTANCE.inforEntityToRes(entity);
      resList.add(informationRes);
    }
    return resList;
  }

  private void getException(String username, String password, String rePassword, String email) {
    String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    String user = informationRepository.getByName(username);
    if (!email.matches(emailRegex)) {
      throw new CommonException("Email Wrong Format!!", HttpStatus.BAD_REQUEST, "202");
    } else if (!password.equals(rePassword)) {
      throw new CommonException(("rePassword Fail!!"), HttpStatus.BAD_REQUEST, "202");
    } else if (user != null) {
      throw new CommonException(("username already exist!!"), HttpStatus.BAD_REQUEST, "202");
    }
  }
}
