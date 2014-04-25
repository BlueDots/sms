##
update stu_basic_info set studentName='小辉辉',sex=1 where studentNo = '20111826';
select * from stu_basic_info;
select * from stu_adv_info;
delete from stu_adv_info where awardNo = 30 or awardNo = 31; 
--测试数据--
delete from tec_info;
delete from tec_basic_info;
select count(*) from stu_basic_info sb inner join stu_adv_info sa on sb.studentNo = sa.studentNo awhere nd sb.className = '软件1111班'
##教师登录信息
insert into tec_info values('1801','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1802','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1803','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1804','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1805','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1806','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1807','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1808','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1809','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1810','123456','您父亲的姓名？','曹国平',0);
##教师基本信息
<<<<<<< HEAD
=======
##delete from tec_basic_info;
>>>>>>> 4eaf6523a6009adb8405890652a5069ba3d23b0e
insert into tec_basic_info values('1801','王映龙',0,'汉族','江西萍乡','中共党员','在职','教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1802','邓泓',0,'汉族','江西赣州','中共党员','在职','副教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1803','李佳航',1,'汉族','江西南昌','中共党员','在职','副教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1804','艾施荣',0,'汉族','江西萍乡','中共党员','在职','教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1805','彭莹琼',1,'汉族','江西萍乡','中共党员','在职','副教授','2012-12-01','2000-09-01','硕士研究生','通过','无');
insert into tec_basic_info values('1806','胡昶',0,'汉族','江西萍乡','中共党员','在职','副教授','2012-12-01','2000-09-01','硕士研究生','通过','无');
insert into tec_basic_info values('1807','吴沧海',1,'汉族','江西萍乡','中共党员','在职','教授','2012-12-01','2000-09-01','硕士研究生','通过','无');
insert into tec_basic_info values('1808','邓松',0,'汉族','江西萍乡','中共党员','在职','副教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1809','庞咏兰',1,'汉族','四川武昌','中共党员','在职','副教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1810','杨键川',0,'汉族','吉林长春','中共党员','在职','副教授','2012-12-01','2000-09-01','博士研究生','通过','无');
##评优评先信息
insert into stu_adv_Info values(null,'20111826','优秀三好学生','省级','201301','通过','无');
insert into stu_adv_Info values(null,'20111827','优秀学生干部','省级','201302','通过','无');
insert into stu_adv_Info values(null,'20111828','优秀共青团员','院级','201301','通过','无');
insert into stu_adv_Info values(null,'20111829','最佳三好学生','校级','201302','通过','无');
insert into stu_adv_Info values(null,'20111830','最佳学生干部','省级','201301','通过','无');
insert into stu_adv_Info values(null,'20111831','优秀团干部','厅级','201302','通过','无');
insert into stu_adv_Info values(null,'20111832','优秀共青团员','省级','201301','通过','无');
insert into stu_adv_Info values(null,'20111833','优秀学生干部','省级','201302','通过','无');
insert into stu_adv_Info values(null,'20111834','优秀三好学生','省级','201301','通过','无');
insert into stu_adv_Info values(null,'20111835','优秀学生干部','国家级','201302','通过','无');
insert into stu_adv_Info values(null,'20111836','优秀共青团员','校级','201301','通过','无');
insert into stu_adv_Info values(null,'20111837','优秀学生干部','省级','201302','通过','无');
insert into stu_adv_Info values(null,'20111838','优秀三好学生','省级','201301','通过','无');
insert into stu_adv_Info values(null,'20111839','优秀共青团员','省级','201302','通过','无');
insert into stu_adv_Info values(null,'20111840','优秀共青团员','省级','201301','通过','无');
insert into stu_adv_Info values(null,'20111841','优秀学生干部','省级','201302','通过','无');
insert into stu_adv_Info values(null,'20111842','优秀三好学生','省级','201301','通过','无');
insert into stu_adv_Info values(null,'20111843','优秀学生干部','省级','201302','通过','无');
insert into stu_adv_Info values(null,'20111844','优秀共青团员','省级','201301','通过','无');
insert into stu_adv_Info values(null,'20111845','优秀学生干部','省级','201302','通过','无');
insert into stu_adv_Info values(null,'20111846','优秀三好学生','省级','201301','通过','无');
insert into stu_adv_Info values(null,'20111847','优秀共青团员','省级','201302','通过','无');
insert into stu_adv_Info values(null,'20111848','优秀共青团员','省级','201301','通过','无');
insert into stu_adv_Info values(null,'20111849','优秀学生干部','省级','201302','通过','无');

##学院信息
insert into dep_info values('3212','中科软件学院','软件学院','成立于2004',2500,500,600,600,600,700,1);
insert into dep_info values('3121','外国语学院','外语学院','成立于1960',1000,850,300,300,300,100,1);
##专业信息
insert into major_info values('32120201','网络应用方向','网络应用方向','3212','成立于2004',300,1);
insert into major_info values('32120202','软件加英语','软件英语','3212','成立于1960',500,1);

insert into major_info values('31210201','英语','英语','3212','成立于2004',300,1);
insert into major_info values('31210202','日语','日语','3121','成立于1960',200,1);
##班级信息
select * from class_info;
insert into class_info values('321202012001','软件1107班','软件1107班','32120201',38,18,'2011-09-01',4,1);
insert into class_info values('321202022001','软件1111班','软件1111班','32120202',38,18,'2011-09-01',4,1);

insert into class_info values('312102012001','英语1101班','英语1101班','31210201',38,18,'2011-09-01',4,1);
insert into class_info values('312102022001','日语1101班','日语1101班','31210202',38,18,'2011-09-01',4,1);

##评优评先项目信息
insert into adv_item values(400,'优秀三好学生','2011-09-02','省级',null,null);
insert into adv_item values(401,'优秀学生干部','2011-09-02','省级',null,null);
##学生评优评先记录
insert into stu_adv_Info values(null,'20111826','优秀三好学生','省级','201301','校级已通过','无');
insert into stu_adv_Info values(null,'20111827','优秀学生干部','省级','201302','校级已通过','无');
insert into stu_adv_Info values(null,'20111826','优秀共青团员','省级','201301','校级已通过','无');
insert into stu_adv_Info values(null,'20111827','优秀学生干部','省级','201302','校级已通过','无');
insert into stu_adv_Info values(null,'20111826','优秀三好学生','省级','201301','校级已通过','无');
insert into stu_adv_Info values(null,'20111827','优秀共青团员','省级','201302','校级已通过','无');
insert into stu_adv_Info values(null,'20111826','优秀共青团员','省级','201301','校级已通过','无');
insert into stu_adv_Info values(null,'20111827','优秀学生干部','省级','201302','校级已通过','无');
##奖助学项目信息
insert into grant_item values(500,'国家奖学金','2011-10-02','国家级',8000,null,null);
insert into grant_item values(501,'国家励志奖学金','2011-10-02','国家级',5000,null,null);
##学生奖助学记录
insert into stu_grant_Info values(null,'20111826','国家奖学金','国家级',8000,'201301','校级已通过','无');
insert into stu_grant_Info values(null,'20111827','国家励志奖学金','国家级',5000,'201302','校级已通过','无');
##建档信息
insert into des_item values(900,'甲等',null);
insert into des_item values(null,'乙等',null);
insert into des_item values(null,'乙等',null);
##贫困生建档信息
insert into stu_des_Info values(null,'20111826','家庭较贫困','甲等','201301','校级已通过','无');
insert into stu_des_Info values(null,'20111827','家庭特贫困','乙等','201302','校级已通过','无');
##校级工作人员分配项目信息
delete from sch_prop_distribution;
select * from sch_prop_distribution;
insert into sch_prop_distribution values(null,100,100,0.10,'2014-09-08','2014-09-08','2014-09-28','201301');
insert into sch_prop_distribution values(null,101,100,0.10,'2014-09-08','2014-09-08','2014-09-28','201302');
##院级工作人员分配比例表
select * from col_prop_distribution;
insert into col_prop_distribution values(null,'3212',101,2,0.60,1.0,1.0,1.0,1.0,'2014-09-08','2014-09-08','2014-09-28','201302');
##班级分配人数表
select * from cla_prop_distribution;
insert into cla_prop_distribution values(null,'321202012001','3212',101,10,'201302');

##创建视图(视图的列名是唯一的，当创建视图的时候必须保证去除重复的列)
##评优评先模块-学生评优评先记录视图
create view stu_advInfo_View 
as
select sb.studentNo,sb.stuName,sb.sex,sb.stuCollege,sb.stuMajor,sb.stuClass,sa.advanceActivity,sa.advTime,sa.advLevel,sa.examState,sa.remarks
from stu_basic_info sb inner join stu_adv_info sa on sb.studentNo = sa.studentNo order by sa.advTime,sa.studentNo;
##奖助学模块-学生奖助学记录视图
create view stu_grantInfo_View 
as
select sb.studentNo,sb.stuName,sb.sex,sb.stuCollege,sb.stuMajor,sb.stuClass,sc.rank,sd.desLevel,sg.activityName,sg.grantProperty,sg.grantTime,sg.grantMoney,sg.examState
from stu_basic_info sb inner join stu_grant_info sg on sb.studentNo = sg.studentNo inner join stu_class_grant sc on sc.studentNo = sg.studentNo inner join stu_des_info 
sd on sg.studentNo = sd.studentNo order by sg.grantTime,sg.studentNo;
##贫困生建档模块-贫困生记录视图
create view stu_desInfo_View 
as
select sb.studentNo,sb.stuName,sb.sex,sb.stuCollege,sb.stuMajor,sb.stuClass,sb.address,sd.economy,sd.desLevel,sd.term,sd.examState,sd.remarks
from stu_basic_info sb inner join stu_des_info sd on sb.studentNo = sd.studentNo order by sd.term,sd.studentNo;

##创建触发器(加强约束以及规范相应的级联关系)
 	##注意:
 	##delimtier |
 	create trigger schPropDistribution after update on sch_prop_distribution 
 	for each row begin
 		declare i int;
 		declare schoolNum int;
 		declare collegeNumber int;
 		declare numOfCollege int;
 		declare depNo char(4);
 		declare schProp decimal(3,2);
 		set i = 1;
 		select count(*) into schoolNum from stu_basic_info;  
 		select count(*) into numOfCollege from dep_info;
 		
 		drop temporary table if exists depInfoTb;
 		create temporary table depInfoTb
 		(
 			autoNo int auto_increment primary key,
			departNo char(4) not null
 		);
 		
 		insert into depInfoTb select null,departNo from col_prop_distribution where propNo = new.propNo and term = new.term;
 		
 		if new.awardNum != old.awardNum then 
 			set schProp = ROUND(new.awardNum/1000,2);
 			while i<=numOfCollege do
 			select departNo into depNo from depInfoTb where autoNo = i;
 			select depNumber into collegeNumber from dep_info where departNo = depNo;
 			set collegeNumber = ROUND(collegeNumber*schProp,0);
 			update col_prop_distribution set awardNum = collegeNumber,proposition = schProp where departNo = depNo and propNo = old.propNo and term = old.term;
 			set i = i + 1;
 			end while;
 		end if;
 	end
	
	update sch_prop_distribution set awardNum = 250 where propNo = 100 and term = '201301';
	
	create trigger colPropDistribution after update on col_prop_distribution 
 	for each row begin
 		declare i int;
 		declare collegeNum int;
 		declare proposition decimal(3,2);
 		declare classNum int;
 		declare numOfClass int;
 		declare classes char(14);
 		set i = 1;
 		select depNumber into collegeNum from dep_info where departNo = old.departNo;
 		select count(*) into numOfClass from class_info where departNo = old.departNo;
 		drop temporary table if exists classInfoTb;
 		create temporary table classInfoTb
 		(
 			autoNo int auto_increment primary key,
			classNo char(14) not null
 		);
 		insert into classInfoTb select null,classNo from cla_prop_distribution where propNo = old.propNo and term = old.term;
 		if new.awardNum != old.awardNum then 
 			set proposition = ROUND(new.awardNum/collegeNum,2);
 			while i<=numOfClass do
 			select classNo into classes from classInfoTb where autoNo = i;
 			select classNumber into classNum from class_info where classNo = classes;
 			set classNum = ROUND(classNum*proposition,0);
 			update cla_prop_distribution set awardNum = classNum where classNo = classes and propNo = old.propNo and term = old.term;
 			set i = i + 1;
 			end while;
 		end if;
 	end

 	select * from col_prop_distribution;
 	update col_prop_distribution set awardNum = 1 where propNo = 100 and departNo = '3212' and term = '201302';