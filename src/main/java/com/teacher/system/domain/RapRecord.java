package com.teacher.system.domain;

import javax.persistence.Id;

public class RapRecord {
    @Id
    Integer id;
    Integer teacherId;
    String rapType;
    String remarks;
}
