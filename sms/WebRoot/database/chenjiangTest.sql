select * from stu_basic_info where exameState='软件1115';
update stu_basic_info set exameState='院级审核中';


desc stu_basic_info;
select * from dep_teacher;

delete from stu_basic_info where studentNo in ('20111556','20111557','20111558','20111559');

update stu_basic_info set exameState='院级审核中' where studentNo=20111367,
 set exameState='院级不通过' where studentNo=20111429;
       where studentNo in (20111367,20111429,20111635);

update act_info set exameState = '校级审核中',remarks='aa' where actNo=1; update act_info set exameState = '校级审核中' where actNo =2;
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


select *  from dep_info;
##delete from dep_info;
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1105','软件学院','','');
	
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1106','计信院','','');	
desc major_info;
select * from major_info;
insert into major_info(majorNo,major,departNo) values('11050101','网络应用方向','1105');
insert into major_info(majorNo,major,departNo) values('11050102','商务与政务应用方向','1105');
insert into major_info(majorNo,major,departNo) values('11050103','数字媒体技术方向','1105');
insert into major_info(majorNo,major,departNo) values('11050104','嵌入式系统方向','1105');
insert into major_info(majorNo,major,departNo) values('11050105','专升本','1105');
insert into major_info(majorNo,major,departNo) values('11050100','应用软件开发方向','1105');
insert into major_info(majorNo,major,departNo) values('11050400','英语方向','1105');

desc class_info;
##delete from class_info;
select * from class_info;
##软件开发方向
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100200903','软件工程0903','软件0903','11050100',44);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100200904','软件工程0904','软件0904','11050100',45);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100200905','软件工程0905','软件0905','11050100',45);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100200906','软件工程0906','软件0906','11050100',46);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100200907','软件工程0907','软件0907','11050100',44);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201001','软件工程1001','软件1001','11050100',44);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201002','软件工程1002','软件1002','11050100',48);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201003','软件工程1003','软件1003','11050100',46);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201004','软件工程1004','软件1004','11050100',46);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201005','软件工程1005','软件1005','11050100',45);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201101','软件工程1101','软件1101','11050100',44);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201102','软件工程1102','软件1102','11050100',43);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201103','软件工程1103','软件1103','11050100',43);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201104','软件工程1104','软件1104','11050100',41);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201201','软件工程1201','软件1201','11050100',37);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201202','软件工程1202','软件1202','11050100',40);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201203','软件工程1203','软件1203','11050100',43);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100201204','软件工程1204','软件1204','11050100',40);


##网络应用方向
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100200901','软件工程0901','软件0901','11050101',47);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100200902','软件工程0902','软件0902','11050101',44);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201006','软件工程1006','软件1006','11050101',44);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201007','软件工程1007','软件1007','11050101',44);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201105','软件工程1105','软件1105','11050101',41);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201106','软件工程1106','软件1106','11050101',43);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201205','软件工程1205','软件1205','11050101',38);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201206','软件工程1206','软件1206','11050101',42);


##数字媒体技术方向
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100200910','软件工程0910','软件0910','11050103',45);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100200911','软件工程0911','软件0911','11050103',47);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201010','软件工程1010','软件1010','11050103',44);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201011','软件工程1011','软件1011','11050103',43);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201107','软件工程1107','软件1107','11050103',43);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201108','软件工程1108','软件1108','11050103',39);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201209','软件工程1209','软件1209','11050103',39);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201210','软件工程1210','软件1210','11050103',37);

##嵌入式系统方向
##delete from class_info where majorNo='11050104';
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100200908','软件工程0908','软件0908','11050104',46);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050100200909','软件工程0909','软件0909','11050104',41);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201008','软件工程1008','软件1008','11050104',47);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201009','软件工程1009','软件1009','11050104',44);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201109','软件工程1109','软件1109','11050104',40);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201110','软件工程1110','软件1110','11050104',41);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201207','软件工程1207','软件1207','11050104',40);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201208','软件工程1208','软件1208','11050104',40);


--英语方向
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201012','软件工程1012','软件1012','11050400',45);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201013','软件工程1013','软件1013','11050400',41);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201014','软件工程1014','软件1014','11050400',37);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201111','软件工程1111','软件1111','11050400',38);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201112','软件工程1112','软件1112','11050400',37);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201113','软件工程1113','软件1113','11050400',38);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201114','软件工程1114','软件1114','11050400',36);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201115','软件工程1115','软件1115','11050400',37);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201211','软件工程1211','软件1211','11050400',42);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201212','软件工程1212','软件1212','11050400',41);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201213','软件工程1213','软件1213','11050400',39);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201214','软件工程1214','软件1214','11050400',40);
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('11050101201215','软件工程1215','软件1215','11050400',38);



select * from political_status;
insert into political_status value(1,'共青团员');
insert into political_status value(2,'中共预备党员');
insert into political_status value(3,'中共党员');
insert into political_status value(4,'群众');
insert into political_status value(5,'其他');
insert into political_status value(6,'不详');