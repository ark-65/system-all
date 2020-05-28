package com.student.system.service.impl;

import com.student.system.domain.UserInfo;
import com.student.system.repository.UserInfoRepository;
import com.student.system.service.LoginService;
import com.student.system.vo.DataVo;
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
    public DataVo login(UserInfo userInfo) {
        String msg = "登录成功";
        Integer code = 0;
        String username = userInfo.getUsername();
        String password = userInfo.getPassword();
        DataVo resultData = new DataVo();

        String sql = "SELECT username FROM user_info WHERE 1=1 AND username = '" + username + "'";
        Map<String, Object> user = new HashMap<String, Object>();
        try {
            user = jdbcTemplate.queryForMap(sql);
        } catch (EmptyResultDataAccessException e) {
            msg = "用户名不存在";
            code = 1;
            resultData.setCode(code);
            resultData.setMsg(msg);
            return resultData;
        }
        sql = "SELECT username FROM user_info WHERE 1=1 AND username = '" + username + "' AND password = '" + password + "'";
        try {
            user = jdbcTemplate.queryForMap(sql);
        } catch (EmptyResultDataAccessException e) {
            msg = "密码不正确";
            code = 1;
            resultData.setCode(code);
            resultData.setMsg(msg);
            return resultData;
        }
        resultData.setCode(code);
        resultData.setMsg(msg);
//        log.info(user.toString());
        return resultData;
    }
}
