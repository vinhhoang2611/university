package com.university.service.exception;

import com.university.service.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

  @ExceptionHandler(CommonException.class)
  public ResponseEntity<String> handleCommonException(CommonException commonException) {
    return new ResponseEntity<>(commonException.getMessage(), commonException.getHttpStatus());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception){
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
