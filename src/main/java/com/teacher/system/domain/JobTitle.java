package com.teacher.system.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class JobTitle {
    @Id
    Integer id;
    String jobTitleName;
    Integer num;
}
