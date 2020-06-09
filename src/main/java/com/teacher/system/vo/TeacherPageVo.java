package com.teacher.system.vo;

import lombok.Data;

import java.util.Map;

@Data
public class TeacherPageVo {
    Integer code;
    String msg;
    Map<String, Object> data;
}
