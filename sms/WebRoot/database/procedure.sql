--1ѧ��������Ϣ���������(eState:Ժ�������,У�������)
DELIMITER //
create procedure verifyNumsOfStuBasicInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_basic_info where exameState=eState ;
end
//
DELIMITER ;

set @eState='Ժ�������';
call verifyNumsOfStuBasicInfo(@eState,@ns);
select @ns;

update stu_basic_info set exameState = 'Ժ�������' where studentNo 
 in ('20111367','20111429','20111635');
 
DROP PROCEDURE verifyNumsOfStuBasicInfo;

--2��ʦ������Ϣ���������(eState:Ժ�������,У�������)
DELIMITER //
create procedure verifyNumsOfTecBasicInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from tec_basic_info  where exameState=eState ;
end
//
DELIMITER ;

--3ѧ��������Ϣ���������(eState:Ժ�������,У�������)
DELIMITER //
create procedure verifyNumsOfStuActParticipate(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_act_participate s where exameState=eState ;
end
//
DELIMITER ;

--4�������������(eState:Ժ�������,У�������)
DELIMITER //
create procedure verifyNumsOfActInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from act_info  where exameState=eState ;
end
//
DELIMITER ;


--5�������ȴ��������(eState:Ժ�������,У�������)
DELIMITER //
create procedure verifyNumsOfStuAdvInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_adv_info where exameState=eState ;
end
//
DELIMITER ;

--6����ѧ����������(eState:Ժ�������,У�������)
DELIMITER //
create procedure verifyNumsOfStuGrantInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_grant_info  where exameState=eState ;
end
//
DELIMITER ;

--7��ѧ���������������(eState:Ժ�������,У�������)
DELIMITER //
create procedure verifyNumsOfStuClassGrant(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_class_grant  where exameState=eState ;
end
//
DELIMITER ;


--8������Ϣ������������(eState:Ժ�������,У�������)
DELIMITER //
create procedure verifyNumsOfDisInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from dis_info where exameState=eState ;
end
//
DELIMITER ;


--9ѧ���䶯��Ϣ���������(eState:Ժ�������,У�������)
DELIMITER //
create procedure verifyNumsOfStaChangeInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from sta_change_info where exameState=eState ;
end
//
DELIMITER ;


--10ƶ��������ģ����������(eState:Ժ�������,У�������)
DELIMITER //
create procedure verifyNumsOfStuDesInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from stu_des_info where exameState=eState ;
end
//
DELIMITER ;


--11ҽ��ģ����������(eState:Ժ�������,У�������)
DELIMITER //
create procedure verifyNumsOfHosInsuranceInfo(IN eState varchar(30),
										  OUT nums int)
begin 
	select count(*) into nums from hos_insurance_info where veritystate=eState ;
end
//
DELIMITER ;
