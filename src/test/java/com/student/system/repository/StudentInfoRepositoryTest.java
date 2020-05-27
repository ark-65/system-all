package com.student.system.repository;

import com.student.system.domain.StudentInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentInfoRepositoryTest {

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @Test
    void save() {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setName("赵铁柱");
        studentInfo.setClassNumber("000001");
        studentInfo.setDateOfBirth(new Date());
        studentInfo.setGender("男");
        studentInfo.setNation("啥");
        studentInfo.setStudentId("s0000001");
        studentInfoRepository.save(studentInfo);
    }
}