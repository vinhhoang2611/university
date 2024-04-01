package com.university.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeacherRes {

  private String code;
  private String name;
  private String address;
  private String email;
  private Integer phone;
  private String universityCode;
  private Integer age;
  private String sex;
  private Date birthdate;
  private String subject;
  private Integer salary;
}
