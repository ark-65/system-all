package com.student.system.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 学生信息表
 */
@Entity
public class StudentInfo {

    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(columnDefinition="char(10) COMMENT '学生的学号'")
    private String studentId;
    @Column(columnDefinition="char(10) COMMENT '学生的姓名'", nullable=false)
    private String name;
    @Column(columnDefinition="char(1) COMMENT '学生的性别'", nullable=false)
    private String gender;
    @Column(columnDefinition="char(5) COMMENT '学生所在的民族'", nullable=false)
    private String nation;
    @Column(columnDefinition="date COMMENT '学生的出生日期'", nullable=false)
    private Date dateOfBirth;
    @Column(columnDefinition="char(20) COMMENT '班级编号'", nullable=false)
    private String classId;



    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClassNumber() {
        return classId;
    }

    public void setClassNumber(String classId) {
        this.classId = classId;
    }
}