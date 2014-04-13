select * from stu_basic_info;

select * from act_info;

select * from act_hold;

select * from tec_basic_info;

select * from stu_act_participate;

delete from stu_act_participate where id>1;

insert into tec_basic_info(teacherNo,teacherName,sex,hometown) values('4610','嘎嘎',0,'江西');
insert into tec_basic_info(teacherNo,teacherName,sex,hometown) values('4611','啦啦',0,'江西');
