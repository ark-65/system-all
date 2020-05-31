package com.teacher.system.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Job {
    @Id
    Integer id;
    String jobName;
    Integer num;
}
