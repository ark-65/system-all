package com.teacher.system.service.impl;

import com.teacher.system.domain.EduExperienceInfo;
import com.teacher.system.repository.EduExperienceInfoRepository;
import com.teacher.system.service.EduExperienceService;
import com.teacher.system.util.PropertyUtils;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EduExperienceServiceImpl implements EduExperienceService {

    @Autowired
    EduExperienceInfoRepository eduExperienceInfoRepository;

    @Override
    public DataVo addEduExperience(EduExperienceInfo eduExperienceInfo) {
        DataVo resultData = new DataVo();
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
    public DataVo deleteEduExperience(Integer id) {
        DataVo resultData = new DataVo();
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
    public DataVo editEduExperience(EduExperienceInfo eduExperienceInfo) {
        DataVo resultData = new DataVo();
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
    public DataPageVo getEduExperience(Pageable pageable) {
        DataPageVo resultPageData = new DataPageVo();
        resultPageData.setCode(0);
        try {
            Page<EduExperienceInfo> eduExperienceInfoPage = eduExperienceInfoRepository.findAll(pageable);
            resultPageData.setData(eduExperienceInfoPage);
        } catch (Exception e) {
            resultPageData.setCode(1);
            resultPageData.setMsg(e.toString());
        }
        return resultPageData;
    }
}
