package com.teacher.system.controller;

import com.teacher.system.domain.Department;
import com.teacher.system.domain.JobTitle;
import com.teacher.system.service.DepartmentService;
import com.teacher.system.service.JobTitleService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class JobTitleController {
    @Autowired
    JobTitleService jobTitleService;

    @PutMapping("/job-title")
    public DataVo<JobTitle> addDepartment(@RequestBody JobTitle jobTitle) {
        return jobTitleService.addJobTitle(jobTitle);
    }
    @DeleteMapping("/job-title")
    public DataVo<JobTitle> deleteDepartment(@RequestParam Integer id) {
        return jobTitleService.deleteJobTitle(id);
    }
    @PatchMapping("/job-title")
    public DataVo<JobTitle> updateDepartment(@RequestBody  JobTitle jobTitle) {
        return jobTitleService.editJobTitle(jobTitle);
    }
    @GetMapping("/job-title")
    public DataPageVo<JobTitle> getDepartment(@PageableDefault(page = 0, size = 10, sort = {"id"}, direction = Sort.Direction.ASC)
                                                        Pageable pageable) {
        return jobTitleService.getJobTitle(pageable);
    }
}
