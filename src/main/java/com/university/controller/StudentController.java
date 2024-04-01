package com.university.controller;

import com.university.dto.StudentReq;
import com.university.dto.StudentRes;
import com.university.entity.StudentEntity;
import com.university.service.StudentService;
import jakarta.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/")
public class StudentController {

  @Autowired
  StudentService studentService;

  @PostMapping("/")
  public ResponseEntity<StudentRes> createStudent(@Valid @RequestBody StudentReq studentReq) {
    StudentRes studentRes = studentService.create(studentReq);
    return new ResponseEntity<>(studentRes, HttpStatus.CREATED);
  }

  @PutMapping("/{code}")
  public ResponseEntity<StudentRes> updateStudent(@PathVariable String code,
      @RequestBody StudentReq studentReq) {
    StudentRes studentRes = studentService.update(code, studentReq);
    return new ResponseEntity<>(studentRes, HttpStatus.OK);
  }

  @DeleteMapping("/{code}")
  public ResponseEntity<Map<String, Boolean>> delete(@PathVariable String code) {
    return new ResponseEntity<>(studentService.delete(code), HttpStatus.OK);
  }

  @GetMapping("/")
  public ResponseEntity<List<StudentEntity>> getAll(@RequestParam(required = false) String code) {
    return new ResponseEntity<>(studentService.getAll(code), HttpStatus.OK);
  }
}
