package com.teacher.system.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Department {
    @Id
    Integer id;
    String departmentName;
    Integer num;
}
