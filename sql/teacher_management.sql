/*
 Navicat Premium Data Transfer

 Source Server         : MySQL5.7
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 192.168.1.12:3305
 Source Schema         : teacher_management

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 31/05/2020 00:42:49
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
  `num` int(11) DEFAULT NULL COMMENT '人数',
  PRIMARY KEY (`id`),
  UNIQUE KEY ```department_name``` (`department_name`) USING BTREE,
  KEY `id` (`id`,`department_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='部门';

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教育经历';

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int(11) NOT NULL,
  `job_name` varchar(255) DEFAULT NULL COMMENT '职务名称',
  `num` int(11) DEFAULT NULL COMMENT '人数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `job_name` (`job_name`) USING BTREE,
  KEY `id` (`id`,`job_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职务\n教师：（正、副）院长、（正、副)（院、系)书记、（正、副）科长、（正、副）（院、系)主任、公共教 育部老师、辅导员、班主任、（语文、数学、英语、化学、物理、政治、历史、地理、生物、体育、美术、音乐、计算机）老师';

-- ----------------------------
-- Table structure for job_title
-- ----------------------------
DROP TABLE IF EXISTS `job_title`;
CREATE TABLE `job_title` (
  `id` int(11) NOT NULL COMMENT 'id',
  `job_title_name` varchar(255) NOT NULL COMMENT '职称名字',
  `num` int(11) DEFAULT NULL COMMENT '人数',
  PRIMARY KEY (`id`),
  KEY `id` (`id`,`job_title_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职称';

-- ----------------------------
-- Table structure for rap_record
-- ----------------------------
DROP TABLE IF EXISTS `rap_record`;
CREATE TABLE `rap_record` (
  `id` int(11) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `rap_type` varchar(255) DEFAULT NULL COMMENT '奖惩类型',
  `remarks` varchar(255) DEFAULT NULL COMMENT '奖惩备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖惩记录\n';

-- ----------------------------
-- Table structure for teacher_family_member
-- ----------------------------
DROP TABLE IF EXISTS `teacher_family_member`;
CREATE TABLE `teacher_family_member` (
  `id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `relationship` varchar(255) DEFAULT NULL COMMENT '与教师关系',
  `member_name` varchar(255) DEFAULT NULL COMMENT '家庭成员姓名',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家庭关系';

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) DEFAULT NULL COMMENT '所在部门',
  `job_title_id` int(11) DEFAULT NULL COMMENT '所属职称',
  `job_id` int(11) DEFAULT NULL COMMENT '所属职务',
  `teacher_name` varchar(255) NOT NULL COMMENT '教师名称',
  `e_mail` varchar(255) DEFAULT NULL COMMENT '电子邮件',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`),
  KEY `job_title_id` (`job_title_id`),
  KEY `job_id` (`job_id`),
  KEY `teacher_info_ibfk_1` (`dept_id`),
  CONSTRAINT `teacher_info_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `teacher_info_ibfk_2` FOREIGN KEY (`job_title_id`) REFERENCES `job_title` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `teacher_info_ibfk_3` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='教师信息';

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
-- 存储过程 Procedure structure for StatiticsAll
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
	SELECT COUNT(*) INTO jobtNum FROM teacher_info WHERE dept_id=deptId AND job_title_id = jobtId;
	-- 	插入数据到临时表
		INSERT INTO statisticsTable (dept_id, dept_name, dept_num,jobt_id,jobt_name, jobt_num)
		VALUES
			(deptId, deptName, deptNum,jobtId,jobtName, jobtNum);
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
-- 存储过程 Procedure structure for StatiticsNum
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
-- 触发器 Triggers structure for table teacher_info
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
-- 触发器 Triggers structure for table teacher_info
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
-- 触发器 Triggers structure for table teacher_info
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
