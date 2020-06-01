package com.teacher.system.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DataVo<T> {
    private Integer code;
    private String msg;
    private List<T> data;
}
