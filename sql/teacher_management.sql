/*
 Navicat Premium Data Transfer

 Source Server         : MySQL5.7
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Schema         : teacher_management

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 10/06/2020 00:09:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
                              `department_name` varchar(255) NOT NULL COMMENT '部门名称',
                              `num` int(11) unsigned DEFAULT '0' COMMENT '人数',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY ```department_name``` (`department_name`) USING BTREE,
                              KEY `id` (`id`,`department_name`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='部门';

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES (0, '天人道', 2);
INSERT INTO `department` VALUES (1, '人道', 0);
INSERT INTO `department` VALUES (2, '畜生道', 0);
INSERT INTO `department` VALUES (3, '修罗道', 0);
INSERT INTO `department` VALUES (4, '饿鬼道', 0);
INSERT INTO `department` VALUES (5, '地狱道1', 0);
INSERT INTO `department` VALUES (6, '啦啦道', 0);
INSERT INTO `department` VALUES (7, '咕咕道', 0);
INSERT INTO `department` VALUES (8, '66道', 0);
INSERT INTO `department` VALUES (9, '渣渣道', 0);
INSERT INTO `department` VALUES (30, 'fdsa', 0);
COMMIT;

-- ----------------------------
-- Table structure for edu_experience_info
-- ----------------------------
DROP TABLE IF EXISTS `edu_experience_info`;
CREATE TABLE `edu_experience_info` (
                                       `id` int(11) NOT NULL AUTO_INCREMENT,
                                       `start_time` char(11) NOT NULL COMMENT '开始时间',
                                       `end_time` char(11) NOT NULL COMMENT '结束时间',
                                       `school_name` varchar(255) NOT NULL COMMENT '学校名称',
                                       `education` varchar(255) NOT NULL COMMENT '学历',
                                       `teacher_id` int(11) NOT NULL,
                                       `edu_type` varchar(255) NOT NULL COMMENT '学历类型 1.博士 2.硕士 3.本科 4.大专 5.高中 6.中专 7.初中 8.小学 9.没上过学',
                                       PRIMARY KEY (`id`),
                                       KEY `teacher_name_fk2` (`teacher_id`),
                                       CONSTRAINT `teacher_name_fk2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='教育经历';

-- ----------------------------
-- Records of edu_experience_info
-- ----------------------------
BEGIN;
INSERT INTO `edu_experience_info` VALUES (3, '2020-06-09', '2020-06-09', '麻省理工附属中学', '初中', 28, '初中');
INSERT INTO `edu_experience_info` VALUES (4, '2020-06-09', '2020-06-09', '剑桥附属小学', '高中', 29, '高中');
COMMIT;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
BEGIN;
INSERT INTO `hibernate_sequence` VALUES (2);
COMMIT;

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
                       `id` int(11) NOT NULL AUTO_INCREMENT,
                       `job_name` varchar(255) DEFAULT NULL COMMENT '职务名称',
                       `num` int(11) DEFAULT NULL COMMENT '人数',
                       PRIMARY KEY (`id`),
                       UNIQUE KEY `job_name` (`job_name`) USING BTREE,
                       KEY `id` (`id`,`job_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='职务\n教师：（正、副）院长、（正、副)（院、系)书记、（正、副）科长、（正、副）（院、系)主任、公共教 育部老师、辅导员、班主任、（语文、数学、英语、化学、物理、政治、历史、地理、生物、体育、美术、音乐、计算机）老师';

-- ----------------------------
-- Records of job
-- ----------------------------
BEGIN;
INSERT INTO `job` VALUES (1, '正院长', 1);
INSERT INTO `job` VALUES (2, '副院长', 0);
INSERT INTO `job` VALUES (3, '正系书记', 0);
INSERT INTO `job` VALUES (4, '副系书记', 0);
INSERT INTO `job` VALUES (5, '正科长', 0);
INSERT INTO `job` VALUES (6, '副科长', 1);
COMMIT;

-- ----------------------------
-- Table structure for job_title
-- ----------------------------
DROP TABLE IF EXISTS `job_title`;
CREATE TABLE `job_title` (
                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
                             `job_title_name` varchar(255) NOT NULL COMMENT '职称名字',
                             `num` int(11) DEFAULT '0' COMMENT '人数',
                             PRIMARY KEY (`id`),
                             KEY `id` (`id`,`job_title_name`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='职称\n一级教授\n二级教授\n三级教授\n四级教授\n五六七级副教授\n八九十级讲师\n十一十二十三级助教';

-- ----------------------------
-- Records of job_title
-- ----------------------------
BEGIN;
INSERT INTO `job_title` VALUES (9, '一级教授', 1);
INSERT INTO `job_title` VALUES (10, '二级教授', 0);
INSERT INTO `job_title` VALUES (11, '三级教授', 0);
INSERT INTO `job_title` VALUES (12, '四级教授', 0);
INSERT INTO `job_title` VALUES (13, '五级副教授', 0);
INSERT INTO `job_title` VALUES (14, '六级副教授', 0);
INSERT INTO `job_title` VALUES (15, '七级副教授', 0);
INSERT INTO `job_title` VALUES (16, '八级讲师', 0);
INSERT INTO `job_title` VALUES (17, '九级讲师', 0);
INSERT INTO `job_title` VALUES (18, '十级讲师', 0);
INSERT INTO `job_title` VALUES (19, '十一级助教', 0);
INSERT INTO `job_title` VALUES (20, '十二级助教', 0);
INSERT INTO `job_title` VALUES (21, '十三级助教', 1);
COMMIT;

-- ----------------------------
-- Table structure for rap_record
-- ----------------------------
DROP TABLE IF EXISTS `rap_record`;
CREATE TABLE `rap_record` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `teacher_id` int(11) DEFAULT NULL,
                              `rap_type` varchar(255) DEFAULT NULL COMMENT '奖惩类型',
                              `remarks` varchar(255) DEFAULT NULL COMMENT '奖惩备注',
                              `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
                              PRIMARY KEY (`id`),
                              KEY `teacher_name_fk` (`teacher_id`),
                              CONSTRAINT `teacher_name_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='奖惩记录\n';

-- ----------------------------
-- Records of rap_record
-- ----------------------------
BEGIN;
INSERT INTO `rap_record` VALUES (3, 28, '奖励', '拾金不昧,为了失主丢失的2毛钱在十字路口苦等三天三夜', '2020-02-01');
INSERT INTO `rap_record` VALUES (4, 28, '奖励', '范德萨范德萨范德萨 发生', '2020-06-10');
INSERT INTO `rap_record` VALUES (5, 29, '惩罚', '抢学生的棒棒糖', '2020-06-10');
COMMIT;

-- ----------------------------
-- Table structure for statistics
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics` (
                              `id` int(11) NOT NULL,
                              `dept_id` int(11) DEFAULT NULL,
                              `dept_name` varchar(255) DEFAULT NULL,
                              `dept_num` int(11) DEFAULT NULL,
                              `jobt_id` int(11) DEFAULT NULL,
                              `jobt_name` varchar(255) DEFAULT NULL,
                              `jobt_num` int(11) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher_family_member
-- ----------------------------
DROP TABLE IF EXISTS `teacher_family_member`;
CREATE TABLE `teacher_family_member` (
                                         `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                                         `teacher_id` int(11) NOT NULL,
                                         `relationship` varchar(255) DEFAULT NULL COMMENT '与教师关系',
                                         `member_name` varchar(255) DEFAULT NULL COMMENT '家庭成员姓名',
                                         `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
                                         PRIMARY KEY (`id`),
                                         KEY `teacher_name_fkteacher_name_fk3` (`teacher_id`),
                                         CONSTRAINT `teacher_name_fkteacher_name_fk3` FOREIGN KEY (`teacher_id`) REFERENCES `teacher_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='家庭关系';

-- ----------------------------
-- Records of teacher_family_member
-- ----------------------------
BEGIN;
INSERT INTO `teacher_family_member` VALUES (1, 28, '父亲', '张大壮', '13333333333');
INSERT INTO `teacher_family_member` VALUES (2, 28, '母亲', '王钢蛋', '13333333333');
INSERT INTO `teacher_family_member` VALUES (3, 29, 'fff', 'fff', '13333333333');
COMMIT;

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `dept_id` int(11) DEFAULT NULL COMMENT '所在部门',
                                `job_title_id` int(11) DEFAULT NULL COMMENT '所属职称',
                                `job_id` int(11) DEFAULT NULL COMMENT '所属职务',
                                `teacher_name` varchar(255) NOT NULL COMMENT '教师名称',
                                `e_mail` varchar(255) DEFAULT NULL COMMENT '电子邮件',
                                `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
                                PRIMARY KEY (`id`),
                                KEY `teacher_info_ibfk_1` (`dept_id`),
                                KEY `teacher_info_ibfk_2` (`job_title_id`),
                                KEY `teacher_info_ibfk_3` (`job_id`),
                                CONSTRAINT `teacher_info_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
                                CONSTRAINT `teacher_info_ibfk_2` FOREIGN KEY (`job_title_id`) REFERENCES `job_title` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
                                CONSTRAINT `teacher_info_ibfk_3` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='教师信息';

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
BEGIN;
INSERT INTO `teacher_info` VALUES (28, 0, 9, 1, '伊泽瑞尔', '2333@qq.com', '13333333333');
INSERT INTO `teacher_info` VALUES (29, 0, 21, 6, '钱闷闷', 'qianmenmen@163.com', '13333333333');
COMMIT;

-- ----------------------------
-- Table structure for user_member
-- ----------------------------
DROP TABLE IF EXISTS `user_member`;
CREATE TABLE `user_member` (
                               `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                               `username` varchar(255) NOT NULL COMMENT '用户名',
                               `password` varchar(255) NOT NULL COMMENT '密码',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_member
-- ----------------------------
BEGIN;
INSERT INTO `user_member` VALUES (1, 'ark', '123456');
COMMIT;

-- ----------------------------
-- Function structure for fn_test
-- ----------------------------
DROP FUNCTION IF EXISTS `fn_test`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `fn_test`() RETURNS int(10)
BEGIN
    DECLARE a INT(10);
    SET a = 2;
    RETURN a;
END;
;;
delimiter ;

-- ----------------------------
-- Procedure structure for StatiticsAll
-- ----------------------------
DROP PROCEDURE IF EXISTS `StatiticsAll`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `StatiticsAll`()
BEGIN
    -- 定义变量
    DECLARE done INT DEFAULT 0;
    DECLARE deptId INT(11);
    DECLARE jobtId INT(11);
    DECLARE deptName VARCHAR(255);
    DECLARE jobtName VARCHAR(255);
    DECLARE deptNum INT(11);
    DECLARE jobtNum INT(11);
    DECLARE statisNum INT(11);
-- 定义游标
    DECLARE deptCursor CURSOR FOR(SELECT * FROM department);
    DECLARE jobtCursor CURSOR FOR(SELECT id, job_title_name FROM job_title);
-- 定义 HANDLER
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    CREATE TEMPORARY TABLE IF NOT EXISTS statisticsTable (
                                                             id INT ( 11 ) PRIMARY KEY NOT NULL auto_increment,
                                                             dept_id INT(11),
                                                             jobt_id INT(11),
                                                             dept_name VARCHAR ( 255 ),
                                                             jobt_name VARCHAR ( 255 ),
                                                             dept_num INT(11),
                                                             jobt_num INT(11)
    );
    TRUNCATE TABLE statisticsTable;
-- 打开游标
    OPEN deptCursor;
-- 开始循环体,deptLoop为自定义循环名
    deptLoop: LOOP
        -- 	将游标当前读取行的数据,顺序赋值给后面的变量
        FETCH deptCursor INTO deptId,deptName,deptNum;

-- 	判断是否继续循环
        IF done = 1 THEN
-- 		结束循环
            LEAVE deptLoop;
        END IF;
-- 	开启第二个游标
        OPEN jobtCursor;
        jobtLoop: LOOP
            FETCH jobtCursor INTO jobtId,jobtName;
            IF done = 1 THEN
                LEAVE jobtLoop;

            END IF;
            SELECT COUNT(*) INTO statisNum FROM teacher_info WHERE dept_id=deptId AND job_title_id = jobtId;
            -- 	插入数据到临时表
            INSERT INTO statisticsTable (dept_id, dept_name, dept_num,jobt_id,jobt_name, jobt_num)
            VALUES
            (deptId, deptName, deptNum,jobtId,jobtName, statisNum);
        END LOOP jobtLoop;
-- 关闭第二个游标
        CLOSE jobtCursor;
-- 结束内游标循环体
        SET done = 0;
-- 	结束自定义循环体
    END LOOP deptLoop;
-- 关闭游标
    CLOSE deptCursor;
    -- 	SET @rowId = UUID();
-- 	INSERT INTO statisticsTable(id, dept_name, jobt_name, job_name, dept_num, jobt_num, job_num) VALUES ();


    SELECT * FROM statisticsTable;
END;
;;
delimiter ;

-- ----------------------------
-- Procedure structure for StatiticsNum
-- ----------------------------
DROP PROCEDURE IF EXISTS `StatiticsNum`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `StatiticsNum`(
    IN department_id INT, IN jobt_id INT, OUT num INT)
BEGIN
    SELECT COUNT(*) INTO num FROM teacher_info WHERE teacher_info.dept_id=department_id AND teacher_info.job_title_id = jobt_id;
END;
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table teacher_info
-- ----------------------------
DROP TRIGGER IF EXISTS `teacher_insert`;
delimiter ;;
CREATE TRIGGER `teacher_insert` AFTER INSERT ON `teacher_info` FOR EACH ROW BEGIN
    DECLARE a INT (10);
    DECLARE b INT (10);
    DECLARE c INT (10);
    SET a=(SELECT num FROM department WHERE id=new.dept_id);
    SET b=(SELECT num FROM job_title WHERE id=new.job_title_id);
    SET c=(SELECT num FROM job WHERE id=new.job_id);
    UPDATE department SET num=(a+1) WHERE id=new.dept_id;
    UPDATE job_title SET num=(b+1) WHERE id=new.job_title_id;
    UPDATE job SET num=(c+1) WHERE id=new.job_id;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table teacher_info
-- ----------------------------
DROP TRIGGER IF EXISTS `teacher_update`;
delimiter ;;
CREATE TRIGGER `teacher_update` AFTER UPDATE ON `teacher_info` FOR EACH ROW BEGIN
    DECLARE a INT (10);
    DECLARE b INT (10);
    DECLARE c INT (10);
    SET a=(SELECT num FROM department WHERE id=new.dept_id);
    SET b=(SELECT num FROM job_title WHERE id=new.job_title_id);
    SET c=(SELECT num FROM job WHERE id=new.job_id);
    UPDATE department SET num=(a-1) WHERE id=new.dept_id;
    UPDATE job_title SET num=(b-1) WHERE id=new.job_title_id;
    UPDATE job SET num=(c-1) WHERE id=new.job_id;
    SET a=(SELECT num FROM department WHERE id=new.dept_id);
    SET b=(SELECT num FROM job_title WHERE id=new.job_title_id);
    SET c=(SELECT num FROM job WHERE id=new.job_id);
    UPDATE department SET num=(a+1) WHERE id=new.dept_id;
    UPDATE job_title SET num=(b+1) WHERE id=new.job_title_id;
    UPDATE job SET num=(c+1) WHERE id=new.job_id;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table teacher_info
-- ----------------------------
DROP TRIGGER IF EXISTS `teacher_delete`;
delimiter ;;
CREATE TRIGGER `teacher_delete` AFTER DELETE ON `teacher_info` FOR EACH ROW BEGIN
    DECLARE a INT (10);
    DECLARE b INT (10);
    DECLARE c INT (10);
    SET a=(SELECT num FROM department WHERE id=old.dept_id);
    SET b=(SELECT num FROM job_title WHERE id=old.job_title_id);
    SET c=(SELECT num FROM job WHERE id=old.job_id);
    UPDATE department SET num=(a-1) WHERE id=old.dept_id;
    UPDATE job_title SET num=(b-1) WHERE id=old.job_title_id;
    UPDATE job SET num=(c-1) WHERE id=old.job_id;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
