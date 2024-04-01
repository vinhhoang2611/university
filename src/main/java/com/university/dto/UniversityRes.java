package com.university.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UniversityRes {

  private String code;
  private String name;
  private String email;
  private String manager;
  private Integer phone;
  private String address;
  private Integer quantityStudent;
}
