package com.teacher.system.service;

import com.teacher.system.domain.JobTitle;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.data.domain.Pageable;

public interface JobTitleService {
    public DataVo<JobTitle> addJobTitle(JobTitle jobTitle);

    public DataVo<JobTitle> deleteJobTitle(Integer id);

    public DataVo<JobTitle> editJobTitle(JobTitle jobTitle);

    public DataPageVo<JobTitle> getJobTitle(Pageable pageable);
}
