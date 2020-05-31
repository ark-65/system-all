package com.teacher.system.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String departmentName;
    Integer num = 0;
}
