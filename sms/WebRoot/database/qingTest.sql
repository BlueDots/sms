insert into stu_info values(20111112,"mm",4,"mm",1);
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


insert into tec_info values(0000,"11",4,"mm",1);