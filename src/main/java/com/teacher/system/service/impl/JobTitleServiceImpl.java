package com.teacher.system.service.impl;

import com.teacher.system.domain.Department;
import com.teacher.system.domain.JobTitle;
import com.teacher.system.repository.JobTitleRepository;
import com.teacher.system.service.JobTitleService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
            if (e.toString().indexOf("constraint") > -1) {
                resultData.setCode(2);
                resultData.setMsg("该职称已存在");
            } else {
                resultData.setCode(1);
                resultData.setMsg("创建失败");
            }
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
        DataPageVo<JobTitle> resultPage = new DataPageVo<>();
        try {
            resultPage.setCode(0);
            Page<JobTitle> jobTitlePage = jobTitleRepository.findAll(pageable);
            resultPage.setData(jobTitlePage);
        } catch (Exception e) {
            resultPage.setCode(1);
            resultPage.setMsg(e.toString());
        }
        return resultPage;
    }
}
