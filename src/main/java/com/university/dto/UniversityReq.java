package com.university.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniversityReq {

  private String code;
  private String name;
  private String email;
  private String manager;
  private Integer phone;
  private String address;
  private Integer quantityStudent;
}
