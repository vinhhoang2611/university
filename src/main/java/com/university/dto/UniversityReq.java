package com.university.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniversityReq {
  @NotEmpty(message = "code must not be null or blank")
  private String code;
  @NotEmpty(message = "name must not be null or blank")
  private String name;
  private String email;
  private String manager;
  private Integer phone;
  private String address;
  @Min(value = 1,message = "Quantity Student can not less than 1")
  private Integer quantityStudent;
}
