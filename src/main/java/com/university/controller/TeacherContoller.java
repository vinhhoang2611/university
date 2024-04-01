package com.university.controller;

import com.university.dto.TeacherReq;
import com.university.dto.TeacherRes;
import com.university.entity.TeacherEntity;
import com.university.service.TeacherService;
import java.util.List;
import java.util.Map;
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
  public ResponseEntity<TeacherRes> create(@RequestBody TeacherReq teacherReq) {
    TeacherRes teacherRes = teacherService.create(teacherReq);
    return new ResponseEntity<>(teacherRes, HttpStatus.OK);
  }

  @PutMapping("/update/{code}")
  public ResponseEntity<TeacherRes> update(@PathVariable String code,
      @RequestBody TeacherReq teacherReq) {
    TeacherRes teacherRes = teacherService.update(code, teacherReq);
    return new ResponseEntity<>(teacherRes, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{code}")
  public ResponseEntity<Map<String, Boolean>> delete(@PathVariable String code) {
    return new ResponseEntity<>(teacherService.delete(code), HttpStatus.OK);
  }

  @GetMapping("/view/{code}")
  public ResponseEntity<List<TeacherEntity>> getAll(@PathVariable String code) {
    return new ResponseEntity<>(teacherService.getAll(code), HttpStatus.OK);
  }
}
