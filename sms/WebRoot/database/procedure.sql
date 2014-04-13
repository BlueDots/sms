--1学生基本信息待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfStuBasicInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_basic_info where exameState=eState ;
end
//
DELIMITER ;

set @eState='院级审核中';
call verifyNumsOfStuBasicInfo(@eState,@ns);
select @ns;

update stu_basic_info set exameState = '院级审核中' where studentNo 
 in ('20111367','20111429','20111635');
 
DROP PROCEDURE verifyNumsOfStuBasicInfo;

--2教师基本信息待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfTecBasicInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from tec_basic_info  where exameState=eState ;
end
//
DELIMITER ;

--3学生参与活动信息待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfStuActParticipate(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_act_participate s where exameState=eState ;
end
//
DELIMITER ;

--4活动管理待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfActInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from act_info  where exameState=eState ;
end
//
DELIMITER ;


--5评优评先待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfStuAdvInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_adv_info where exameState=eState ;
end
//
DELIMITER ;

--6奖助学金待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfStuGrantInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_grant_info  where exameState=eState ;
end
//
DELIMITER ;

--7奖学金评定待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfStuClassGrant(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_class_grant  where exameState=eState ;
end
//
DELIMITER ;


--8处分信息管理待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfDisInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from dis_info where exameState=eState ;
end
//
DELIMITER ;


--9学籍变动信息待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfStaChangeInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from sta_change_info where exameState=eState ;
end
//
DELIMITER ;


--10贫困生建档模块待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfStuDesInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_des_info where exameState=eState ;
end
//
DELIMITER ;


--11医保模块待审核人数(eState:院级审核中,校级审核中)
DELIMITER //
create procedure verifyNumsOfHosInsuranceInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from hos_insurance_info where veritystate=eState ;
end
//
DELIMITER ;
