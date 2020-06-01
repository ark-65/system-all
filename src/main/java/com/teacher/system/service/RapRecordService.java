package com.teacher.system.service;

import com.teacher.system.domain.RapRecord;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.data.domain.Pageable;

public interface RapRecordService {
    public DataVo<RapRecord> addRapRecord(RapRecord rapRecord);

    public DataVo<RapRecord> deleteRapRecord(Integer id);

    public DataVo<RapRecord> editRapRecord(RapRecord rapRecord);

    public DataPageVo<RapRecord> getRapRecord(Pageable pageable);
}
