package com.teacher.system.service.impl;

import com.teacher.system.domain.RapRecord;
import com.teacher.system.domain.TeacherInfo;
import com.teacher.system.repository.RapRecordRepository;
import com.teacher.system.service.RapRecordService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

public class RapRecordServiceImpl implements RapRecordService {
    @Autowired
    RapRecordRepository rapRecordRepository;
    @Override
    public DataVo<RapRecord> addRapRecord(RapRecord rapRecord) {
        DataVo<RapRecord> resultData = new DataVo<>();
        try {
            rapRecordRepository.save(rapRecord);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataVo<RapRecord> deleteRapRecord(Integer id) {
        DataVo<RapRecord> resultData = new DataVo<>();
        try {
            rapRecordRepository.deleteById(id);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataVo<RapRecord> editRapRecord(RapRecord rapRecord) {
        DataVo<RapRecord> resultData = new DataVo<>();
        try {
            rapRecordRepository.save(rapRecord);
            resultData.setCode(0);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    @Override
    public DataPageVo<RapRecord> getRapRecord(Pageable pageable) {
        return null;
    }
}
