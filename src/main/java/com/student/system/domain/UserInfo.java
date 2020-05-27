package com.student.system.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 用户信息表
 */
@Data
@Entity
public class UserInfo {
    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(columnDefinition="char(20) COMMENT '登录用户名'")
    private String username;
    @Column(columnDefinition="char(20) COMMENT '登录密码'", nullable=false)
    private String password;
}
