select * from stu_basic_info;

select * from act_info;

select * from act_hold;

select * from tec_basic_info;

select * from stu_act_participate;

delete from stu_act_participate where id>1;

insert into tec_basic_info(teacherNo,teacherName,sex,hometown) values('4610','嘎嘎',0,'江西');
insert into tec_basic_info(teacherNo,teacherName,sex,hometown) values('4611','啦啦',0,'江西');


select * from act_category;
--insert into act_category(actNo,actType) values(null,'文艺体育类');
--insert into act_category(actNo,actType) values(null,'学术科技类');
--insert into act_category(actNo,actType) values(null,'社会公益类');
--insert into act_category(actNo,actType) values(null,'实践创新类');
--insert into act_category(actNo,actType) values(null,'理论学习类');
--insert into act_category(actNo,actType) values(null,'其他类');