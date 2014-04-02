drop table if exists class_award_info;
drop table if exists stu_class_grant;

##创建奖学金等级表
create table class_award_info(
	awardNo int primary key auto_increment,
	awardLevel varchar(21),
	awardState tinyint default 1
)engine=MYISAM;

##创建的是班级奖学金表
create table stu_class_grant(
	studentNo char(8),
	term char(6),
	baseScore double,
	awardScore double,
	punishScore double,
	moralQualityAssessmentScore double,
	moralQualityAssessmentRank int,
	lessonScore double,
	innovateScore double,
	skillsScore double,
	qualityScore double,
	qualityRank int,
	sportScore double,
	physiqueScore double,
	sportMatchScore double,
	sportQualityTotalScore double,
	sportQualityRank int,
	manageScore	double,
	cultureScore	double,
	mediaScore double,
	serviceScore	double,
	artEducationTotalScore	 double,
	artEducationTotalRank int,
	totalScore double,
	totalScoreRank int,
	rank tinyint,
	remarks varchar(150),
	exameState varchar(30),
	classGrantState int default 1,
	primary key(studentNo,term)
)engine=innodb;
alter table stu_class_grant
add foreign key (studentNo) references stu_basic_info(studentNo)
on delete no action on update cascade;


##创建院级奖学金统计表
create table dep_statistical(
	term varchar(20),
	depNo char(4),
    oneLevel double,
    twoLevel  double,
    threeLevel double,
    primary key(term,depNo)
)engine=innodb;
alter table 	dep_statistical
add foreign key(depNo) references dep_info(departNo)
on delete no action on update cascade;
##创建班级奖学金统计表
create table class_statistical(
	term varchar(20),
	classNo char(4),
    oneLevel double,
    twoLevel  double,
    threeLevel double,
    primary key(term,classNo)
)engine=innodb;
alter table 	class_statistical
add foreign key(classNo) references class_info(classNo)
on delete no action on update cascade;
