package com.student.system.repository;

import com.student.system.domain.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        collectionResourceRel = "class-info",
        path = "class-info",
        itemResourceRel = "class-info")
public interface ClassInfoRepository extends JpaRepository<ClassInfo, String> {
}
