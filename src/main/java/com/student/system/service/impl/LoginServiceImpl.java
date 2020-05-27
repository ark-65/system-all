package com.student.system.service.impl;

import com.student.system.domain.UserInfo;
import com.student.system.repository.UserInfoRepository;
import com.student.system.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public String login(UserInfo userInfo) {
        String status = "登录成功";
        String username = userInfo.getUsername();
        String password = userInfo.getPassword();
        String sql = "SELECT username FROM user_info WHERE 1=1 AND username = '" + username + "'";
        Map<String, Object> user = new HashMap<String, Object>();
        try {
            user = jdbcTemplate.queryForMap(sql);
        } catch (EmptyResultDataAccessException e) {
            status = "用户名不存在";
            return status;
        }
        sql = "SELECT username FROM user_info WHERE 1=1 AND username = '" + username + "' AND password = '" + password + "'";
        try {
            user = jdbcTemplate.queryForMap(sql);
        } catch (EmptyResultDataAccessException e) {
            status = "密码不正确";
            return status;
        }
        log.info(user.toString());
        return status;
    }
}
