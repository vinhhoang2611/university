package com.university.controller;

import com.university.dto.TeacherReq;
import com.university.dto.TeacherRes;
import com.university.service.TeacherService;
import jakarta.validation.Valid;
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
  public ResponseEntity<String> create(@Valid @RequestBody TeacherReq teacherReq) {

    return teacherService.create(teacherReq);
  }

  @PutMapping("/update/{code}")
  public ResponseEntity<String> update(@PathVariable String code,
      @Valid @RequestBody TeacherReq teacherReq) {

    return teacherService.update(code, teacherReq);
  }

  @DeleteMapping("/delete/{code}")
  public ResponseEntity<String> delete(@PathVariable String code) {

    return teacherService.delete(code);
  }

  @GetMapping("/view/{code}")
  public ResponseEntity<List<TeacherRes>> getAll(@PathVariable String code) {
    return new ResponseEntity<>(teacherService.getAll(code), HttpStatus.OK);
  }
}
