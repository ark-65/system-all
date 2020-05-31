package com.teacher.system.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class EduExperienceInfo {
    @Id
    Integer id;
    String startTime;
    String endTime;
    String schoolName;
    String education;
    Integer teacherId;
    String eduType;
}
