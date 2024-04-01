package com.university.service.Impl;

import com.university.dto.UniversityReq;
import com.university.dto.UniversityRes;
import com.university.entity.UniversityEntity;
import com.university.mapper.UniversityMapper;
import com.university.mapper.UniversityMapperImpl;
import com.university.repository.UniversityRepository;
import com.university.service.UniversityService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {

  @Autowired
  UniversityRepository universityRepository;
  UniversityMapper universityMapper = new UniversityMapperImpl();

  @Override
  public UniversityRes create(UniversityReq universityReq) {
    UniversityEntity university = universityMapper.universityReqToEntity(universityReq);

    UniversityEntity universitySave = universityRepository.save(university);
    return universityMapper.universityEntityToRes(universitySave);
  }

  @Override
  public UniversityRes update(String code, UniversityReq universityReq) {
    UniversityEntity universityEntity = universityRepository.findByCode(code);

    universityEntity.setCode(universityReq.getCode());
    universityEntity.setName(universityReq.getName());
    universityEntity.setEmail(universityReq.getEmail());
    universityEntity.setManager(universityReq.getManager());
    universityEntity.setPhone(universityReq.getPhone());
    universityEntity.setAddress(universityReq.getAddress());
    universityEntity.setQuantityStudent(universityReq.getQuantityStudent());

    UniversityEntity universitySave = universityRepository.save(universityEntity);
    return universityMapper.universityEntityToRes(universitySave);
  }

  @Override
  public Map<String, Boolean> delete(String code) {
    UniversityEntity university = universityRepository.findByCode(code);
    universityRepository.delete(university);
    Map<String, Boolean> respone = new HashMap<>();
    respone.put("Delete", Boolean.TRUE);
    return respone;
  }

  @Override
  public List<UniversityEntity> getAll(String code) {
    List<UniversityEntity> universityEntityList = universityRepository.findByCodeOrNull(code);
    return universityEntityList;
  }
}
