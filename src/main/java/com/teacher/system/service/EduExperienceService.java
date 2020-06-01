package com.teacher.system.service;

import com.teacher.system.domain.EduExperienceInfo;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.data.domain.Pageable;


public interface EduExperienceService {
    public DataVo addEduExperience(EduExperienceInfo eduExperienceInfo);

    public DataVo deleteEduExperience(Integer id);

    public DataVo editEduExperience(EduExperienceInfo eduExperienceInfo);

    public DataPageVo getEduExperience(Pageable pageable);
}
