package com.teacher.system.repository;

import com.teacher.system.domain.TeacherFamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherFamilyMemberRepository extends JpaRepository<TeacherFamilyMember, Integer> {
}
