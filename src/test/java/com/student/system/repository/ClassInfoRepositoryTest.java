package com.student.system.repository;

import com.student.system.domain.ClassInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClassInfoRepositoryTest {

    @Autowired
    ClassInfoRepository classInfoRepository;

    @Test
    void save() {
        ClassInfo classInfo = new ClassInfo();
        classInfo.setClassId("c000001");
        classInfo.setClassNumber("000001");
        classInfo.setClassSize(60);
        classInfo.setDepartment("发发发");
        classInfo.setHeadTeacher("王钢蛋");
        classInfo.setProfession("反反复");
        classInfoRepository.save(classInfo);
    }
}