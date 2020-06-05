package com.teacher.system.service;

import com.teacher.system.domain.TeacherInfo;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    public DataVo<TeacherInfo> addTeacher(TeacherInfo teacherInfo);

    public DataVo<TeacherInfo> deleteTeacher(Integer id);

    public DataVo<TeacherInfo> editTeacher(TeacherInfo teacherInfo);

    public DataPageVo<TeacherInfo> getTeacher(Pageable pageable);
}
