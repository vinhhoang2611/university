package com.university.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentReq {
  @NotBlank(message = "Code must not be null or blank")
  private String code;
  private String name;
  private String email;
  private Integer phone;
  private String universityCode;
  @Min(value = 1, message = "age can not be less than 1")
  @Max(value = 999, message = "age can not be greater than 999")
  private Integer age;
  private String semester;
  private String sex;
  private Date birthdate;
  private String majorsCode;

}
