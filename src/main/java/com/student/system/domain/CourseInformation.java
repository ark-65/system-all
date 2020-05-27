package com.student.system.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 课程信息表
 */
@Data
@Entity
public class CourseInformation {
    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(columnDefinition="char(10) COMMENT '课程号'")
    private String courseId;
    @Column(columnDefinition="char(10) COMMENT '课程名'", nullable=false)
    private String courseName;
    @Column(columnDefinition="char(10) COMMENT '课程类型'", nullable=false)
    private String courseType;
}
