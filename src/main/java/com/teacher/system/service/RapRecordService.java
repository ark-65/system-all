package com.teacher.system.service;

import com.teacher.system.domain.RapRecord;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import com.teacher.system.vo.TeacherPageVo;
import org.springframework.data.domain.Pageable;

public interface RapRecordService {
    public DataVo<RapRecord> addRapRecord(RapRecord rapRecord);

    public DataVo<RapRecord> deleteRapRecord(Integer id);

    public DataVo<RapRecord> editRapRecord(RapRecord rapRecord);

    public TeacherPageVo getRapRecord(Pageable pageable);
}
