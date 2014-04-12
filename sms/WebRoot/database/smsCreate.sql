drop database sms;
create database sms;
use sms;

##陈江

/*学生基本信息表1*/

create table stu_basic_info
(
	studentNo char(8),
	studentName varchar(18) not null,
	birthday date not null,
	className varchar(30) not null,
	major varchar(30) not null,
	college varchar(30) not null,
	sex int not null,
	nation varchar(30) not null,
	hometown varchar(84) not null,
	political varchar(24),
	idCard char(18) not null,
	telephone char(11),
	email varchar(50),
	emailOnly int ,
	family varchar(30),
	address varchar(60),
	fphone varchar(18),
	photo text,
	eduBackground varchar(12),
	englishlevel char(12),
	bankCard varchar(25),
	exameState varchar(30),
	remarks varchar(150) default '',
	stuState int default 0,
	constraint pk_stu_basic_info primary key(studentNo)
);

##教师基本信息表2
create table tec_basic_info(
	teacherNo char(4) primary key,
	teacherName varchar(18) not null,  								
	sex tinyint default 0 not null, 														
	nation varchar(30) default '汉族',										
	hometown varchar(84) not null,									
	political varchar(24) default '不详',	                                         							
	tecState varchar(15) default '在职',										
	teacherTitle varchar(30) default '不详',							
	titleTime date,									
	worktime date,	 								
	eduBackground varchar(30),	
	exameState 	varchar(30),		
	remarks varchar(150)								
);

/*活动信息表3*/
create table act_info
(
	actNo int auto_increment,
	activityName varchar(60) not null,
	activityType varchar(30) not null,
	activityLevel varchar(30) not null,
	sponsor varchar(60) not null,
	organize varchar(60) not null,
	teacherNo char(4) not null,
	studentName varchar(30),
	createTime date not null,
	info varchar(150),
	exameState varchar(30),
	remarks varchar(150) default '',
	actState int default 0,
	constraint pk_act_info primary key(actNo),
	constraint fk_teacherNo foreign key(teacherNo) references tec_basic_info(teacherNo)
);
/*活动举办信息表4*/
create table act_hold
(
	id int not null auto_increment,
	actNo int not null,
	sessionYear int null,
	startTime date not null,
	endTime date not null,
	holdPlace varchar(90) not null,
	constraint pk_act_hold primary key(id),
	constraint fk_act_hold_actNo foreign key(actNo) references act_info(actNo)
);


/*学生参与活动信息表5*/
create table stu_act_participate
(
	id int not null auto_increment,
	studentNo char(8),
	actNo int not null,
	sessionYear int not null,
	awardTime date not null,
	activityRating varchar(30) not null,
	studentPost varchar(30) ,
	workingTime date ,
	exameState varchar(30),
	remarks varchar(150),
	stuActState int default 0,
	constraint pk_stu_act_participate primary key(id),
	constraint fk_stu_act_participate_studentNo foreign key(studentNo) references stu_basic_info(studentNo),
	constraint fk_stu_act_participate_actNo foreign key(actNo) references act_info(actNo)
);

/*处分信息表6*/
create table dis_info
(
	id int auto_increment,
	studentNo char(8) not null,
	disType varchar(30) not null,
	dispoalReason varchar(150) not null,
	dispoalTime date not null,
	removeReason varchar(150),
	removeTime date,
	dispoalState int default 1,
	exameState varchar(30),
	remarks text,
	constraint pk_dis_info primary key(id),
	constraint fk_dis_info_studentNo foreign key(studentNo) references stu_basic_info(studentNo)
);


/*审核状态表7*/
create table ins_state
(
	insNo tinyint primary key,
	insType varchar(30)
)engine=MyISAM;

##熊安平

##创建奖学金等级表8
create table class_award_info(
	awardNo int primary key auto_increment,
	awardLevel varchar(21),
	awardState tinyint default 0
)engine=MYISAM;

##创建的是班级奖学金表9
create table stu_class_grant(
	studentNo char(8),
	term char(6),
	baseScore double,
	awardScore double,
	punishScore double,
	moralQualityAssessmentScore double,
	moralQualityAssessmentRank int,
	lessonScore double,
	innovateScore double,
	skillsScore double,
	qualityScore double,
	qualityRank int,
	sportScore double,
	physiqueScore double,
	sportMatchScore double,
	sportQualityTotalScore double,
	sportQualityRank int,
	manageScore	double,
	cultureScore	double,
	mediaScore double,
	serviceScore	double,
	artEducationTotalScore	 double,
	artEducationTotalRank int,
	totalScore double,
	totalScoreRank int,
	rank tinyint,
	remarks varchar(150),
	exameState varchar(30),
	classGrantState int default 0,
	primary key(studentNo,term)
)engine=innodb;
alter table stu_class_grant
add foreign key (studentNo) references stu_basic_info(studentNo)
on delete no action on update cascade;
##部门学院表10
 create table dep_info(
 	departNo char(4) primary key,
 	depart varchar(36),
 	departBrief varchar(27),
 	departInfo  varchar(90),
 	depNumber int default  0 ,
 	girlNumber int default  0 ,
 	freNumber  int  default 0,
 	sopNumber int default 0 ,
 	junNumber int default 0 ,
 	senNumber int default 0,
 	depState tinyint default 0
 )engine=innodb;
##创建院级奖学金统计表11
create table dep_statistical(
	term varchar(20),
	depNo char(4),
    oneLevel double,
    twoLevel  double,
    threeLevel double,
    primary key(term,depNo)
)engine=innodb;
alter table 	dep_statistical
add foreign key(depNo) references dep_info(departNo)
on delete no action on update cascade;
 ##创建 专业信息表 departNo外键关联部门表12
 create table major_info(
      majorNo char(8) primary key,
      major     varchar(60),
      majorShort  varchar(45),
      departNo char(4),
      majorInfo varchar(150),
      majorNumber int default 0,
      majorState tinyint default 0
 )engine = innodb;
 ##添加外键和外键索引
alter table major_info 
add  foreign key (departNo) references dep_info(departNo)
on  delete no action on update  cascade;

 alter table major_info add index majorFkIndex(departNo);
##创建班级信息表,majorNo外键需要关联专业 13
 create table class_info(
      classNo  char(14) primary key ,
      className varchar(45),
      classBreif varchar(30),
      majorNo char(8),
      classNumber int default 0,
      girlNumber int default 0 ,
      schoolDate date,
      studyTime tinyint ,
      classState tinyint default 0,
     
       foreign key  (majorNo) references major_info(majorNo)
      on delete no action on update cascade
     
 ) ENGINE=innodb; 
 alter table class_info add index  classFkIndex(majorNo);
##创建班级奖学金统计表14
create table class_statistical(
	term varchar(20),
	classNo char(4),
    oneLevel double,
    twoLevel  double,
    threeLevel double,
    primary key(term,classNo)
)engine=innodb;
alter table 	class_statistical
add foreign key(classNo) references class_info(classNo)
on delete no action on update cascade; 
##创建医保信息表15
create table hos_insurance_info(
	
	hosNo int ,

	studentNo char(8),

	hosType varchar(60),

	hospitaladdress varchar(60),

	hospitalDate date,
	
	leavedate date,
	
	hosDate tinyint,

	localcity tinyint,
	
	conditon varchar(60),

	cost double,
	
	applytime datetime,

	accept tinyint,
	
	collarCard tinyint,
	
	submittime datetime,
	
	refusereason TINYTEXT,
	resultDeal varchar(90),
	companyRemark TINYTEXT,
	reimbursementamount double,
	bill  tinyint,
	getcardtime datetime,
	jumingRemark TINYTEXT,
	bankcardID varchar(30),
	complete  tinyint,
	insurertime datetime,
	notinsurerReason TINYTEXT,
	baoxiaoRemark TINYTEXT,
	stateRemark TINYTEXT,
	returnMark TINYTEXT,
	hosState varchar(30),
	primary key(hosNo,studentNo) 
)ENGINE=innodb;
alter table hos_insurance_info
add  foreign key (studentNo) references  stu_basic_info(studentNo)
on  delete no action on update  cascade;
 
##李易翔

create unique index teacherNo_index on tec_basic_info(teacherNo);
create index teacherName_index on tec_basic_info(teacherName,tecState);
create index exameState_index on tec_basic_info(exameState);

##教师部门表16
create table dep_teacher(
	departNo char(4),
	teacherNo char(4),
	primary key (departNo,teacherNo),
	foreign key (departNo)  references dep_info(departNo),
	foreign key (teacherNo)  references tec_basic_info(teacherNo)
);

##权限信息表17
create table purview_info(
	id int primary key,
	pid int,
	purviewName varchar(45) not null,
	purviewUrl varchar(120) not null,
	foreign key(pid) references purview_info(id)
);

create unique index purviewUrl_index on purview_info(purviewUrl);

##角色信息表18
create table role_info(
	roleNo int primary key,
	roleName varchar(45) not null,
	createTime date,
	roleDescription varchar(255)
);

##教师角色表19
create table teacher_role(
	teacherNo char(4),
	roleNo int,
	primary key (teacherNo,roleNo),
	foreign key (teacherNo)  references tec_basic_info(teacherNo),
	foreign key (roleNo)  references role_info(roleNo)
);

##教师权限表20
create table teacher_purview(
	teacherNo char(4),
	purviewNo int,
	primary key(teacherNo,purviewNo),
	foreign key(teacherNo) references tec_basic_info(teacherNo),
	foreign key(purviewNo) references purview_info(id)
);

##角色权限表21
create table role_purview(
	roleNo int,
	purviewNo int,
	primary key(roleNo,purviewNo),
	foreign key(roleNo) references role_info(roleNo),
	foreign key(purviewNo) references purview_info(id)
);

##赖辉强

##评优评先项目表22
create table adv_item
(
	advNo int not null auto_increment primary key,
	advanceActivity varchar(60) not null,
	createTime date not null,
	advLevel varchar(30) not null,
	remarks varchar(150) default '无',
	advState tinyint default 0
)ENGINE = MyISAM;
create index adv_item_level_index on adv_item(advLevel);
##学生评优评先记录表23
create table stu_adv_info 
(
	awardNo int not null auto_increment primary key,
	studentNo char(8) not null,
	advanceActivity varchar(60) not null,
	advLevel varchar(30) not null,
	advTime char(6) not null,
	examState varchar(30) not null,
	remarks varchar(150) not null,
	constraint FK_stuAdvInfo_stuBasicInfo foreign key(studentNo) references stu_basic_info(studentNo)
);
create index adv_info_stuNo_index on stu_adv_info (studentNo);
create index adv_info_state_index on stu_adv_info (advanceActivity,advTime);
##奖助学项目表24
create table grant_item 
(
	grantNo int auto_increment primary key,
	activityName varchar(30) not null,
	createTime date not null,
	grantProperty varchar(30) not null,
	grantMoney int not null,
	remarks varchar(150) default '无',
	grantState tinyint default 0
)ENGINE = MyISAM;
create index grant_item_index on grant_item(grantProperty,grantMoney);
##学生奖助学记录表25
create table stu_grant_info 
(
	awardNo int not null auto_increment primary key,
	studentNo char(8) not null,
	activityName varchar(30) not null,
	grantProperty varchar(30) not null,
	grantMoney int not null,
	grantTime char(6) not null,
	examState varchar(30) not null,
	remarks varchar(150) not null,
	constraint FK_stuGrantInfo_stuBasicInfo foreign key(studentNo) references stu_basic_info(studentNo)
);
create index grant_info_stuNo_index on stu_grant_info (studentNo);
create index grant_info_state_index on stu_grant_info (activityName,grantTime);
##贫困建档项目表26
create table des_item
(
	povertyId int auto_increment primary key,
	desLevel varchar(12) not null,
	desState tinyint default 0
)ENGINE = MyISAM;

##贫困生建档记录表27
create table stu_des_info
(
	awardNo int not null auto_increment primary key,
	studentNo char(8) not null,
	economy varchar(255) not null,
	desLevel varchar(12) not null,
	term char(6) not null,
	examState varchar(30) not null,
	remarks varchar(150) not null,
	constraint FK_stuDesInfo_stuBasicInfo foreign key(studentNo) references stu_basic_info(studentNo)
);
create index des_info_stuNo_index on stu_des_info (studentNo);
create index des_info_state_index on stu_des_info (desLevel,term);
##校级工作人员分配项目比例表(term属性值获取当前时间进行判断计算在插入)28
create table sch_prop_distribution 
(
	autoNo int auto_increment primary key,
	propNo int not null,
	awardNum int not null,
	proposition decimal(3,2) not null,
	allocateTime date not null,
	startTime date not null,
	endTime date not null,
	term char(6) not null
);
create index sch_prop_propNo_index on sch_prop_distribution(propNo);
create index sch_prop_term_index on sch_prop_distribution(term);
##院级工作人员分配比例表29
create table col_prop_distribution
(
	autoNo int auto_increment primary key,
	departNo char(4) not null,
	propNo int not null,
	awardNum int not null,
	proposition decimal(3,2) not null,
	freProposition decimal(3,2) default 1.0,
	SopProposition decimal(3,2) default 1.0,
	junProposition decimal(3,2) default 1.0,
	senProposition decimal(3,2) default 1.0,
	allocateTime date not null,
	startTime date not null,
	endTime date not null,
	term char(6) not null,
	constraint FK_colPropDist_schPropDist_propNo foreign key(propNo) references sch_prop_distribution(propNo),
	constraint FK_colPropDist_schPropDist_departNo foreign key(departNo) references dep_info(departNo)
);
create index col_prop_join_index on col_prop_distribution(departNo,propNo);
create index col_prop_term_index on col_prop_distribution(term);
##班级分配人数表30
create table cla_prop_distribution
(
	autoNo int auto_increment primary key,
	classNo char(14) not null,
	departNo char(4) not null,
	propNo int not null,
	awardNum int not null,
	term char(6) not null,
	constraint FK_claPropDist_colPropDist_propNO foreign key(propNo) references col_prop_distribution(propNo),
	constraint FK_claPropDist_colPropDist_departNo foreign key(departNo) references dep_info(departNo),
	constraint FK_claPropDist_colPropDist_classNo foreign key(classNo) references class_info(classNo)
);
create index cla_prop_join_index on cla_prop_distribution(departNo,classNo,propNo);
create index cla_prop_term_index on cla_prop_distribution(term);

##陈镇清
##学生登录信息表31
create table stu_info(
	studentNo char(8) primary key,
	stuPassword varchar(12) not null,
	question enum('您父亲的姓名？','您母亲的姓名？','您的爱好是？','您的恋人是？','您的出生地点是？'),
	answer varchar(30),
	stuState tinyint
);
##教师登录信息表32
create table tec_info(
	teacherNo char(4) primary key,
	tecPassword varchar(12) not null,
	question enum('您父亲的姓名？','您母亲的姓名？','您的爱好是？','您的恋人是？','您的出生地点是？'),
	answer varchar(30),
	tecState tinyint
);
##学籍变动信息表33
create table sta_change_info(
	no int primary key auto_increment,
	studentNo char(8) ,
	_type varchar(30),       
	_time Date not null,    
	exameState varchar(30),     
	remarks text
	
);
 -- 学籍变动类型表34 --
create table sta_category(          
	staNo tinyint primary key auto_increment,
	staContent varchar(10) not null,
	staState tinyint
)ENGINE = MyISAM;
alter table sta_change_info add constraint Fk_0 foreign key (studentNo) references stu_info(studentNo) on delete cascade;
##活动类别表35
create table act_category
(
actNo int primary key auto_increment,
actType varchar(30) not null,
actState tinyint default 0
)ENGINE = MyISAM;
##处分类型表36
create table dis_category
(
disNo int primary key auto_increment,
disContent varchar(30) not null,
disState tinyint default 0
)ENGINE = MyISAM;
##学生干部职务表37
create table stu_carder
(
	id int primary key auto_increment,
	studentNo char(8) not null,
	carPosition varchar(45) not null,
	postTime varchar(30) not null,
	postContext varchar(45),
	constraint FK_stuCarder_stuBasicInfo foreign key(studentNo) references stu_basic_info(studentNo)
);
##等级表38
create table award_level(
	awardNo int primary key,
	awardLevel	varchar(15),
	awardState tinyint default 1
)ENGINE = MyISAM;
##政治面貌表39
create table political_status(
	studentNo tinyint primary key,
	politicalName varchar(24)
)ENGINE = MyISAM;
##学生处分信息表40
create table stu_dis_info(

	id int primary key auto_increment,
	studentNo char(8),
	disType   varchar(30) not null,
	dispoalReason  varchar(150) not null,
	dispoalTime	 date not null,
	removeReason varchar(150),
	removeTime date,
	dispoalState int,
	exameState	varchar(30),
	remarks	varchar(150),
	foreign key(studentNo) references stu_basic_info(studentNo)
);

