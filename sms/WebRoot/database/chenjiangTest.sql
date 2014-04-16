select * from stu_basic_info;

update stu_basic_info set exameState = '院级审核中' 
       where studentNo in (20111367,20111429,20111635);

update act_info set exameState = '校级审核中' 
       where actNo in (1,2,3);
       
select * from act_info;

select * from act_hold;

insert into act_hold values(null,2,1,'2000-11-11','2000-11-11','ss1');
insert into act_hold values(null,2,2,'2001-11-11','2001-11-11','ss2');
insert into act_hold values(null,3,1,'2010-11-11','2010-11-11','ss3');
insert into act_hold values(null,3,2,'2011-11-11','2011-11-11','ss4');

select * from tec_basic_info;

select * from stu_act_participate;

select count(distinct activityName) from stu_act_participate sap,act_info, ai where sap.actno=ai.actno

		select  ah.* from stu_act_participate sap,act_hold ah,act_info ai
 			where sap.actno=ah.actno and ai.actNo=ah.actNo and sap.sessionYear=ah.sessionYear
 and sap.exameState='院级审核中' and organize = '软件学院' order by actNo;

update stu_act_participate set exameState = '通过' where id in (1,14,16);

insert into tec_basic_info(teacherNo,teacherName,sex,hometown) values('4610','嘎嘎',0,'江西');
insert into tec_basic_info(teacherNo,teacherName,sex,hometown) values('4611','啦啦',0,'江西');


select * from act_category;
--insert into act_category(actNo,actType) values(null,'文艺体育类');
--insert into act_category(actNo,actType) values(null,'学术科技类');
--insert into act_category(actNo,actType) values(null,'社会公益类');
--insert into act_category(actNo,actType) values(null,'实践创新类');
--insert into act_category(actNo,actType) values(null,'理论学习类');
--insert into act_category(actNo,actType) values(null,'其他类');