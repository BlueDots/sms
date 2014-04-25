

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

##call sp_doTotalScoreRank('软件学院','1102','201501');
##select * from stu_class_grant where term='201501';

########################班级奖学金分配奖学金的存储过程####################
drop PROCEDURE if exists sp_doAwardRank;
delimiter //
create  PROCEDURE sp_doAwardRank(college varchar(30),className varchar(30),term  char(6))
begin
  DECLARE done INT DEFAULT 0;
  DECLARE studentNo2 char(8);
  DECLARE term2  char(6);
  DECLARE rank int default 1;
  DECLARE oneLevel2 double default 0;
  DECLARE twoLevel2 double default 0;
  DECLARE threeLevel2 double default 0;
  DECLARE oneCount int;
  DECLARE twoCount int;
  DECLARE threeCount int ;
  DECLARE classMax int default 0;
  DECLARE cur2 CURSOR FOR SELECT student.studentNo,classGrant.term 
  FROM stu_class_grant classGrant ,stu_basic_info student 
  where  classGrant.studentNo=student.studentNo 
  and  classGrant.term=term  and  student.college=college and student.className=className
  and classGrant.remarks is  null
  order by   classGrant.totalScore desc 
  ;
  
  DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;
  
  select oneLevel into oneLevel2
  from  classAwardLevel   limit 0,1;
  select twoLevel into twoLevel2
  from  classAwardLevel   limit 0,1;
  select threeLevel into threeLevel2
  from  classAwardLevel   limit 0,1;
 
  
  select classNumber into classMax from class_info where className=className limit 0,1;
  	
	
  set oneCount=round(oneLevel2*classMax);
  set twoCount=round(twoLevel2*classMax)+oneCount;
  set threeCount=round(classMax*(oneLevel2+twoLevel2+threeLevel2));
 
  
  open cur2;
  
  repeat
  	Fetch cur2 into studentNo2,term2;
  	IF NOT done THEN
  	 
  		IF  rank between 1 and oneCount then
  			update stu_class_grant set rank='一等奖'
  			where studentNo=studentNo2 and term=term2;
  		end IF;
  		IF rank>oneCount and rank<=twoCount then
  			update stu_class_grant set rank='二等奖'
  			where studentNo=studentNo2 and term=term2;
  		end if;
  		
  		IF rank>twoCount and rank<=threeCount then
  			update stu_class_grant set rank='三等奖'
  			where studentNo=studentNo2 and term=term2;
  		end if;
  		set rank=rank+1;
 	end if;
  UNTIL done END REPEAT;
  close cur2;	
end;//
delimiter ;

##call sp_doAwardRank('软件学院','1102','201401');
##select * from stu_class_grant;
##update stu_class_grant set exameState='通过' where studentNo='20111429' and term='201404';

 ## delete from stu_class_grant;
 

