--drop table
drop table if exists teacher_purview;
drop table if exists role_purview;
drop table if exists purview_info;
drop table if exists role_info;
drop table if exists teacher_role;
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
insert into purview_info values(2,1,'医保信息模块','hosInsuranceInfo/hosInsuranceInfo!getAllHosByTeacher');
insert into purview_info values(3,2,'教师查询医保信息','hosInsuranceInfo/hosInsuranceQuery!queryHosByCondition');
insert into purview_info values(4,2,'教师更新医保信息','hosInsuranceInfo/hosInsuranceInfo!updateHoss');
insert into purview_info values(5,2,'审核','hosInsuranceInfo/hosInsuranceInfo!checkHosByTeacher');
insert into purview_info values(6,2,'学生更新医保信息','hosInsuranceInfo/hosInsuranceInfo!modifyStu');
insert into purview_info values(7,2,'显示当前学生的信息','hosInsuranceInfo/hosInsuranceInfo!showYiBaoForStudent');
insert into purview_info values(8,2,'学生申请医保','hosInsuranceInfo/hosInsuranceInfo!applyYiBao');


insert into role_purview values(7,2);
insert into role_purview values(7,3);
insert into role_purview values(7,4);
insert into role_purview values(7,5);


insert into teacher_role values('1234',3);

insert into dep_teacher values('1105','1234');