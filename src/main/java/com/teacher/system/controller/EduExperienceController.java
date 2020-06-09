package com.teacher.system.controller;

import com.teacher.system.domain.EduExperienceInfo;
import com.teacher.system.service.EduExperienceService;
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
public class EduExperienceController {

    @Autowired
    private EduExperienceService eduExperienceService;

    @PutMapping("/edu-experience")
    public DataVo<EduExperienceInfo> addDepartment(@RequestBody EduExperienceInfo eduExperienceInfo) {
        return eduExperienceService.addEduExperience(eduExperienceInfo);
    }
    @DeleteMapping("/edu-experience")
    public DataVo<EduExperienceInfo> deleteDepartment(@RequestParam Integer id) {
        return eduExperienceService.deleteEduExperience(id);
    }
    @PatchMapping("/edu-experience")
    public DataVo<EduExperienceInfo> updateDepartment(@RequestBody  EduExperienceInfo eduExperienceInfo) {
        return eduExperienceService.editEduExperience(eduExperienceInfo);
    }
    @GetMapping("/edu-experience")
    public TeacherPageVo getDepartment(@PageableDefault(page = 0, size = 10, sort = {"teacher_id"}, direction = Sort.Direction.ASC)
                                                       Pageable pageable) {
        return eduExperienceService.getEduExperience(pageable);
    }
}
