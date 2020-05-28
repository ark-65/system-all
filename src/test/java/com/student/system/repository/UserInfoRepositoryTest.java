package com.student.system.repository;

import com.student.system.domain.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    void save() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("ark");
        userInfo.setPassword("123456");
        userInfoRepository.save(userInfo);
    }

}