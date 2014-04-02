drop table if exists stu_basic_info;
drop table if exists class_info;
drop table if exists major_info;
drop table if exists dep_info;

 
 ##部门学院表
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
 	depState tinyint default 1	
 )engine=innodb;
 
 ##创建 专业信息表 departNo外键关联部门表
 create table major_info(
      majorNo char(8) primary key,
      major     varchar(60),
      majorShort  varchar(45),
      departNo char(4),
      majorInfo varchar(150),
      majorNumber int default 0,
      majorState tinyint default 1
 )engine = innodb;
 ##添加外键和外键索引
alter table major_info 
add  foreign key (departNo) references  dep_info(departNo)
on  delete no action on update  cascade;
 
 alter table major_info add index majorFkIndex(departNo);
 
 
##创建班级信息表,majorNo外键需要关联专业 
 create table class_info(
      classNo  char(14) primary key ,
      className varchar(45),
      classBreif varchar(30),
      majorNo char(8),
      classNumber int default 0,
      girlNumber int default 0 ,
      schoolDate date,
      studyTime tinyint ,
      classState tinyint default 1,
     
       foreign key  (majorNo) references  major_info(majorNo)
      on delete no action on update cascade
     
 ) ENGINE=innodb; 
 alter table class_info add index  classFkIndex(majorNo);
 
 
 create table stu_basic_info(
	studentNo char(8) primary key,
	studentName varchar(18),
	sex tinyint,
	className varchar(30),
	major varchar(30),
	college varchar(30)
 );
 
alter table stu_basic_info add index  studeBasicFk1Index(className);
alter table stu_basic_info add index  studeBasicFk2Index(major);
alter table stu_basic_info add index  studeBasicFk3Index(college);
 
 
 
 
 
 
 
 