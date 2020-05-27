package com.student.system.repository;

import com.student.system.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        collectionResourceRel = "user-info",
        path = "user-info",
        itemResourceRel = "user-info")
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    public UserInfo findAllByUsernameAndPassword(
            @Param("username") String username,
            @Param("password") String password
    );
}
