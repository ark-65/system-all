package com.teacher.system.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class TeacherInfo {
    @Id
    Integer id;
    Integer deptId;
    Integer jobTitleId;
    Integer jobId;
    String teacherName;
    String eMail;
    String contact;
}
