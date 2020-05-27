package com.student.system.repository;

import com.student.system.domain.CourseInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        collectionResourceRel = "course-information",
        path = "course-information",
        itemResourceRel = "course-information")
public interface CourseInformationRepository extends JpaRepository<CourseInformation, String> {
}
