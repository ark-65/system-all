package com.student.system.repository;

import com.student.system.domain.ClassInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        collectionResourceRel = "class-information",
        path = "class-information",
        itemResourceRel = "class-information")
public interface ClassInformationRepository extends JpaRepository<ClassInformation, String> {
}
