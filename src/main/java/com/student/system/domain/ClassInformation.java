package com.student.system.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 上课信息
 */
@Data
@Entity
public class ClassInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition="char(20) COMMENT '上课的班级编号'", nullable=false)
    private String classId;
    @Column(columnDefinition="char(10) COMMENT '所上课的课程号'", nullable=false)
    private String courseId;
    @Column(columnDefinition="char(10) COMMENT '上该课程的教师'", nullable=false)
    private String classTeacher;
}
