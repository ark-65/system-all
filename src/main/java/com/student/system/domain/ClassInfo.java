package com.student.system.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 班级信息表
 */
@Data
@Entity
public class ClassInfo {

    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(columnDefinition="char(20) COMMENT '班级编号'")
    private String classId;
    @Column(columnDefinition="char(20) COMMENT '班级所在的院系'", nullable=false)
    private String department;
    @Column(columnDefinition="char(20) COMMENT '班级所在的专业'", nullable=false)
    private String profession;
    @Column(columnDefinition="char(10) COMMENT '班级的班号'", nullable=false)
    private String classNumber;
    @Column(columnDefinition="char(10) COMMENT '带班的班主任'", nullable=false)
    private String headTeacher;
    @Column(columnDefinition="smallint COMMENT '班级的人数'", nullable=false)
    private Integer classSize;
}