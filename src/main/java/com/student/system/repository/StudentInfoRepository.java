package com.student.system.repository;

import com.student.system.domain.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        collectionResourceRel = "student-info",
        path = "student-info",
        itemResourceRel = "student-info")
public interface StudentInfoRepository extends JpaRepository<StudentInfo, String> {
}
