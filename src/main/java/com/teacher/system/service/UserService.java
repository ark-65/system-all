package com.teacher.system.service;

import com.teacher.system.domain.UserMember;
import com.teacher.system.vo.DataVo;

public interface UserService {
    public DataVo login(UserMember userMember);
}
