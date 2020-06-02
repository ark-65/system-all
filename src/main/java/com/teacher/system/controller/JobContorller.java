package com.teacher.system.controller;

import com.teacher.system.domain.Job;
import com.teacher.system.domain.JobTitle;
import com.teacher.system.repository.JobRepository;
import com.teacher.system.service.JobService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class JobContorller {

    @Autowired
    JobService jobService;

    @PutMapping("/job")
    public DataVo<Job> addDepartment(@RequestBody Job job) {
        return jobService.addJob(job);
    }
    @DeleteMapping("/job")
    public DataVo<Job> deleteDepartment(@RequestParam Integer id) {
        return jobService.deleteJob(id);
    }
    @PatchMapping("/job")
    public DataVo<Job> updateDepartment(@RequestBody  Job job) {
        return jobService.editJob(job);
    }
    @GetMapping("/job")
    public DataPageVo<Job> getDepartment(@PageableDefault(page = 0, size = 10, sort = {"id"}, direction = Sort.Direction.ASC)
                                                      Pageable pageable) {
        return jobService.getJobs(pageable);
    }
}
