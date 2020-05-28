package com.student.system.service;

import com.student.system.domain.UserInfo;
import com.student.system.vo.DataVo;

public interface LoginService {
    public DataVo login(UserInfo userInfo);
}
