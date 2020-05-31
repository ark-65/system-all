package com.teacher.system.repository;

import com.teacher.system.domain.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void save() {
        Department department = new Department();
        department.setId(12);
        department.setDepartmentName("外道");
        department.setNum(2);
        departmentRepository.save(department);
    }
}