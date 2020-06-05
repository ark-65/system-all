package com.teacher.system.service.impl;

import com.teacher.system.domain.RapRecord;
import com.teacher.system.domain.TeacherFamilyMember;
import com.teacher.system.repository.TeacherFamilyMemberRepository;
import com.teacher.system.service.TeacherFamilyMemberService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherFamilyMemberServiceImpl implements TeacherFamilyMemberService {

    @Autowired
    TeacherFamilyMemberRepository teacherFamilyMemberRepository;

    @Override
    public DataVo<TeacherFamilyMember> addTeacherFamilyMember(TeacherFamilyMember teacherFamilyMember) {
        DataVo<TeacherFamilyMember> resultData = new DataVo<>();
        try {
            teacherFamilyMemberRepository.save(teacherFamilyMember);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataVo<TeacherFamilyMember> deleteTeacherFamilyMember(Integer id) {
        DataVo<TeacherFamilyMember> resultData = new DataVo<>();
        try {
            teacherFamilyMemberRepository.deleteById(id);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataVo<TeacherFamilyMember> editTeacherFamilyMember(TeacherFamilyMember teacherFamilyMember) {
        DataVo<TeacherFamilyMember> resultData = new DataVo<>();
        try {
            teacherFamilyMemberRepository.save(teacherFamilyMember);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataPageVo<TeacherFamilyMember> getTeacherFamilyMember(Pageable pageable) {
        return null;
    }
}
