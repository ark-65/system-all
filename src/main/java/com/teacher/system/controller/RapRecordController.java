package com.teacher.system.controller;

import com.teacher.system.domain.RapRecord;
import com.teacher.system.service.RapRecordService;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import com.teacher.system.vo.TeacherPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class RapRecordController {
    @Autowired
    RapRecordService rapRecordService;

    @PutMapping("/rap-record")
    public DataVo<RapRecord> addDepartment(@RequestBody RapRecord rapRecord) {
        return rapRecordService.addRapRecord(rapRecord);
    }
    @DeleteMapping("/rap-record")
    public DataVo<RapRecord> deleteDepartment(@RequestParam Integer id) {
        return rapRecordService.deleteRapRecord(id);
    }
    @PatchMapping("/rap-record")
    public DataVo<RapRecord> updateDepartment(@RequestBody  RapRecord rapRecord) {
        return rapRecordService.editRapRecord(rapRecord);
    }
    @GetMapping("/rap-record")
    public TeacherPageVo getDepartment(@PageableDefault(page = 0, size = 10, sort = {"teacher_id"}, direction = Sort.Direction.ASC)
                                                                 Pageable pageable) {
        return rapRecordService.getRapRecord(pageable);
    }
}
