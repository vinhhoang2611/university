package com.university.service;

import com.university.dto.InformationReq;
import com.university.dto.InformationRes;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface InformationService {
    ResponseEntity<String> create(InformationReq informationReq);
    ResponseEntity<String> update(String code,InformationReq informationReq);
    ResponseEntity<String> delete(String code);
    List<InformationRes> getAll(String username);
}
