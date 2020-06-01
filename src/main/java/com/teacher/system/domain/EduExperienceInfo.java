package com.teacher.system.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class EduExperienceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String startTime;
    String endTime;
    String schoolName;
    String education;
    Integer teacherId;
    String eduType;
}
