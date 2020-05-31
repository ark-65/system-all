package com.teacher.system.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键根据mysql系统自动增长
    Integer id;
    String jobTitleName;
    Integer num = 0;
}
