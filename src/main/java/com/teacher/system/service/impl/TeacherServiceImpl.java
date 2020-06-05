package com.teacher.system.service.impl;

import com.teacher.system.domain.JobTitle;
import com.teacher.system.domain.TeacherInfo;
import com.teacher.system.repository.TeacherInfoRepository;
import com.teacher.system.service.TeacherService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherInfoRepository teacherInfoRepository;
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
    public DataPageVo<TeacherInfo> getTeacher(Pageable pageable) {
        return null;
    }
}
