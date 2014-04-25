insert into stu_info values(20111112,'m',4'mm',1);
insert into stu_basic_info 
values('20111112','熊安平','1992-02-06','1102','软件工程',
'软件学院',0,'汉族','江西','团员','6222202100','133333333',
'557572@qq.com',1,'儿子','瓦溪','444488','d:/aa.txt','本科',
'四级','455555234','999','',1
);

select stu_info.studentNo, studentName, className,  major, college, sex,telephone,email,
emailOnly,bankCard, stu_info.stuState 
from stu_info,stu_basic_info
where stu_info.studentNo=stu_basic_info.studentNo and stu_info.studentNo='20111112' ;




insert into stu_basic_info 
values('20111112','熊安平','1992-02-06','1102','软件工程',
'软件学院',0,'汉族','江西','团员','6222202100','133333333',
'557572@qq.com',1,'儿子','瓦溪','444488','d:/aa.txt','本科',
'四级','455555234','999','',1
);
insert into act_info values (null,'江西农业大学软件创新设计大赛','科技类','校级','校团委','软件学院',
null,'陈振清',CURDATE(),null,null,null,1);      /* 活动表 */


insert into stu_act_participate values(null,20111112,1,9,CURDATE(),'一等奖',
'科技部部长',CURDATE(),null,null,1);

insert into stu_adv_info values(null,'20111112','最佳优秀干部','市级','20132','','');

select a.studentNo,a.advanceActivity,a.advTime,c.activityName,c.grantMoney,c.grantTime
from stu_adv_info a,stu_basic_info b,stu_grant_info c
where a.studentNo=b.studentNo and c.studentNo=b.studentNo;

insert into stu_grant_info values(null,'20111112','国家奖学金','国家',8000,'20131','','');
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
