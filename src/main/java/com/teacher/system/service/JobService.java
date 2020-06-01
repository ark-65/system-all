package com.teacher.system.service;

import com.teacher.system.domain.Job;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.data.domain.Pageable;

public interface JobService {
    public DataVo addJob(Job job);

    public DataVo deleteJob(Integer id);

    public DataVo editJob(Job job);

    public DataPageVo getJobs(Pageable pageable);
}
