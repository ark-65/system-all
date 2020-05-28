package com.student.system.controller;

import com.student.system.domain.UserInfo;
import com.student.system.service.LoginService;
import com.student.system.vo.DataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @Autowired
    LoginService loginService;

    @PostMapping("/user/login")
    public DataVo login(@RequestBody UserInfo userInfo) {
//        log.info(userInfo.toString());
        return loginService.login(userInfo);
    }
}
