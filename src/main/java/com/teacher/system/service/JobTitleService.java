package com.teacher.system.service;

import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;

public interface JobTitleService {
    public DataVo addJobTitle();

    public DataVo deleteJobTitle();

    public DataVo editJobTitle();

    public DataPageVo getJobTitle();
}
