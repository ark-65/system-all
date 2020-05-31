package com.teacher.system.service.impl;

import com.teacher.system.domain.Department;
import com.teacher.system.repository.DepartmentRepository;
import com.teacher.system.service.DepartmentService;
import com.teacher.system.util.PropertyUtils;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * 添加部门
     * @param department
     * @return
     */
    @Override
    public DataVo addDepartment(Department department) {
        DataVo resultData = new DataVo();
        resultData.setCode(0);
        resultData.setMsg("创建成功");
        try {
            if (PropertyUtils.isNotNull(department.getDepartmentName())) {
                departmentRepository.save(department);
            } else {
                resultData.setCode(-1);
                resultData.setMsg("部门名称不能为空");
                return resultData;
            }
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg("创建失败");
            return resultData;
        }
        return resultData;
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @Override
    public DataVo deleteDepartment(Integer id) {
        DataVo resultData = new DataVo();
        resultData.setCode(0);
        resultData.setMsg("删除成功");
        try {
            departmentRepository.deleteById(id);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg("删除失败");
            return resultData;
        }
        return resultData;
    }

    /**
     * 更改部门名称
     * @param department
     * @return
     */
    @Override
    public DataVo patchDepartment(Department department) {
        DataVo resultData = new DataVo();
        resultData.setCode(0);
        resultData.setMsg("修改成功");
        try {
            if (PropertyUtils.isNotNull(department.getId()) && PropertyUtils.isNotNull(department.getDepartmentName()) && PropertyUtils.isNull(department.getNum())) {
                departmentRepository.save(department);
            }
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg("修改失败");
            return resultData;
        }
        return resultData;
    }

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Override
    public DataPageVo getDepartment(Pageable pageable) {
        DataPageVo resultPage = new DataPageVo();
        resultPage.setCode(0);
        resultPage.setMsg("");
        Page<Department> departmentPage = departmentRepository.findAll(pageable);
        return resultPage;
    }
}
