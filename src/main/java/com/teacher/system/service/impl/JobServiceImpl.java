package com.teacher.system.service.impl;

import com.teacher.system.domain.Job;
import com.teacher.system.repository.JobRepository;
import com.teacher.system.service.JobService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;
    @Override
    public DataVo addJob(Job job) {
        DataVo resultData = new DataVo();
        resultData.setCode(0);
        try {
            jobRepository.save(job);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataVo deleteJob(Integer id) {
        DataVo resultData = new DataVo();
        resultData.setCode(0);
        try {
            jobRepository.deleteById(id);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataVo editJob(Job job) {
        DataVo resultData = new DataVo();
        resultData.setCode(0);
        try {

        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataPageVo getJobs(Pageable pageable) {
        DataPageVo resultData = new DataPageVo();
        resultData.setCode(0);
        try {
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }
}
