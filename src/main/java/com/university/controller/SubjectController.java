package com.university.controller;

import com.university.dto.SubjectReq;
import com.university.dto.SubjectRes;
import com.university.service.CommonException;
import com.university.service.SubjectService;
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
@RequestMapping("/subject/")
public class SubjectController {
  @Autowired
  SubjectService subjectService;

  @PostMapping("/")
  public ResponseEntity<String> create(@Valid @RequestBody SubjectReq subjectReq){
    String subject;
    try{
      subject = subjectService.create(subjectReq);
    }catch (CommonException e){
      return new ResponseEntity<>(e.getMessage(),e.getHttpStatus());
    }
    return new ResponseEntity<>(subject, HttpStatus.CREATED);
  }
  @PutMapping("/")
  public ResponseEntity<String> update(@RequestParam String code, @Valid @RequestBody SubjectReq subjectReq){
    String subject;
    try{
      subject = subjectService.update(code, subjectReq);
    }catch (CommonException e){
      return new ResponseEntity<>(e.getMessage(),e.getHttpStatus());
    }
    return new ResponseEntity<>(subject,HttpStatus.OK);
  }
  @DeleteMapping("")
  public ResponseEntity<String> delete(@RequestParam String code){
    String subject;
    try{
      subject = subjectService.delete(code);
    }catch (CommonException e){
      return new ResponseEntity<>(e.getMessage(),e.getHttpStatus());
    }
    return new ResponseEntity<>(subject,HttpStatus.OK);
  }
  @GetMapping("/")
  public ResponseEntity<List<SubjectRes>> getAll(@RequestParam String code){
    return new ResponseEntity<>(subjectService.getAll(code),HttpStatus.OK);
  }
}
