package com.teacher.system.vo;

import lombok.Data;

import java.util.Map;

@Data
public class DataPageVo {
    private Integer code;
    private String msg;
    private Map<String, Object> data;
}
