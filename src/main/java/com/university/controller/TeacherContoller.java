package com.university.controller;

import com.university.dto.TeacherReq;
import com.university.dto.TeacherRes;
import com.university.service.CommonException;
import com.university.service.TeacherService;
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
@RequestMapping("/teacher/")
public class TeacherContoller {

  @Autowired
  TeacherService teacherService;

  @PostMapping("/create")
  public ResponseEntity<String> create(@RequestBody TeacherReq teacherReq) {
    String teacherRes;
    try {
      teacherRes = teacherService.create(teacherReq);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(teacherRes, HttpStatus.OK);
  }

  @PutMapping("/update/{code}")
  public ResponseEntity<String> update(@PathVariable String code,
      @RequestBody TeacherReq teacherReq) {
    String teacherRes;
    try {
      teacherRes = teacherService.update(code, teacherReq);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(teacherRes, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{code}")
  public ResponseEntity<String> delete(@PathVariable String code) {
    String del;
    try {
      del = teacherService.delete(code);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(del, HttpStatus.OK);
  }

  @GetMapping("/view/{code}")
  public ResponseEntity<List<TeacherRes>> getAll(@PathVariable String code) {
    return new ResponseEntity<>(teacherService.getAll(code), HttpStatus.OK);
  }
}
