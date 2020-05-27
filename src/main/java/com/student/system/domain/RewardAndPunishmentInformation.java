package com.student.system.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 奖惩信息表
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class RewardAndPunishmentInformation {

    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(columnDefinition="char(10) COMMENT '奖惩信息的编号'")
    private String rewardAndPunishmentId;
    @Column(columnDefinition="char(10) COMMENT '受奖惩学生学号'", nullable=false)
    private String studentId;
    @Column(columnDefinition="char(2) COMMENT '奖惩信息的类型'", nullable=false)
    private String rewardType;
    @Column(columnDefinition="char(100) COMMENT '奖惩信息的内容'", nullable=false)
    private String rewardAndPunishmentContent;
    @Column(columnDefinition="date COMMENT '奖惩创建时间'", nullable=false)
    private Date createTime;
}
