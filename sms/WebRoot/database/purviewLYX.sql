--select table
select * from tec_basic_info;   --教师基本信息表
select * from purview_info;     --权限信息表
select * from role_info;        --角色信息表
select * from teacher_purview;  --教师权限表（暂不用）
select * from teacher_role;     --教师角色表
select * from role_purview;     --角色权限表
select * from dep_info;         --部门信息表
select * from dep_teacher;      --部门教师表

--drop table
drop table if exists teacher_role;
drop table if exists teacher_purview;
drop table if exists role_purview;
drop table if exists purview_info;
drop table if exists role_info;
drop table if exists dep_teacher;

--init table

--init purview
insert into role_info values(null,'校级管理员',now(),'校级管理员角色,默认拥有系统所有权限');
insert into role_info values(null,'学生',now(),'学生角色，固定权限');
insert into role_info values(null,'班主任',now(),'班主任角色，负责某班级');
insert into role_info values(null,'院级工作人员1',now(),'院级工作人员之一，主要负责某院系贫困生建档等');
insert into role_info values(null,'院级工作人员2',now(),'院级工作人员之一，主要负责某院系奖惩信息');
insert into role_info values(null,'院级工作人员3',now(),'院级工作人员之一，主要负责某院系基本信息管理');
insert into role_info values(null,'校级工作人员1',now(),'校级工作人员之一，主要负责全校医保等');
insert into role_info values(null,'校级工作人员2',now(),'校级工作人员之一，主要负责全校系奖惩信息');
insert into role_info values(null,'校级工作人员3',now(),'校级工作人员之一，主要负责全校系基本信息管理');
insert into role_info values(null,'院级管理员',now(),'院级管理员角色，每院有且只有一名');
insert into role_info values(null,'活动负责人',now(),'活动管理中的特殊角色');

insert into purview_info values(1,null,'功能模块','null');
insert into purview_info values(2,1,'学生基本信息模块','/StuBasicInfoAction!loadTeacher');
insert into purview_info values(3,1,'教师基本信息模块','');
insert into purview_info values(4,1,'评优评先模块','');
insert into purview_info values(5,1,'奖助学信息模块','');
insert into purview_info values(6,1,'学生参与活动模块','');
insert into purview_info values(7,1,'活动管理模块','');
insert into purview_info values(8,1,'班级奖学金模块','');
insert into purview_info values(9,1,'医保信息模块','/hosInsuranceInfo!getAllHosByTeacher');
insert into purview_info values(10,1,'贫困生建档模块','');
insert into purview_info values(11,1,'个人简历模块','');
insert into purview_info values(12,1,'学生就业信息模块','');
insert into purview_info values(13,1,'处分信息模块','');
insert into purview_info values(14,1,'学籍变动信息模块','');
insert into purview_info values(15,1,'角色管理模块','/role!roleExecute');
insert into purview_info values(16,1,'分配角色管理模块','/allocation!tecRoleDisplay');
insert into purview_info values(17,1,'分配权限模块','');
insert into purview_info values(18,1,'院系专业班级管理模块','');
insert into purview_info values(19,15,'添加角色','');
insert into purview_info values(20,15,'删除角色','');
insert into purview_info values(21,15,'查看角色权限','');
insert into purview_info values(22,16,'查询教师角色信息','');
insert into purview_info values(23,16,'教师分配角色','');
insert into purview_info values(24,16,'教师移除角色','');
insert into purview_info values(25,2,'学生基本信息审核','/StuBasicInfoVerifyAction!gainWaitingForClassName');
insert into purview_info values(26,2,'录入学生基本信息','/StuBasicInfoAction!entryStuBasicInfoLists');
insert into purview_info values(27,9,'查询医保信息','/hosInsuranceQuery!getAllHosByTeacher');
insert into purview_info values(28,9,'录入医保信息','/hosInsuranceInfo!updateHoss');
insert into purview_info values(29,9,'审核医保','/hosInsuranceInfo!getAllHosByTeacher');
insert into purview_info values(30,16,'','');
insert into purview_info values(31,16,'','');


insert into teacher_role values('1234',3);

insert into dep_teacher values('1105','1234');

insert into dep_info values('','');
