package com.university.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleRes {
  private String code;
  private String subject_code;
  private String teacher_code;
  private String student_code;
  private String day;
}
