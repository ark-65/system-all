package com.teacher.system.service;

import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;

public interface RapRecordService {
    public DataVo addRapRecord();

    public DataVo deleteRapRecord();

    public DataVo editRapRecord();

    public DataPageVo getRapRecord();
}
