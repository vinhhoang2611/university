package com.university.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherReq {
  @NotEmpty(message = "code must be not null or blank")
  private String code;
  @NotEmpty(message = "name must be not null or blank")
  private String name;
  private String address;
  private String email;
  private Integer phone;
  private String universityCode;
  @Min(value = 1,message = "Age can not be less than 1")
  @Max(value = 99, message = "Age can not be greater than 99")
  private Integer age;
  private String sex;
  private Date birthdate;
  private String subject;
  private Integer salary;
}
