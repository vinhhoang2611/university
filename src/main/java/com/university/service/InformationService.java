package com.university.service;

import com.university.dto.InformationReq;
import com.university.dto.InformationRes;
import java.util.List;

public interface InformationService {
    String create(InformationReq informationReq);
    String update(String code,InformationReq informationReq);
    String delete(String code);
    List<InformationRes> getAll(String username);
}
