package com.university.controller;

import com.university.dto.UniversityReq;
import com.university.dto.UniversityRes;
import com.university.service.CommonException;
import com.university.service.UniversityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/university/")
public class UniversityController {

  @Autowired
  UniversityService universityService;

  @PostMapping("/create")
  public ResponseEntity<String> create(@RequestBody UniversityReq universityReq) {
    String universityRes;
    try {
      universityRes = universityService.create(universityReq);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(universityRes, HttpStatus.OK);
  }

  @PutMapping("/update/{code}")
  public ResponseEntity<String> update(@PathVariable String code,
      @RequestBody UniversityReq universityReq) {
    String universityRes;
    try {
      universityRes = universityService.update(code, universityReq);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(universityRes, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{code}")
  public ResponseEntity<String> delete(@PathVariable String code) {
    String del;
    try {
      del = universityService.delete(code);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(del, HttpStatus.OK);
  }

  @GetMapping("/view/{code}")
  public ResponseEntity<List<UniversityRes>> getAll(@PathVariable String code) {
    return new ResponseEntity<>(universityService.getAll(code), HttpStatus.OK);
  }
}
