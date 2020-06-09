package com.teacher.system.repository;

import com.teacher.system.domain.TeacherFamilyMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherFamilyMemberRepository extends JpaRepository<TeacherFamilyMember, Integer> {
    @Override
    Page<TeacherFamilyMember> findAll(Pageable pageable);
}
