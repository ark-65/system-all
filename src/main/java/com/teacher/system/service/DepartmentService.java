package com.teacher.system.service;

import com.teacher.system.domain.Department;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {
    /**
     * 用 put
     * @param department
     * @return
     */
    public DataVo addDepartment(Department department);

    public DataVo deleteDepartment(Integer id);

    /**
     * 用patch
     * @param department
     * @return
     */
    public DataVo patchDepartment(Department department);

    /**
     *
     */
    public DataPageVo getDepartment(Pageable pageable);
}
