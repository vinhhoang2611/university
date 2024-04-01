package com.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "teacher")
public class TeacherEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
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
