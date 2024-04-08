package com.university.controller;

import com.university.dto.InformationReq;
import com.university.dto.InformationRes;
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
    return informationService.create(informationReq);
  }

  @PutMapping("/")
  public ResponseEntity<String> update(@RequestParam String code,
      @RequestBody InformationReq informationReq) {
    return informationService.update(code, informationReq);
  }

  @DeleteMapping("/")
  public ResponseEntity<String> delete(@RequestParam String code) {
    return informationService.delete(code);
  }

  @GetMapping("/")
  public ResponseEntity<List<InformationRes>> getAll(@RequestParam String code){
    return new ResponseEntity<>(informationService.getAll(code),HttpStatus.OK);
  }
}
