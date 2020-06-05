package com.teacher.system.service.impl;

import com.teacher.system.domain.Department;
import com.teacher.system.repository.DepartmentRepository;
import com.teacher.system.service.DepartmentService;
import com.teacher.system.util.PropertyUtils;
import com.teacher.system.vo.DataPageVo;
import com.teacher.system.vo.DataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    /**
     * 添加部门
     * @param department
     * @return
     */
    @Override
    public DataVo<Department> addDepartment(Department department) {
        DataVo<Department> resultData = new DataVo<>();
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
            if (e.toString().indexOf("constraint") > -1) {
                resultData.setCode(2);
                resultData.setMsg("该部门已存在");
            } else {
                resultData.setCode(1);
                resultData.setMsg("创建失败");
            }
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
    public DataVo<Department> deleteDepartment(Integer id) {
        DataVo<Department> resultData = new DataVo<>();
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
    public DataVo<Department> editDepartment(Department department) {
        DataVo<Department> resultData = new DataVo<>();
        resultData.setCode(0);
        resultData.setMsg("修改成功");
        try {
            if (PropertyUtils.isNotNull(department.getId()) && PropertyUtils.isNotNull(department.getDepartmentName())) {
                departmentRepository.save(department);
            } else {
                resultData.setCode(-1);
                resultData.setMsg("参数缺省");
                return resultData;
            }
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg("修改失败");
            return resultData;
        }
        return resultData;
    }

    @Override
    public DataVo<Department> getDepartmentAll() {
        DataVo<Department> resultData = new DataVo<>();
        resultData.setCode(0);
        try {
            List<Department> resultList = departmentRepository.findAll();
            resultData.setData(resultList);
        } catch (Exception e) {
            resultData.setCode(1);
            resultData.setMsg(e.toString());
        }
        return resultData;
    }

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Override
    public DataPageVo<Department> getDepartment(Pageable pageable) {
        DataPageVo<Department> resultPage = new DataPageVo<>();
        try {
            resultPage.setCode(0);
            Page<Department> departmentPage = departmentRepository.findAll(pageable);
            resultPage.setData(departmentPage);
        } catch (Exception e) {
            resultPage.setCode(1);
            resultPage.setMsg(e.toString());
        }
        return resultPage;
    }
}
