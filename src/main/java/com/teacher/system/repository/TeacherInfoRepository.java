package com.teacher.system.repository;

import com.teacher.system.domain.TeacherInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherInfoRepository extends JpaRepository<TeacherInfo, Integer> {
}
