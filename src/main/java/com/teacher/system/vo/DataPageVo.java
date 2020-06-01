package com.teacher.system.vo;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Map;

@Data
public class DataPageVo<T> {
    private Integer code;
    private String msg;
    private Page<T> data;
}
