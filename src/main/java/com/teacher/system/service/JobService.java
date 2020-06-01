package com.teacher.system.service;

import com.teacher.system.domain.Job;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.data.domain.Pageable;

public interface JobService {
    public DataVo<Job> addJob(Job job);

    public DataVo<Job> deleteJob(Integer id);

    public DataVo<Job> editJob(Job job);

    public DataPageVo<Job> getJobs(Pageable pageable);
}
