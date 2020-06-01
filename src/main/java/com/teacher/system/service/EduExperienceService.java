package com.teacher.system.service;

import com.teacher.system.domain.EduExperienceInfo;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.data.domain.Pageable;


public interface EduExperienceService {
    public DataVo<EduExperienceInfo> addEduExperience(EduExperienceInfo eduExperienceInfo);

    public DataVo<EduExperienceInfo> deleteEduExperience(Integer id);

    public DataVo<EduExperienceInfo> editEduExperience(EduExperienceInfo eduExperienceInfo);

    public DataPageVo<EduExperienceInfo> getEduExperience(Pageable pageable);
}
