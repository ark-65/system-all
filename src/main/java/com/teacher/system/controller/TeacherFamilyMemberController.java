package com.teacher.system.controller;

import com.teacher.system.domain.TeacherFamilyMember;
import com.teacher.system.service.TeacherFamilyMemberService;
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
public class TeacherFamilyMemberController {

    @Autowired
    TeacherFamilyMemberService teacherFamilyMemberService;
    
    @PutMapping("/teacher-family")
    public DataVo<TeacherFamilyMember> addDepartment(@RequestBody TeacherFamilyMember teacherFamilyMember) {
        return teacherFamilyMemberService.addTeacherFamilyMember(teacherFamilyMember);
    }
    @DeleteMapping("/teacher-family")
    public DataVo<TeacherFamilyMember> deleteDepartment(@RequestParam Integer id) {
        return teacherFamilyMemberService.deleteTeacherFamilyMember(id);
    }
    @PatchMapping("/teacher-family")
    public DataVo<TeacherFamilyMember> updateDepartment(@RequestBody  TeacherFamilyMember teacherFamilyMember) {
        return teacherFamilyMemberService.editTeacherFamilyMember(teacherFamilyMember);
    }
    @GetMapping("/teacher-family")
    public TeacherPageVo getDepartment(@PageableDefault(page = 0, size = 10, sort = {"teacher_id"}, direction = Sort.Direction.ASC)
                                               Pageable pageable) {
        return teacherFamilyMemberService.getTeacherFamilyMember(pageable);
    }
}
