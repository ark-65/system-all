package com.teacher.system.service.impl;

import com.teacher.system.domain.JobTitle;
import com.teacher.system.repository.JobTitleRepository;
import com.teacher.system.service.JobTitleService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobTitleServiceImpl implements JobTitleService {

    @Autowired
    JobTitleRepository jobTitleRepository;

    @Override
    public DataVo<JobTitle> addJobTitle(JobTitle jobTitle) {
        DataVo<JobTitle> resultData = new DataVo<>();
        try {
            jobTitleRepository.save(jobTitle);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataVo<JobTitle> deleteJobTitle(Integer id) {
        DataVo<JobTitle> resultData = new DataVo<>();
        try {
            jobTitleRepository.deleteById(id);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataVo<JobTitle> editJobTitle(JobTitle jobTitle) {
        DataVo<JobTitle> resultData = new DataVo<>();
        try {
            jobTitleRepository.save(jobTitle);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataPageVo<JobTitle> getJobTitle(Pageable pageable) {
        return null;
    }
}
