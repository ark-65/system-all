package com.teacher.system.repository;

import com.teacher.system.domain.UserMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMemberRepository extends JpaRepository<UserMember, Integer> {
}
