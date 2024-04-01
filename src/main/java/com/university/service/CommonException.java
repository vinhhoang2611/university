package com.university.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class CommonException extends RuntimeException {

  private String message;
  private HttpStatus httpStatus;
  private String errorCode;

}
