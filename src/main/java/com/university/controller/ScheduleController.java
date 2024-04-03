package com.university.controller;

import com.university.dto.ScheduleReq;
import com.university.dto.ScheduleRes;
import com.university.service.CommonException;
import com.university.service.ScheduleService;
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
@RequestMapping("/schedule/")
public class ScheduleController {

  @Autowired
  ScheduleService scheduleService;

  @PostMapping("/")
  public ResponseEntity<String> create(@Valid @RequestBody ScheduleReq scheduleReq) {
    String schedule;
    try {
      schedule = scheduleService.create(scheduleReq);
    } catch (CommonException e) {
      return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    return new ResponseEntity<>(schedule, HttpStatus.CREATED);
  }
  @PutMapping("/")
  public ResponseEntity<String> update(@RequestParam String code, @Valid @RequestBody ScheduleReq scheduleReq){
    String schedule;
    try{
      schedule = scheduleService.update(code,scheduleReq);
    }catch (CommonException e){
      return new ResponseEntity<>(e.getMessage(),e.getHttpStatus());
    }
    return new ResponseEntity<>(schedule,HttpStatus.OK);
  }
  @DeleteMapping("/")
  public ResponseEntity<String> delete(@RequestParam String code){
    String schedule;
    try{
      schedule = scheduleService.delete(code);
    }catch (CommonException e){
      return new ResponseEntity<>(e.getMessage(),e.getHttpStatus());
    }
    return new ResponseEntity<>(schedule,HttpStatus.OK);
  }
  @GetMapping("/")
  public ResponseEntity<List<ScheduleRes>> getAll(@RequestParam String code){
    return new ResponseEntity<>(scheduleService.getAll(code),HttpStatus.OK);
  }
}
