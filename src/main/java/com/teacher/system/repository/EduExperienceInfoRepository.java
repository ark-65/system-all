package com.teacher.system.repository;

import com.teacher.system.domain.EduExperienceInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EduExperienceInfoRepository extends JpaRepository<EduExperienceInfo, Integer> {
    @Override
    Page<EduExperienceInfo> findAll(Pageable pageable);
}
