package com.teacher.system.service;

import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;

public interface TeacherFamilyMemberService {
    public DataVo addTeacherFamilyMember();

    public DataVo deleteTeacherFamilyMember();

    public DataVo editTeacherFamilyMember();

    public DataPageVo getTeacherFamilyMember();
}
