package com.teacher.system.controller;

import com.teacher.system.domain.Department;
import com.teacher.system.service.DepartmentService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PutMapping("/department")
    public DataVo<Department> addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }
    @DeleteMapping("/department")
    public DataVo<Department> deleteDepartment(@RequestParam Integer id) {
        return departmentService.deleteDepartment(id);
    }
    @PatchMapping("/department")
    public DataVo<Department> updateDepartment(@RequestBody Department department) {
        return departmentService.editDepartment(department);
    }
    @GetMapping("/department")
    public DataPageVo<Department> getDepartment(@PageableDefault(page = 0, size = 10, sort = {"id"}, direction = Sort.Direction.ASC)
                                            Pageable pageable) {
        return departmentService.getDepartment(pageable);
    }
}
