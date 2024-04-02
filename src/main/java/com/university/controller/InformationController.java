package com.university.controller;

import com.university.dto.InformationReq;
import com.university.dto.InformationRes;
import com.university.service.CommonException;
import com.university.service.InformationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/information/")
public class InformationController {

  @Autowired
  InformationService informationService;

  @PostMapping("/")
  public ResponseEntity<String> create(@RequestBody InformationReq informationReq) {
    String create;
    try {
      create = informationService.create(informationReq);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(create, HttpStatus.CREATED);
  }

  @PutMapping("/")
  public ResponseEntity<String> update(@RequestParam String code,
      @RequestBody InformationReq informationReq) {
    String update;
    try {
      update = informationService.update(code, informationReq);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(update, HttpStatus.OK);
  }

  @DeleteMapping("/")
  public ResponseEntity<String> delete(@RequestParam String code) {
    String delete;
    try {
      delete = informationService.delete(code);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(delete, HttpStatus.OK);
  }

  @GetMapping("/")
  public ResponseEntity<List<InformationRes>> getAll(@RequestParam String code){
    return new ResponseEntity<>(informationService.getAll(code),HttpStatus.OK);
  }
}
