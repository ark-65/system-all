package com.teacher.system.service.impl;

import com.teacher.system.domain.RapRecord;
import com.teacher.system.domain.TeacherFamilyMember;
import com.teacher.system.domain.TeacherInfo;
import com.teacher.system.repository.RapRecordRepository;
import com.teacher.system.repository.TeacherInfoRepository;
import com.teacher.system.service.RapRecordService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import com.teacher.system.vo.TeacherPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RapRecordServiceImpl implements RapRecordService {
    @Autowired
    RapRecordRepository rapRecordRepository;
    @Autowired
    TeacherInfoRepository teacherInfoRepository;
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
    public TeacherPageVo getRapRecord(Pageable pageable) {

        TeacherPageVo resultPageData = new TeacherPageVo();

        resultPageData.setCode(0);
        try {
            Map<String, Object> resultMap = new HashMap<>();
            Page<RapRecord> rapRecordPage = rapRecordRepository.findAll(pageable);
            List<TeacherInfo> teacherInfoList = teacherInfoRepository.findAll();
            resultMap.put("rapRecordPage", rapRecordPage);
            resultMap.put("teachers", teacherInfoList);
            resultPageData.setData(resultMap);
        } catch (Exception e) {
            resultPageData.setCode(1);
            resultPageData.setMsg("查询失败");
        }
        return resultPageData;
    }
}
