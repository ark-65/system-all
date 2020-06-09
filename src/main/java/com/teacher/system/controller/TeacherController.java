package com.teacher.system.controller;

import com.teacher.system.domain.TeacherInfo;
import com.teacher.system.service.TeacherService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import com.teacher.system.vo.TeacherPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PutMapping("/teacher-info")
    public DataVo<TeacherInfo> addDepartment(@RequestBody TeacherInfo teacherInfo) {
        return teacherService.addTeacher(teacherInfo);
    }
    @DeleteMapping("/teacher-info")
    public DataVo<TeacherInfo> deleteDepartment(@RequestParam Integer id) {
        return teacherService.deleteTeacher(id);
    }
    @PatchMapping("/teacher-info")
    public DataVo<TeacherInfo> updateDepartment(@RequestBody  TeacherInfo teacherInfo) {
        return teacherService.editTeacher(teacherInfo);
    }
    @GetMapping("/teacher-info")
    public TeacherPageVo getDepartment(@PageableDefault(page = 0, size = 10, sort = {"id"}, direction = Sort.Direction.ASC)
                                                      Pageable pageable) {
        return teacherService.getTeacher(pageable);
    }
}
