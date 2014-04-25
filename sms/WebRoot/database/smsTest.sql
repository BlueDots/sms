
##学生登录信息
insert into stu_info values(20111812,'123456',4,'mm',1);
##学生基本信息
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

##学院专业班级信息
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
	
##评优评先信息
select * from stu_adv_Info;
insert into stu_adv_Info values(null,'20111812','优秀三好学生','省级','201301','通过','无');
insert into stu_adv_Info values(null,'20111813','优秀学生干部','省级','201302','通过','无');
insert into stu_adv_Info values(null,'20111814','优秀共青团员','院级','201301','通过','无');


############################班级奖学金的测试数据###########################

insert into stu_class_grant(studentNo,term,baseScore,awardScore,punishScore,moralQualityAssessmentScore,
moralQualityAssessmentRank,lessonScore,innovateScore,skillsScore,qualityScore,qualityRank,sportScore,physiqueScore,
sportMatchScore,sportQualityTotalScore,sportQualityRank,manageScore,cultureScore,mediaScore,serviceScore,
artEducationTotalScore,artEducationTotalRank,totalScore,totalScoreRank,rank,remarks,exameState,classGrantState
) 
values('20111812','201401',60,0,0,12,0,
60,0,0,36,0,
60,0,0,3,0,
60,0,0,0,9,0,60,10,'三等奖',null,'院级审核中','1'
);




insert into stu_class_grant(studentNo,term,baseScore,awardScore,punishScore,moralQualityAssessmentScore,
moralQualityAssessmentRank,lessonScore,innovateScore,skillsScore,qualityScore,qualityRank,sportScore,physiqueScore,
sportMatchScore,sportQualityTotalScore,sportQualityRank,manageScore,cultureScore,mediaScore,serviceScore,
artEducationTotalScore,artEducationTotalRank,totalScore,totalScoreRank,rank,remarks,exameState,classGrantState
) 
values('20111813','201401',61,0,0,12.2,0,
61,0,0,36.6,0,
61,0,0,3.05,0,
61,0,0,0,9.15,0,61,9,'三等奖',null,'院级审核中','1'
);

insert into stu_class_grant(studentNo,term,baseScore,awardScore,punishScore,moralQualityAssessmentScore,
moralQualityAssessmentRank,lessonScore,innovateScore,skillsScore,qualityScore,qualityRank,sportScore,physiqueScore,
sportMatchScore,sportQualityTotalScore,sportQualityRank,manageScore,cultureScore,mediaScore,serviceScore,
artEducationTotalScore,artEducationTotalRank,totalScore,totalScoreRank,rank,remarks,exameState,classGrantState
) 
values('20111814','201401',62,0,0,12.4,0,
62,0,0,37.2,0,
62,0,0,3.1,0,
62,0,0,0,9.3,0,62,8,'三等奖',null,'院级审核中','1'
);

insert into stu_class_grant(studentNo,term,baseScore,awardScore,punishScore,moralQualityAssessmentScore,
moralQualityAssessmentRank,lessonScore,innovateScore,skillsScore,qualityScore,qualityRank,sportScore,physiqueScore,
sportMatchScore,sportQualityTotalScore,sportQualityRank,manageScore,cultureScore,mediaScore,serviceScore,
artEducationTotalScore,artEducationTotalRank,totalScore,totalScoreRank,rank,remarks,exameState,classGrantState
) 
values('20111815','201401',63,0,0,12.6,0,
63,0,0,37.8,0,
63,0,0,3.15,0,
63,0,0,0,9.45,0,63,7,'二等奖',null,'院级审核中','1'
);

insert into stu_class_grant(studentNo,term,baseScore,awardScore,punishScore,moralQualityAssessmentScore,
moralQualityAssessmentRank,lessonScore,innovateScore,skillsScore,qualityScore,qualityRank,sportScore,physiqueScore,
sportMatchScore,sportQualityTotalScore,sportQualityRank,manageScore,cultureScore,mediaScore,serviceScore,
artEducationTotalScore,artEducationTotalRank,totalScore,totalScoreRank,rank,remarks,exameState,classGrantState
) 
values('20111816','201401',64,0,0,12.8,0,
64,0,0,38.4,0,
64,0,0,3.2,0,
64,0,0,0,9.6,0,64,6,'二等奖',null,'院级审核中','1'
);


insert into stu_class_grant(studentNo,term,baseScore,awardScore,punishScore,moralQualityAssessmentScore,
moralQualityAssessmentRank,lessonScore,innovateScore,skillsScore,qualityScore,qualityRank,sportScore,physiqueScore,
sportMatchScore,sportQualityTotalScore,sportQualityRank,manageScore,cultureScore,mediaScore,serviceScore,
artEducationTotalScore,artEducationTotalRank,totalScore,totalScoreRank,rank,remarks,exameState,classGrantState
) 
values('20111817','201401',65,0,0,13,0,
65,0,0,39,0,
65,0,0,3.25,0,
65,0,0,0,9.75,0,65,5,'二等奖',null,'院级审核中','1'
);

insert into stu_class_grant(studentNo,term,baseScore,awardScore,punishScore,moralQualityAssessmentScore,
moralQualityAssessmentRank,lessonScore,innovateScore,skillsScore,qualityScore,qualityRank,sportScore,physiqueScore,
sportMatchScore,sportQualityTotalScore,sportQualityRank,manageScore,cultureScore,mediaScore,serviceScore,
artEducationTotalScore,artEducationTotalRank,totalScore,totalScoreRank,rank,remarks,exameState,classGrantState
) 
values('20111819','201401',67,0,0,13.4,0,
67,0,0,40.2,0,
67,0,0,3.35,0,
67,0,0,0,10.05,0,67,5,'二等奖',null,'院级审核中','1'
);


insert into stu_class_grant(studentNo,term,baseScore,awardScore,punishScore,moralQualityAssessmentScore,
moralQualityAssessmentRank,lessonScore,innovateScore,skillsScore,qualityScore,qualityRank,sportScore,physiqueScore,
sportMatchScore,sportQualityTotalScore,sportQualityRank,manageScore,cultureScore,mediaScore,serviceScore,
artEducationTotalScore,artEducationTotalRank,totalScore,totalScoreRank,rank,remarks,exameState,classGrantState
) 
values('20111821','201401',68,0,0,13.6,0,
68,0,0,40.8,0,
68,0,0,3.4,0,
68,0,0,0,10.2,0,68,4,'二等奖',null,'院级审核中','1'
);

insert into stu_class_grant(studentNo,term,baseScore,awardScore,punishScore,moralQualityAssessmentScore,
moralQualityAssessmentRank,lessonScore,innovateScore,skillsScore,qualityScore,qualityRank,sportScore,physiqueScore,
sportMatchScore,sportQualityTotalScore,sportQualityRank,manageScore,cultureScore,mediaScore,serviceScore,
artEducationTotalScore,artEducationTotalRank,totalScore,totalScoreRank,rank,remarks,exameState,classGrantState
) 
values('20111822','201401',70,0,0,14,0,
70,0,0,42,0,
70,0,0,3.5,0,
70,0,0,0,10.5,0,70,3,'二等奖',null,'院级审核中','1'
);
 
insert into stu_class_grant(studentNo,term,baseScore,awardScore,punishScore,moralQualityAssessmentScore,
moralQualityAssessmentRank,lessonScore,innovateScore,skillsScore,qualityScore,qualityRank,sportScore,physiqueScore,
sportMatchScore,sportQualityTotalScore,sportQualityRank,manageScore,cultureScore,mediaScore,serviceScore,
artEducationTotalScore,artEducationTotalRank,totalScore,totalScoreRank,rank,remarks,exameState,classGrantState
) 
values('20111823','201401',80,0,0,16,0,
80,0,0,48,0,
80,0,0,4,0,
80,0,0,0,12,0,80,2,'一等奖',null,'院级审核中','1'
);

 
insert into stu_class_grant(studentNo,term,baseScore,awardScore,punishScore,moralQualityAssessmentScore,
moralQualityAssessmentRank,lessonScore,innovateScore,skillsScore,qualityScore,qualityRank,sportScore,physiqueScore,
sportMatchScore,sportQualityTotalScore,sportQualityRank,manageScore,cultureScore,mediaScore,serviceScore,
artEducationTotalScore,artEducationTotalRank,totalScore,totalScoreRank,rank,remarks,exameState,classGrantState
) 
values('20111824','201401',90,0,0,18,0,
90,0,0,54,0,
90,0,0,4.5,0,
90,0,0,0,13.5,0,90,1,'一等奖',null,'院级审核中','1'
);
 
 
###############################医保数据###########################################
 
insert into hos_insurance_info(studentNo,hosType,hospitalAddress,hospitalDate,
leaveDate,hosDate,localCity,conditon,cost,applyTime,accept,collarCard,
submitTime,refuseReason,resultDeal,companyRemark,reimbursementAmount,
bill,getcardTime,jumingRemark,bankcardID,complete,insurerTime,
notinsurerReason,baoxiaoRemark,stateRemark,returnMark,hosState)
values('20111812','居民医保住院未刷卡','南昌医院','2014-02-06','2014-02-08',
2,1,'高血压',100,'2013-09-06',0,0,'2014-09-10','直接报人寿','','',100,1,
'2014-10-2','','177226384628',1,'2014-09-10','','','','','校级审核中'
);
 
insert into hos_insurance_info(studentNo,hosType,hospitalAddress,hospitalDate,
leaveDate,hosDate,localCity,conditon,cost,applyTime,accept,collarCard,
submitTime,refuseReason,resultDeal,companyRemark,reimbursementAmount,
bill,getcardTime,jumingRemark,bankcardID,complete,insurerTime,
notinsurerReason,baoxiaoRemark,stateRemark,returnMark,hosState)
values('20111812','居民医保住院未刷卡','江农医院','2014-02-06','2014-02-08',
2,1,'高血压1',100,'2013-09-03',0,0,'2014-09-10','直接报人寿','','',100,1,
'2014-10-2','','177226384628',1,'2014-09-10','','','','','校级审核中'
);

insert into hos_insurance_info(studentNo,hosType,hospitalAddress,hospitalDate,
leaveDate,hosDate,localCity,conditon,cost,applyTime,accept,collarCard,
submitTime,refuseReason,resultDeal,companyRemark,reimbursementAmount,
bill,getcardTime,jumingRemark,bankcardID,complete,insurerTime,
notinsurerReason,baoxiaoRemark,stateRemark,returnMark,hosState)
values('20111812','居民医保住院已刷卡','江农医院','2014-02-06','2014-02-08',
2,1,'高血压3',100,'2013-09-08',0,0,'2014-09-10','直接报人寿','','',100,1,
'2014-10-2','','177226384628',1,'2014-09-10','','','','','校级审核中'
);

insert into hos_insurance_info(studentNo,hosType,hospitalAddress,hospitalDate,
leaveDate,hosDate,localCity,conditon,cost,applyTime,accept,collarCard,
submitTime,refuseReason,resultDeal,companyRemark,reimbursementAmount,
bill,getcardTime,jumingRemark,bankcardID,complete,insurerTime,
notinsurerReason,baoxiaoRemark,stateRemark,returnMark,hosState)
values('20111813','大病医保未刷卡','北京医院','2014-02-06','2014-02-08',
2,1,'高血压2',100,'2013-09-08',0,0,'2014-09-10','直接报人寿','','',100,1,
'2014-10-2','','177226384628',1,'2014-09-10','','','','','校级审核中'
);


insert into hos_insurance_info(studentNo,hosType,hospitalAddress,hospitalDate,
leaveDate,hosDate,localCity,conditon,cost,applyTime,accept,collarCard,
submitTime,refuseReason,resultDeal,companyRemark,reimbursementAmount,
bill,getcardTime,jumingRemark,bankcardID,complete,insurerTime,
notinsurerReason,baoxiaoRemark,stateRemark,returnMark,hosState)
values('20111813','居民医保住院已刷卡','北京医院','2014-02-06','2014-02-08',
2,1,'高血压4',100,'2013-09-08',0,0,'2014-09-10','','','',100,1,
'2014-10-2','','177226384628',1,'2014-09-10','','','','','通过'
);


insert into hos_insurance_info(studentNo,hosType,hospitalAddress,hospitalDate,
leaveDate,hosDate,localCity,conditon,cost,applyTime,accept,collarCard,
submitTime,refuseReason,resultDeal,companyRemark,reimbursementAmount,
bill,getcardTime,jumingRemark,bankcardID,complete,insurerTime,
notinsurerReason,baoxiaoRemark,stateRemark,returnMark,hosState)
values('20111813','居民医保住院已刷卡','北京军医院','2014-02-06','2014-02-08',
2,1,'胃病',100,'2013-09-08',0,0,'2014-09-10','','','',100,1,
'2014-10-2','','177226384628',1,'2014-09-10','','','','','通过'
);

 
 
insert into hos_insurance_info(studentNo,hosType,hospitalAddress,hospitalDate,
leaveDate,hosDate,localCity,conditon,cost,applyTime,accept,collarCard,
submitTime,refuseReason,resultDeal,companyRemark,reimbursementAmount,
bill,getcardTime,jumingRemark,bankcardID,complete,insurerTime,
notinsurerReason,baoxiaoRemark,stateRemark,returnMark,hosState)
values('20111814','居民医保住院已刷卡','北京军医院','2014-02-06','2014-02-08',
2,1,'感冒',100,'2013-09-08',0,0,'2014-09-10','','','',100,1,
'2014-10-2','','177226384628',1,'2014-09-10','','','','','校级未通过'
);

insert into hos_insurance_info(studentNo,hosType,hospitalAddress,hospitalDate,
leaveDate,hosDate,localCity,conditon,cost,applyTime,accept,collarCard,
submitTime,refuseReason,resultDeal,companyRemark,reimbursementAmount,
bill,getcardTime,jumingRemark,bankcardID,complete,insurerTime,
notinsurerReason,baoxiaoRemark,stateRemark,returnMark,hosState)
values('20111814','居民医保住院已刷卡','家里蹲医院','2014-02-06','2014-02-08',
2,1,'头晕',100,'2013-09-08',0,0,'2014-09-10','','','',100,1,
'2014-10-2','','177226384628',1,'2014-09-10','','','','','校级未通过'
);

##权限信息

insert into purview_info values(1,null,'功能模块','null');
insert into purview_info values(2,1,'学生基本信息模块','/StuBasicInfoAction!loadTeacher');
insert into purview_info values(3,1,'教师基本信息模块','/files/university/sch_teacherBasicInfo.jsp');
insert into purview_info values(4,1,'评优评先模块','/class_advanceInfo.jsp');
insert into purview_info values(5,1,'奖助学信息模块','/files/university/sch_scholarshipInfo.html');
insert into purview_info values(6,1,'学生参与活动模块','/files/university/sch_activityInfo.html');
insert into purview_info values(7,1,'活动管理模块','/files/university/sch_activityManage.html');
insert into purview_info values(8,1,'班级奖学金模块','');
insert into purview_info values(9,1,'医保信息模块','/hosInsuranceInfo!getAllHosByTeacher');
insert into purview_info values(10,1,'贫困生建档模块','/files/university/sch_jiandang.html');
insert into purview_info values(11,1,'个人简历模块','');
insert into purview_info values(12,1,'学生就业信息模块','');
insert into purview_info values(13,1,'处分信息模块','/files/university/sch_punishInfo.html');
insert into purview_info values(14,1,'学籍变动信息模块','');
insert into purview_info values(15,1,'角色管理模块','/role!roleExecute');
insert into purview_info values(16,1,'分配角色管理模块','/allocation!tecRoleDisplay');
insert into purview_info values(17,1,'分配权限模块','');
insert into purview_info values(18,1,'院系专业班级管理模块','');
insert into purview_info values(19,15,'添加角色','');
insert into purview_info values(20,15,'删除角色','');
insert into purview_info values(21,15,'查看角色权限','');
insert into purview_info values(22,16,'查询教师角色信息','');
insert into purview_info values(23,16,'教师分配角色','');
insert into purview_info values(24,16,'教师移除角色','');
insert into purview_info values(25,2,'学生基本信息审核','/StuBasicInfoVerifyAction!gainWaitingForClassName');
insert into purview_info values(26,2,'录入学生基本信息','/StuBasicInfoAction!entryStuBasicInfoLists');
insert into purview_info values(27,9,'查询医保信息','/hosInsuranceQuery!getAllHosByTeacher');
insert into purview_info values(28,9,'录入医保信息','/hosInsuranceInfo!updateHoss');
insert into purview_info values(29,9,'审核医保','/hosInsuranceInfo!checkHosByTeacher');
insert into purview_info values(30,4,'导入评优评先信息','');
insert into purview_info values(31,4,'导出评优评先信息','');
insert into purview_info values(32,4,'比例分配','');
insert into purview_info values(33,4,'添加评优评先记录','');
insert into purview_info values(34,2,'修改学生基本信息','');
insert into purview_info values(35,3,'导入教师基本信息','');
insert into purview_info values(36,3,'审核教师基本信息','');
insert into purview_info values(37,8,'查询学生奖学金信息','');
insert into purview_info values(38,8,'添加班级奖学金信息','');
insert into purview_info values(39,5,'添加奖学金项目','');
insert into purview_info values(40,10,'班级贫困生比例分配','');
##角色信息
insert into role_info values(null,'校级管理员',now(),'校级管理员角色,默认拥有系统所有权限');
insert into role_info values(null,'学生',now(),'学生角色，固定权限');
insert into role_info values(null,'班主任',now(),'班主任角色，负责某班级');
insert into role_info values(null,'院级工作人员1',now(),'院级工作人员之一，主要负责某院系贫困生建档等');
insert into role_info values(null,'院级工作人员2',now(),'院级工作人员之一，主要负责某院系奖惩信息');
insert into role_info values(null,'院级工作人员3',now(),'院级工作人员之一，主要负责某院系基本信息管理');
insert into role_info values(null,'校级工作人员1',now(),'校级工作人员之一，主要负责全校医保等');
insert into role_info values(null,'校级工作人员2',now(),'校级工作人员之一，主要负责全校系奖惩信息');
insert into role_info values(null,'校级工作人员3',now(),'校级工作人员之一，主要负责全校系基本信息管理');
insert into role_info values(null,'院级管理员',now(),'院级管理员角色，每院有且只有一名');
insert into role_info values(null,'活动负责人',now(),'活动管理中的特殊角色');
##学生简历
insert into act_info values (null,'江西农业大学软件创新设计大赛','科技类','校级','校团委','软件学院',null,'陈振清',CURDATE(),null,null,null,1);      /* 活动表 */
insert into stu_act_participate values(null,'20111812',1,9,CURDATE(),'一等奖','科技部部长',CURDATE(),null,null,1);
insert into stu_grant_info values(null,'20111812','国家奖学金','国家',8000,'20131','','');
##教师登录信息
insert into tec_info values('1801','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1802','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1803','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1804','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1805','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1806','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1807','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1808','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1809','123456','您父亲的姓名？','曹国平',1);
insert into tec_info values('1810','123456','您父亲的姓名？','曹国平',0);
##教师基本信息
insert into tec_basic_info values('1801','王映龙',0,'汉族','江西萍乡','中共党员','在职','教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1802','邓泓',0,'汉族','江西赣州','中共党员','在职','副教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1803','李佳航',1,'汉族','江西南昌','中共党员','在职','副教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1804','艾施荣',0,'汉族','江西萍乡','中共党员','在职','教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1805','彭莹琼',1,'汉族','江西萍乡','中共党员','在职','副教授','2012-12-01','2000-09-01','硕士研究生','通过','无');
insert into tec_basic_info values('1806','胡昶',0,'汉族','江西萍乡','中共党员','在职','副教授','2012-12-01','2000-09-01','硕士研究生','通过','无');
insert into tec_basic_info values('1807','吴沧海',1,'汉族','江西萍乡','中共党员','在职','教授','2012-12-01','2000-09-01','硕士研究生','通过','无');
insert into tec_basic_info values('1808','邓松',0,'汉族','江西萍乡','中共党员','在职','副教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1809','庞咏兰',1,'汉族','四川武昌','中共党员','在职','副教授','2012-12-01','2000-09-01','博士研究生','通过','无');
insert into tec_basic_info values('1810','杨键川',0,'汉族','吉林长春','中共党员','在职','副教授','2012-12-01','2000-09-01','博士研究生','通过','无');

##test
select * from role_info;
select * from stu_info;
insert into teacher_role values('1805',3);		 ##班主任
insert into teacher_role values('1806',4);		 ##院级工作人员
insert into teacher_role values('1801',1);       ##超级管理工作人员
insert into dep_teacher values('1105','1805');   ##班主任指定院系
insert into dep_teacher values('1105','1806');	 ##院级工作人员指定院系
update class_info set teacherNo = '1805' where classNo='11050101201111'; ##班级指定班主任

##1学生基本信息待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfStuBasicInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_basic_info where exameState=eState ;
end
//
DELIMITER ;