--select

select * from tec_basic_info;
select * from purview_info;
select * from role_info;
select * from teacher_purview;
select * from teacher_role;
select * from role_purview;

--insert 
--测试发现 default约束是指插入固定字段时而不插入有default约束的字段，该
--字段才会默认，插入null时该字段就是null
--tec_basic_info
insert into tec_basic_info values('1234','jack',0,null,'江西',null,'离职',null,'2011-1-1',now(),'本科','已通过','无');
insert into tec_basic_info(teacherNo,teacherName,sex,nation,hometown,political,teacherTitle,titleTime,worktime,eduBackground,remarks) values('5678','cat',1,null,'江西',null,null,'2011-1-1',now(),'本科','无');
insert into tec_basic_info values('8765','arron',1,null,'江西',null,'在职',null,'2011-1-1',now(),'本科','已通过','无');
insert into tec_basic_info values('4321','tom',0,null,'江西',null,'在职',null,'2011-1-1',now(),'本科','已通过','无');
insert into tec_basic_info values('0000','admin',0,null,'江西',null,'在职',null,'2011-1-1',now(),'本科','已通过','无');

--role_info
insert into role_info values(0,'校级管理员',now(),'校级管理员角色,默认所有系统权限');
insert into role_info values(1,'学生',now(),'学生角色，固定权限');
insert into role_info values(2,'班主任',now(),'班主任角色');
insert into role_info values(3,'院级工作人员',now(),'院级工作人员角色');
insert into role_info values(4,'校级工作人员',now(),'校级工作人员角色');
insert into role_info values(5,'院级管理员',now(),'院级管理员角色');
insert into role_info values(6,'活动负责人',now(),'活动管理中的特殊角色');

--purview_info
insert into purview_info values(1,null,'功能模块','null');
insert into purview_info values(2,1,'学生基本信息模块','/studentInfo.jsp');
insert into purview_info values(3,1,'教师基本信息模块','/teacherInfo.jsp');
insert into purview_info values(4,1,'评优评先信息模块','/awardInfo.jsp');
insert into purview_info values(14,1,'贫困生信息模块','/poorStudentInfo.jsp');
insert into purview_info values(15,1,'医保信息模块','/MedicareInfo.jsp');
insert into purview_info values(16,1,'班级奖学金信息模块','/classAwardInfo.jsp');
insert into purview_info values(17,1,'角色管理','/roleManager.jsp');
insert into purview_info values(18,1,'分配权限管理','/allocationPurview.jsp');
insert into purview_info values(19,1,'分配角色管理','/allocationRole.jsp');
insert into purview_info values(20,1,'院系班级专业管理','/collegeClass.jsp');

--
insert into purview_info values(5,1,'奖助学金信息模块','/grantInfo.jsp');
insert into purview_info values(6,1,'活动管理模块','/activityInfo.jsp');
insert into purview_info values(7,1,'学生参与活动模块','/studentActivity.jsp');
insert into purview_info values(8,6,'活动信息列表','/activityList');
insert into purview_info values(9,6,'手动录入活动信息','/addActivity');
insert into purview_info values(10,6,'编辑活动信息','/editActivity');
insert into purview_info values(11,6,'删除活动','/deleteActivity');
insert into purview_info values(12,6,'导入活动','/importActivity');
insert into purview_info values(13,6,'导出活动','/exportActivity');
insert into purview_info values(14,6,'活动启动','/startActivity');
insert into purview_info values(15,6,'高级搜索','/searchActivity');
insert into purview_info values(16,6,'排序','/sortActivity');
insert into purview_info values(17,6,'审核活动信息','/auditActivity');
insert into purview_info values(18,6,'活动学分比例信息','/ScoreActivity');
--

insert into t_purview_info values(5,3,'查询教师基本信息','/showTeacherInfo');
insert into t_purview_info values(6,3,'编辑教师基本信息','/editTeacherInfo');
insert into t_purview_info values(7,3,'教师基本信息排序','/sortTeacherInfo');
insert into t_purview_info values(8,3,'教师基本信息高级搜索','/searchTeacherInfo');
insert into t_purview_info values(9,3,'导入教师基本信息','/importTeacherInfo');
insert into t_purview_info values(10,3,'手动录入教师基本信息','/addTeacherInfo');
insert into t_purview_info values(11,3,'导出教师基本信息','/exportTeacherInfo');
insert into t_purview_info values(12,3,'审核教师基本信息','/auditTeacherInfo');
insert into t_purview_info values(1,3,'教师基本信息列表','/teacherInfoList');

--teacher_role
insert into teacher_role values('1234',4);
insert into teacher_role values('5678',2);
insert into teacher_role values('5678',3);
insert into teacher_role values('8765',3);
insert into teacher_role values('4321',5);
insert into teacher_role values('0000',0);


--t_teacher_purview
insert into t_teacher_purview values('1234',4);

--role_purview
insert into role_purview values(4,3);

--delete
delete from t_teacher_purview where teacherNo in ('5678') and purviewNo in (2,3);


--update