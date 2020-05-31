package com.teacher.system.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class TeacherFamilyMember {
    @Id
    Integer id;
    Integer teacherId;
    String relationship;
    String memberName;
    String contact;
}
