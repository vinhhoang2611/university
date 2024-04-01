package com.university.controller;

import com.university.dto.StudentReq;
import com.university.dto.StudentRes;
import com.university.service.CommonException;
import com.university.service.StudentService;
import jakarta.validation.Valid;
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
@RequestMapping("/student/")
public class StudentController {

  @Autowired
  StudentService studentService;

  @PostMapping("/")
  public ResponseEntity<String> createStudent(@Valid @RequestBody StudentReq studentReq) {
    String studentRes;
    try {
      studentRes = studentService.create(studentReq);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(studentRes, HttpStatus.CREATED);
  }

  @PutMapping("/{code}")
  public ResponseEntity<String> updateStudent(@RequestParam String code,
      @RequestBody StudentReq studentReq) {
    String studentRes;
    try {
      studentRes = studentService.update(code, studentReq);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(studentRes, HttpStatus.OK);
  }

  @DeleteMapping("/{code}")
  public ResponseEntity<String> delete(@RequestParam String code) {
    String del;
    try {
      del = studentService.delete(code);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(del, HttpStatus.OK);

  }

  @GetMapping("/")
  public ResponseEntity<List<StudentRes>> getAll(@RequestParam(required = false) String code) {
    return new ResponseEntity<>(studentService.getAll(code), HttpStatus.OK);
  }
}
