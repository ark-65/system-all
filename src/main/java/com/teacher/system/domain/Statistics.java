package com.teacher.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;

/**
 * $@NamedStoredProcedureQuery 申明一个存储过程
 * name属性是给这个存储结构起一个名字
 * procedureName属性是存储结构在数据库中的名字
 * resultClasses属性声明这个存储过程返回的结果集的类型
 * parameters属性声明这个存储结构的参数
 */
@Entity
@NamedStoredProcedureQuery(name = "StatiticsAll", procedureName = "StatiticsAll", resultClasses = {Statistics.class})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
    @Id
    Integer id;
    Integer deptId;
    Integer jobtId;
    String deptName;
    String jobtName;
    Integer deptNum;
    Integer jobtNum;
}
