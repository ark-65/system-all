package com.teacher.system.service;

import com.teacher.system.domain.TeacherFamilyMember;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import com.teacher.system.vo.TeacherPageVo;
import org.springframework.data.domain.Pageable;

public interface TeacherFamilyMemberService {
    public DataVo<TeacherFamilyMember> addTeacherFamilyMember(TeacherFamilyMember teacherFamilyMember);

    public DataVo<TeacherFamilyMember> deleteTeacherFamilyMember(Integer id);

    public DataVo<TeacherFamilyMember> editTeacherFamilyMember(TeacherFamilyMember teacherFamilyMember);

    public TeacherPageVo getTeacherFamilyMember(Pageable pageable);
}
