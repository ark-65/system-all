package com.teacher.system.service.impl;

import com.teacher.system.domain.Department;
import com.teacher.system.domain.Job;
import com.teacher.system.domain.JobTitle;
import com.teacher.system.domain.TeacherInfo;
import com.teacher.system.repository.DepartmentRepository;
import com.teacher.system.repository.JobRepository;
import com.teacher.system.repository.JobTitleRepository;
import com.teacher.system.repository.TeacherInfoRepository;
import com.teacher.system.service.TeacherService;
import com.teacher.system.vo.DataVo;
import com.teacher.system.vo.TeacherPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherInfoRepository teacherInfoRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    JobTitleRepository jobTitleRepository;
    @Autowired
    JobRepository jobRepository;
    @Override
    public DataVo<TeacherInfo> addTeacher(TeacherInfo teacherInfo) {
        DataVo<TeacherInfo> resultData = new DataVo<>();
        try {
            teacherInfoRepository.save(teacherInfo);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataVo<TeacherInfo> deleteTeacher(Integer id) {
        DataVo<TeacherInfo> resultData = new DataVo<>();
        try {
            teacherInfoRepository.deleteById(id);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataVo<TeacherInfo> editTeacher(TeacherInfo teacherInfo) {
        DataVo<TeacherInfo> resultData = new DataVo<>();
        try {
            teacherInfoRepository.save(teacherInfo);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public TeacherPageVo getTeacher(Pageable pageable) {
        TeacherPageVo resultData = new TeacherPageVo();
        try {
            Map<String, Object> resultMap = new HashMap<>();
            List<Department> departmentList = departmentRepository.findAll();
            List<JobTitle> jobTitleList = jobTitleRepository.findAll();
            List<Job> jobList = jobRepository.findAll();
            Page<TeacherInfo> teacherInfoPage = teacherInfoRepository.findAll(pageable);
            resultMap.put("department", departmentList);
            resultMap.put("jobTitle", jobTitleList);
            resultMap.put("job", jobList);
            resultMap.put("teacherPage", teacherInfoPage);
            resultData.setData(resultMap);
            resultData.setCode(0);

        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg("查询失败");
        }
        return resultData;
    }
}
