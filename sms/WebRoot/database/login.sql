drop database if exists test;
create database test;
use test;

create table stu_info(
	studentNo char(8) primary key,
	stuPassword varchar(12) not null,
	question enum('您父亲的姓名？','您母亲的姓名？','您的爱好是？','您的恋人是？','您的出生地点是？'),
	answer varchar(30),
	stuState tinyint 
);

create table tec_info(
	teacherNo char(4) primary key,
	tecPassword varchar(12) not null,
	question enum('您父亲的姓名？','您母亲的姓名？','您的爱好是？','您的恋人是？','您的出生地点是？'),
	answer varchar(30),
	tecState tinyint
);

insert into stu_info values(20111112,"mm",4,"mm",1);