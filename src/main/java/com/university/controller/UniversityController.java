package com.university.controller;

import com.university.dto.UniversityReq;
import com.university.dto.UniversityRes;
import com.university.entity.UniversityEntity;
import com.university.service.UniversityService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
  public ResponseEntity<UniversityRes> create(@RequestBody UniversityReq universityReq) {
    UniversityRes universityRes = universityService.create(universityReq);
    return new ResponseEntity<>(universityRes, HttpStatus.OK);
  }

  @PutMapping("/update/{code}")
  public ResponseEntity<UniversityRes> update(@PathVariable String code,
      @RequestBody UniversityReq universityReq) {
    UniversityRes universityRes = universityService.update(code, universityReq);
    return new ResponseEntity<>(universityRes, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{code}")
  public ResponseEntity<Map<String, Boolean>> delete(@PathVariable String code) {
    return new ResponseEntity<>(universityService.delete(code), HttpStatus.OK);
  }

  @GetMapping("/view/{code}")
  public ResponseEntity<List<UniversityEntity>> getAll(@PathVariable String code) {
    return new ResponseEntity<>(universityService.getAll(code), HttpStatus.OK);
  }
}
