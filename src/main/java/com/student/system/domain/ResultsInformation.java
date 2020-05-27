package com.student.system.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *成绩信息表
 */
@Data
@Entity
public class ResultsInformation {
    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(columnDefinition="char(20) COMMENT '学号'")
    private String courseId;
    @Column(columnDefinition="char(10) COMMENT '课程号'", nullable=false)
    private String studentId;
    @Column(columnDefinition="float(10) COMMENT '学生该课程成绩'", nullable=false)
    private float courseType;
}
