drop table if exists hos_insurance_info;

##创建医保信息表
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
 