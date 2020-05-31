package com.teacher.system.controller;

import com.teacher.system.domain.UserMember;
import com.teacher.system.service.UserService;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1//user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public DataVo login(@RequestBody UserMember userMember) {
        return userService.login(userMember);
    }

}
