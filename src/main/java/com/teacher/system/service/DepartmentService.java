package com.teacher.system.service;

import com.teacher.system.domain.Department;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {

    public DataVo addDepartment(Department department);

    public DataVo deleteDepartment(Integer id);

    public DataVo editDepartment(Department department);

    public DataVo getDepartmentAll();

    public DataPageVo getDepartment(Pageable pageable);
}
