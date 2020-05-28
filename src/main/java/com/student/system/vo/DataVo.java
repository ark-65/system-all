package com.student.system.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DataVo {
    private Integer code;
    private String msg;
    private Map<String, List<Object>> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, List<Object>> getData() {
        return data;
    }

    public void setData(Map<String, List<Object>> data) {
        this.data = data;
    }
}
