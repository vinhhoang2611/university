package com.university.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InformationRes {
  String username;
  String name;
  String email;
  Integer phone;
  String userType;
  String permission;
}
