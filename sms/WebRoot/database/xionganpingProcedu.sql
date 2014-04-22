

##################班级奖学金计算排名的存储过程###################

drop PROCEDURE if exists sp_doTotalScoreRank;
delimiter //
create  PROCEDURE sp_doTotalScoreRank(college varchar(30),className varchar(30),term  char(6))
begin
  DECLARE done INT DEFAULT 0;
  DECLARE studentNo2 char(8);
  DECLARE term2  char(6);
  DECLARE rank int default 1;
  
  DECLARE cur1 CURSOR FOR SELECT student.studentNo,classGrant.term 
  FROM stu_class_grant classGrant ,stu_basic_info student 
  where  classGrant.studentNo=student.studentNo 
  and  classGrant.term=term  and  student.college=college and student.className=className
  order by classGrant.totalScore desc ,classGrant.qualityScore desc,classGrant.moralQualityAssessmentScore desc,
  classGrant.artEducationTotalScore desc ,classGrant.sportQualityTotalScore desc;
  DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;
  open cur1;
  repeat
  	Fetch cur1 into studentNo2,term2;
  	IF NOT done THEN
  		update stu_class_grant set totalScoreRank=rank
  		where studentNo=studentNo2 and term=term;
  		set rank=rank+1;
 	end if;
  UNTIL done END REPEAT;
  close cur1;	
end;//
delimiter ;

##call sp_doTotalScoreRank('软件学院','1102','201401');
##select * from stu_class_grant;

########################班级奖学金分配奖学金的存储过程####################
drop PROCEDURE if exists sp_doAwardRank;
delimiter //
create  PROCEDURE sp_doAwardRank(college varchar(30),className varchar(30),term  char(6))
begin
  DECLARE done INT DEFAULT 0;
  DECLARE studentNo2 char(8);
  DECLARE term2  char(6);
  DECLARE rank int default 1;
  DECLARE 
  DECLARE cur1 CURSOR FOR SELECT student.studentNo,classGrant.term 
  FROM stu_class_grant classGrant ,stu_basic_info student 
  where  classGrant.studentNo=student.studentNo 
  and  classGrant.term=term  and  student.college=college and student.className=className
  order by 
  ;
  
  DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;
  open cur1;
  
  repeat
  	Fetch cur1 into studentNo2,term2;
  	IF NOT done THEN
  		update stu_class_grant set totalScoreRank=rank
  		where studentNo=studentNo2 and term=term;
  		set rank=rank+1;
 	end if;
  UNTIL done END REPEAT;
  close cur1;	
end;//
delimiter ;


