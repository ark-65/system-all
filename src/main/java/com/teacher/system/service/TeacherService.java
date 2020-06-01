package com.teacher.system.service;

import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;

public interface TeacherService {
    public DataVo addTeacher();

    public DataVo deleteTeacher();

    public DataVo editTeacher();

    public DataPageVo getTeacher();
}
