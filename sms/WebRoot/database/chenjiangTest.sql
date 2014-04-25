select * from stu_basic_info where exameState='软件1107';
update stu_basic_info set exameState='院级审核中';

select  sbi.* from class_info ai,stu_basic_info sbi where ai.className=sbi.className and ai.teacherNo='1234' and sbi.exameState='院级未通过';


insert into teacher_role values('1805',3);
insert into teacher_role values('1805',4);

select * from tec_info;
insert into tec_info(teacherNo,tecPassword) values('1805','1805');
desc stu_basic_info;
select * from dep_teacher;
insert into dep_teacher values('1105','1805');
select * from class_info;
update class_info set teacherNo = '1805' where classNo='11050101201111';

insert into tec_basic_info values('1805','彭莹琼',1,'汉族','江西萍乡','中共党员','在职','副教授','2012-12-01','2000-09-01','硕士研究生','通过','无');

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


select * from stu_basic_info;
##delete from stu_basic_info;
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111812','王丽秋','1992-10-20','软件工程1111','英语方向','软件学院',1,'汉族','屯昌县','共青团员','460026199210203923','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111813','王忠达','1990-1-29','软件工程1111','英语方向','软件学院',0,'汉族','邯郸市','共青团员','130481199001290055','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111814','邱双旭','1994-4-1','软件工程1111','英语方向','软件学院',0,'汉族','天门市','共青团员','429006199404010674','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111815','罗家清','1992-4-5','软件工程1111','英语方向','软件学院',1,'汉族','上高县','群众','362228199204051822','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111816','谌晨','1993-12-9','软件工程1111','英语方向','软件学院',1,'汉族','青山湖区','共青团员','360121199312095820','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111817','胡旭','1991-10-29','软件工程1111','英语方向','软件学院',0,'汉族','高安市','共青团员','36220419911029841X','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111819','曹雯琪','1994-11-20','软件工程1111','英语方向','软件学院',1,'汉族','崇仁县','共青团员','36252519941120004X','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111821','章苗','1992-8-3','软件工程1111','英语方向','软件学院',1,'汉族','高安市','共青团员','362204199208037824','本科','通过');

insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111822','龚靖淇','1993-6-2','软件工程1111','英语方向','软件学院',0,'汉族','西湖区','共青团员','360111199306023318','本科','通过');

insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111823','陈燕','1991-10-8','软件工程1111','英语方向','软件学院',1,'汉族','高安市','共青团员','362204199110082440','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111824','余盛林','1993-10-1','软件工程1111','英语方向','软件学院',0,'汉族','于都县','共青团员','360731199310018210','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111825','朱克顺','1992-2-10','软件工程1111','英语方向','软件学院',0,'汉族','兴国县','共青团员','360732199202104417','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111826','赖辉强','1993-7-3','软件工程1111','英语方向','软件学院',0,'汉族','宁都县','共青团员','360730199307030618','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111827','邹楚婷','1993-3-20','软件工程1111','英语方向','软件学院',1,'汉族','上栗县','共青团员','360311199303200041','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111828','刘先德','1992-3-9','软件工程1111','英语方向','软件学院',0,'汉族','于都县','共青团员','360731199203091754','本科','通过');
insert into stu_basic_info(studentNo,studentName,birthday,className,major,college,sex,nation,hometown,political,idCard,eduBackground,exameState) values
('20111829','吴文龙','1993-4-1','软件工程1111','英语方向','软件学院',1,'汉族','临川区一','共青团员','361002199304012016','本科','通过');





select *  from dep_info;
##delete from dep_info;
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1105','软件学院','','');
##专业	
insert into major_info(majorNo,major,departNo) values('11050101','网络应用方向','1105');
insert into major_info(majorNo,major,departNo) values('11050102','商务与政务应用方向','1105');
insert into major_info(majorNo,major,departNo) values('11050103','数字媒体技术方向','1105');
insert into major_info(majorNo,major,departNo) values('11050104','嵌入式系统方向','1105');
insert into major_info(majorNo,major,departNo) values('11050105','专升本','1105');
insert into major_info(majorNo,major,departNo) values('11050100','应用软件开发方向','1105');
insert into major_info(majorNo,major,departNo) values('11050400','英语方向','1105');

##软件开发方向
insert into class_info(classNo,className,classBreif,majorNo,classNumber) values('21050100200903','1102','软件0903','11050100',44);
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

##英语方向
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


##农学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1101','农学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11010100','农学','1101');
insert into major_info(majorNo,major,departNo) values('11010101','农产品安全与贸易方向','1101');
insert into major_info(majorNo,major,departNo) values('11010200','园艺','1101');
insert into major_info(majorNo,major,departNo) values('11010201','绿地建植与养护方向','1101');
insert into major_info(majorNo,major,departNo) values('11010300','植物保护','1101');
insert into major_info(majorNo,major,departNo) values('11010301','动植物检疫方向','1101');
insert into major_info(majorNo,major,departNo) values('11010400','农村区域发展','1101');
insert into major_info(majorNo,major,departNo) values('11010500','蚕学','1101');
insert into major_info(majorNo,major,departNo) values('11010600','园艺-观赏园艺方向','1101');
insert into major_info(majorNo,major,departNo) values('11010700','农学','1101');


##动物科学技术学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1103','动物科学技术学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11030100','动物科学','1103');
insert into major_info(majorNo,major,departNo) values('11030200','动物医学','1103');
insert into major_info(majorNo,major,departNo) values('11030300','水产养殖学','1103');
insert into major_info(majorNo,major,departNo) values('11030400','动物药学','1103');
insert into major_info(majorNo,major,departNo) values('11030500','动物科学','1103');


##园林与艺术学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1102','园林与艺术学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11020100','林学','1102');
insert into major_info(majorNo,major,departNo) values('11020200','园林','1102');
insert into major_info(majorNo,major,departNo) values('11020300','城市规划','1102');
insert into major_info(majorNo,major,departNo) values('11020400','艺术设计','1102');
insert into major_info(majorNo,major,departNo) values('11020401','环境艺术设计方向','1102');
insert into major_info(majorNo,major,departNo) values('11020402','电脑艺术设计方向','1102');
insert into major_info(majorNo,major,departNo) values('11020500','中药资源与开发','1102');
insert into major_info(majorNo,major,departNo) values('11020600','林产化工','1102');
insert into major_info(majorNo,major,departNo) values('11020700','林学','1102');


##工学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1104','工学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11040100','农业机械化及其自动化','1104');
insert into major_info(majorNo,major,departNo) values('11040200','机械设计制造及其自动化','1104');
insert into major_info(majorNo,major,departNo) values('11040300','交通运输','1104');
insert into major_info(majorNo,major,departNo) values('11040400','环境与能源工程','1104');
insert into major_info(majorNo,major,departNo) values('11040500','土木工程','1104');
insert into major_info(majorNo,major,departNo) values('11040600','电子信息工程','1104');
insert into major_info(majorNo,major,departNo) values('11040700','工程管理','1104');
insert into major_info(majorNo,major,departNo) values('11040800','机械制造与自动化','1104');
insert into major_info(majorNo,major,departNo) values('11040900','模具设计与制造','1104');
insert into major_info(majorNo,major,departNo) values('11041000','汽车运输工程','1104');
insert into major_info(majorNo,major,departNo) values('11041100','汽车检测与维修技术','1104');
insert into major_info(majorNo,major,departNo) values('11041200','电子信息工程','1104');


##计算机与信息工程学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1106','计算机与信息工程学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11060100','计算机科学与技术','1106');
insert into major_info(majorNo,major,departNo) values('11060101','计算机软件方向','1106');
insert into major_info(majorNo,major,departNo) values('11060102','计算机图形方向','1106');
insert into major_info(majorNo,major,departNo) values('11060103','计算机网络方向','1106');
insert into major_info(majorNo,major,departNo) values('11060200','信息管理与信息系统','1106');
insert into major_info(majorNo,major,departNo) values('11060300','电子商务','1106');
insert into major_info(majorNo,major,departNo) values('11060400','网络工程','1106');
insert into major_info(majorNo,major,departNo) values('11060500','计算机科学与技术(国际班)','1106');
insert into major_info(majorNo,major,departNo) values('11060600','计算机科学与技术','1106');
insert into major_info(majorNo,major,departNo) values('11060700','电子商务双学位','1106');


##经济管理学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1107','经济管理学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11070100','农林经济管理','1107');
insert into major_info(majorNo,major,departNo) values('11070200','经济学','1107');
insert into major_info(majorNo,major,departNo) values('11070201','房地产经营方向','1107');
insert into major_info(majorNo,major,departNo) values('11070202','投资金融方向','1107');
insert into major_info(majorNo,major,departNo) values('11070300','会计学','1107');
insert into major_info(majorNo,major,departNo) values('11070301','注册会计师方向','1107');
insert into major_info(majorNo,major,departNo) values('11070302','国际会计方向','1107');
insert into major_info(majorNo,major,departNo) values('11070400','国际经济与贸易','1107');
insert into major_info(majorNo,major,departNo) values('11070500','工商管理','1107');
insert into major_info(majorNo,major,departNo) values('11070600','财务管理','1107');
insert into major_info(majorNo,major,departNo) values('11070700','市场营销','1107');
insert into major_info(majorNo,major,departNo) values('11070800','金融学','1107');
insert into major_info(majorNo,major,departNo) values('11070801','证券投资与理财方向','1107');
insert into major_info(majorNo,major,departNo) values('11070802','国际金融方向','1107');
insert into major_info(majorNo,major,departNo) values('11070900','劳动与社会保障','1107');
insert into major_info(majorNo,major,departNo) values('11071000','会计学(专升本)','1107');
insert into major_info(majorNo,major,departNo) values('11071100','工商管理双学位','1107');
insert into major_info(majorNo,major,departNo) values('11071200','国际经济与贸易双学位','1107');
insert into major_info(majorNo,major,departNo) values('11071300','会计学双学位','1107');
insert into major_info(majorNo,major,departNo) values('11071400','经济学双学位','1107');
insert into major_info(majorNo,major,departNo) values('11071500','金融学双学位','1107');
insert into major_info(majorNo,major,departNo) values('11071600','会计学(国际班)','1107');
insert into major_info(majorNo,major,departNo) values('11071700','财务管理(专升本)','1107');
insert into major_info(majorNo,major,departNo) values('11071800','会计学双学位','1107');
insert into major_info(majorNo,major,departNo) values('11071900','工商管理双学位','1107');
insert into major_info(majorNo,major,departNo) values('11072000','金融学双学位','1107');


##理学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1108','理学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11080100','应用化学','1108');
insert into major_info(majorNo,major,departNo) values('11080101','分析测试方向','1108');
insert into major_info(majorNo,major,departNo) values('11080102','精细化工方向','1108');
insert into major_info(majorNo,major,departNo) values('11080200','信息与计算科学','1108');
insert into major_info(majorNo,major,departNo) values('11080300','药物合成方向','1108');
insert into major_info(majorNo,major,departNo) values('11080400','材料化学方向','1108');


##人文与公共管理学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1109','人文与公共管理学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11090100','管理科学','1109');
insert into major_info(majorNo,major,departNo) values('11090200','公共事业管理','1109');
insert into major_info(majorNo,major,departNo) values('11090300','汉语言','1109');
insert into major_info(majorNo,major,departNo) values('11090400','音乐表演','1109');
insert into major_info(majorNo,major,departNo) values('11090500','法学','1109');
insert into major_info(majorNo,major,departNo) values('11090600','新闻学','1109');
insert into major_info(majorNo,major,departNo) values('11090700','汉语言文学','1109');
insert into major_info(majorNo,major,departNo) values('11090800','管理科学(五年制)','1109');
insert into major_info(majorNo,major,departNo) values('11090900','法学双学位','1109');
insert into major_info(majorNo,major,departNo) values('11091000','公共事业管理双学位','1109');
insert into major_info(majorNo,major,departNo) values('11091100','法学双学位','1109');


##国土资源与环境学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1110','国土资源与环境学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11100100','土地资源管理','1110');
insert into major_info(majorNo,major,departNo) values('11100200','农业资源与环境','1110');
insert into major_info(majorNo,major,departNo) values('11100300','环境工程','1110');
insert into major_info(majorNo,major,departNo) values('11100400','旅游管理','1110');
insert into major_info(majorNo,major,departNo) values('11100500','环境科学','1110');
insert into major_info(majorNo,major,departNo) values('11100600','地理信息系统','1110');
insert into major_info(majorNo,major,departNo) values('11100601','空间信息处理技术方向','1110');
insert into major_info(majorNo,major,departNo) values('11100700','旅游管理双学位','1110');
insert into major_info(majorNo,major,departNo) values('11100800','房地产经营管理方向','1110');
insert into major_info(majorNo,major,departNo) values('11100900','土地利用规划方向','1110');



##生物科学与工程学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1112','生物科学与工程学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11120100','生物工程','1112');
insert into major_info(majorNo,major,departNo) values('11120200','生物技术','1112');
insert into major_info(majorNo,major,departNo) values('11120201','生物技术(国际班)','1112');
insert into major_info(majorNo,major,departNo) values('11120300','生物科学','1112');
insert into major_info(majorNo,major,departNo) values('11120400','制药工程','1112');


##外国语学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1113','外国语学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11130100','英语','1113');
insert into major_info(majorNo,major,departNo) values('11130200','日语','1113');
insert into major_info(majorNo,major,departNo) values('11130300','英语(专升本)','1113');
insert into major_info(majorNo,major,departNo) values('11130400','英语双学位','1113');
insert into major_info(majorNo,major,departNo) values('11130500','英语双学位-秋季','1113');


##外国语学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1114','食品科学与工程学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11140100','食品科学与工程','1114');
insert into major_info(majorNo,major,departNo) values('11140200','轻化工程','1114');
insert into major_info(majorNo,major,departNo) values('11140201','粮油化工方向','1114');
insert into major_info(majorNo,major,departNo) values('11140202','生物化工方向','1114');
insert into major_info(majorNo,major,departNo) values('11140300','食品质量与安全','1114');
insert into major_info(majorNo,major,departNo) values('11140400','食品添加剂方向','1114');
insert into major_info(majorNo,major,departNo) values('11140500','食品科学与工程(五年制)','1114');
insert into major_info(majorNo,major,departNo) values('11140600','食品质量与安全双学位','1114');



##职业师范（技术）学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1115','职业师范（技术）学院','','');
##专业
insert into major_info(majorNo,major,departNo) values('11150100','应用电子技术','1115');
insert into major_info(majorNo,major,departNo) values('11150200','计算机图形图像制作','1115');
insert into major_info(majorNo,major,departNo) values('11150300','可视化程序设计','1115');
insert into major_info(majorNo,major,departNo) values('11150400','网络系统管理','1115');
insert into major_info(majorNo,major,departNo) values('11150500','电脑艺术设计','1115');
insert into major_info(majorNo,major,departNo) values('11150600','中英文秘书','1115');
insert into major_info(majorNo,major,departNo) values('11150700','旅游与酒店管理','1115');
insert into major_info(majorNo,major,departNo) values('11150800','现代城镇园林绿化','1115');
insert into major_info(majorNo,major,departNo) values('11150900','动物营养与饲料科学','1115');
insert into major_info(majorNo,major,departNo) values('11151000','动物医疗技术','1115');
insert into major_info(majorNo,major,departNo) values('11151100','花卉与环境装饰技术','1115');
insert into major_info(majorNo,major,departNo) values('11151200','会计电算化','1115');
insert into major_info(majorNo,major,departNo) values('11151300','计算机应用技术','1115');
insert into major_info(majorNo,major,departNo) values('11151301','软件应用方向','1115');
insert into major_info(majorNo,major,departNo) values('11151302','网络系统管理方向','1115');
insert into major_info(majorNo,major,departNo) values('11151400','经济管理','1115');
insert into major_info(majorNo,major,departNo) values('11151500','商务英语','1115');
insert into major_info(majorNo,major,departNo) values('11151600','设施农业技术','1115');
insert into major_info(majorNo,major,departNo) values('11151700','食品加工技术','1115');
insert into major_info(majorNo,major,departNo) values('11151800','园艺','1115');
insert into major_info(majorNo,major,departNo) values('11151900','教育技术学','1115');
insert into major_info(majorNo,major,departNo) values('11152000','园林技术','1115');
insert into major_info(majorNo,major,departNo) values('11152100','旅游管理','1115');
insert into major_info(majorNo,major,departNo) values('11152200','饲料与动物营养','1115');
insert into major_info(majorNo,major,departNo) values('11152300','应用化工技术','1115');
insert into major_info(majorNo,major,departNo) values('11152400','营销与策划','1115');
insert into major_info(majorNo,major,departNo) values('11152500','畜禽生产教育','1115');
insert into major_info(majorNo,major,departNo) values('11152600','教育技术','1115');
insert into major_info(majorNo,major,departNo) values('11152700','文秘教育','1115');


##军体部
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1111','军体部','','');

##图书馆
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1116','图书馆','','');

##马克思主义学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1119','马克思主义学院','','');

##商学院
insert into dep_info(departNo,department,departBrief,departInfo) 
	values('1120','商学院','','');

select * from dep_info;

