package com.teacher.system.service.impl;

import com.teacher.system.domain.EduExperienceInfo;
import com.teacher.system.domain.TeacherInfo;
import com.teacher.system.repository.EduExperienceInfoRepository;
import com.teacher.system.repository.TeacherInfoRepository;
import com.teacher.system.service.EduExperienceService;
import com.teacher.system.util.PropertyUtils;
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
public class EduExperienceServiceImpl implements EduExperienceService {

    @Autowired
    EduExperienceInfoRepository eduExperienceInfoRepository;
    @Autowired
    TeacherInfoRepository teacherInfoRepository;

    @Override
    public DataVo<EduExperienceInfo> addEduExperience(EduExperienceInfo eduExperienceInfo) {
        DataVo<EduExperienceInfo> resultData = new DataVo<>();
        resultData.setCode(0);
        resultData.setMsg("");
        try {
            // 增加一个教育经历重名验证   学校名称和 teacherid
            eduExperienceInfoRepository.save(eduExperienceInfo);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataVo<EduExperienceInfo> deleteEduExperience(Integer id) {
        DataVo<EduExperienceInfo> resultData = new DataVo<>();
        resultData.setCode(0);
        try {
            if (PropertyUtils.isNotNull(id)) {
                eduExperienceInfoRepository.deleteById(id);
            }
        } catch (NullPointerException e) {
            resultData.setCode(-1);
            resultData.setMsg("没有找到该id");
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }

        return resultData;
    }

    @Override
    public DataVo<EduExperienceInfo> editEduExperience(EduExperienceInfo eduExperienceInfo) {
        DataVo<EduExperienceInfo> resultData = new DataVo<>();
        resultData.setCode(0);
        resultData.setMsg("");
        try {
            // 需要提前查库是否有这个id
            eduExperienceInfoRepository.save(eduExperienceInfo);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public TeacherPageVo getEduExperience(Pageable pageable) {
        TeacherPageVo resultPageData = new TeacherPageVo();

        resultPageData.setCode(0);
        try {
            Map<String, Object> resultMap = new HashMap<>();
            Page<EduExperienceInfo> eduExperienceInfoPage = eduExperienceInfoRepository.findAll(pageable);
            List<TeacherInfo> teacherInfoList = teacherInfoRepository.findAll();
            resultMap.put("eduPage", eduExperienceInfoPage);
            resultMap.put("teachers", teacherInfoList);
            resultPageData.setData(resultMap);
        } catch (Exception e) {
            resultPageData.setCode(1);
            resultPageData.setMsg("查询失败");
        }
        return resultPageData;
    }
}
