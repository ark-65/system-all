package com.teacher.system.service.impl;

import com.teacher.system.domain.UserMember;
import com.teacher.system.repository.UserMemberRepository;
import com.teacher.system.service.UserService;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public DataVo<Object> login(UserMember userMember) {
        String msg = "登录成功";
        int code = 0;
        String username = userMember.getUsername();
        String password = userMember.getPassword();
        DataVo<Object> resultData = new DataVo<>();

        String sql = "SELECT username FROM user_member WHERE 1=1 AND username = '" + username + "'";
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
        sql = "SELECT username FROM user_member WHERE 1=1 AND username = '" + username + "' AND password = '" + password + "'";
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
        return resultData;
    }
}
