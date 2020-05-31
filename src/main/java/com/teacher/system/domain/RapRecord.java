package com.teacher.system.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class RapRecord {
    @Id
    Integer id;
    Integer teacherId;
    String rapType;
    String remarks;
}
