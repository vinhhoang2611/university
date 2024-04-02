package com.university.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InformationReq {
  String username;
  String password;
  String rePassword;
  String code;
  String name;
  String email;
  Integer phone;
  String userType;
  String permission;
}
