package com.teacher.system.service.impl;

import com.teacher.system.domain.EduExperienceInfo;
import com.teacher.system.domain.RapRecord;
import com.teacher.system.domain.TeacherFamilyMember;
import com.teacher.system.domain.TeacherInfo;
import com.teacher.system.repository.TeacherFamilyMemberRepository;
import com.teacher.system.repository.TeacherInfoRepository;
import com.teacher.system.service.TeacherFamilyMemberService;
import com.teacher.system.vo.DataPageVo;
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
public class TeacherFamilyMemberServiceImpl implements TeacherFamilyMemberService {

    @Autowired
    TeacherFamilyMemberRepository teacherFamilyMemberRepository;
    @Autowired
    TeacherInfoRepository teacherInfoRepository;

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
    public TeacherPageVo getTeacherFamilyMember(Pageable pageable) {
        TeacherPageVo resultPageData = new TeacherPageVo();

        resultPageData.setCode(0);
        try {
            Map<String, Object> resultMap = new HashMap<>();
            Page<TeacherFamilyMember> teacherFamilyMemberPage = teacherFamilyMemberRepository.findAll(pageable);
            List<TeacherInfo> teacherInfoList = teacherInfoRepository.findAll();
            resultMap.put("familyPage", teacherFamilyMemberPage);
            resultMap.put("teachers", teacherInfoList);
            resultPageData.setData(resultMap);
        } catch (Exception e) {
            resultPageData.setCode(1);
            resultPageData.setMsg("查询失败");
        }
        return resultPageData;
    }
}
