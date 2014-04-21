
use sms;
delete from hos_insurance_info;
 
delete from stu_basic_info
insert into stu_basic_info 
values('20111429','熊安平','1992-02-06','软件学院1102','软件工程',
'软件学院',0,'汉族','江西','团员','6222202100','133333333',
'557572@qq.com',1,'儿子','瓦溪','444488','d:/aa.txt','本科',
'四级','455555234','999','',0
);

insert into stu_basic_info 
values('20111430','熊安平','1992-02-06','1102','软件工程',
'软件学院',0,'汉族','江西','团员','6222202100','133333333',
'557572@qq.com',1,'儿子','瓦溪','444488','d:/aa.txt','本科',
'四级','455555234','999','',0
);

insert into stu_basic_info 
values('20111431','熊安平','1992-02-06','1102','软件工程',
'软件学院',0,'汉族','江西','团员','6222202100','133333333',
'557572@qq.com',1,'儿子','瓦溪','444488','d:/aa.txt','本科',
'四级','455555234','999','',0
);

select * from stu_basic_info , hos_insurance_info where college='软件学院' and className='1102' and hos_insurance_info.studentNo=stu_basic_info.studentNo;


insert into hos_insurance_info
values(null,'20111429','居民医保','南昌医院',null,null,'10',
0,'aaa',190,null,0,0,null,'感冒不受理','不受理',null,null,
null,null,null,null,null,null,null,null,null,null,null
);

insert into hos_insurance_info
values(null,'20111429','居民医保','南昌医院',null,null,'10',
0,'aaa',190,null,0,0,null,'感冒不受理','不受理',null,null,
null,null,null,null,null,null,null,null,null,null,null
);
 
insert into hos_insurance_info
values(null,'20111429','居民医保','南昌医院',null,null,'10',
0,'aaa',190,null,0,0,null,'感冒不受理','不受理',null,null,
null,null,null,null,null,null,null,null,null,null,null
);
 

insert into 

select * from hos_insurance_info  order    by  hosNo desc   ;