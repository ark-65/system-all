package com.teacher.system.service;

import com.teacher.system.domain.Department;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {

    public DataVo<Department> addDepartment(Department department);

    public DataVo<Department> deleteDepartment(Integer id);

    public DataVo<Department> editDepartment(Department department);

    public DataVo<Department> getDepartmentAll();

    public DataPageVo<Department> getDepartment(Pageable pageable);
}
