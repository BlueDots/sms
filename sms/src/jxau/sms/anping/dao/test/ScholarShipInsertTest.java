package jxau.sms.anping.dao.test;

import java.util.ArrayList;
import java.util.List;

import jxau.sms.anping.po.ScholarShip;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.globaldao.Dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScholarShipInsertTest {
	ApplicationContext app = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	String namespace = "jxau.sms.anping.scholarship.dao.";
	Dao dao = (Dao) app.getBean("dao");
	
	
	@Test
	public void testSelectScholarShip(){
		List<ScholarShip> ships =   dao.select(namespace+"selectScholarShipByCondition",null);
		for(ScholarShip ship :ships){
		System.out.println(ship.getTerm());
		System.out.println(ship.getAwardScore());
		System.out.println(ship.getPunishScore());
		System.out.println(ship.getStudent().getStudentNo());
		System.out.println(ship.getStudent().getStudentName());
		}
	}
	
	
	//测试批量插入
	@Test
	public void testBatchInsertSchloarShip(){
		ScholarShip  ship  = new ScholarShip();
		StuBasicInfo  stuBasicInfo = new StuBasicInfo();
		stuBasicInfo.setStudentNo("20111430");
		ship.setStudent(stuBasicInfo);
		ship.setTerm("201401");
		ship.setBaseScore(80);
		ship.setAwardScore(90);
		ship.setPunishScore(90);
		 
		ship.setLessonScore(90);
		ship.setInnovateScore(90);
		ship.setSkillsScore(80);
		 
		ship.setSportScore(60);
		ship.setPhysiqueScore(12);
		ship.setSportMatchScore(19);
	 
		ship.setManageScore(100);
		ship.setCultureScore(19);
		ship.setMediaScore(199);
		ship.setServiceScore(20);
	
		ScholarShip  ship2  = new ScholarShip();
		StuBasicInfo  stuBasicInfo2 = new StuBasicInfo();
		stuBasicInfo2.setStudentNo("20111431");
		ship2.setStudent(stuBasicInfo2);
		ship2.setTerm("201401");
		ship2.setBaseScore(80);
		ship2.setAwardScore(90);
		ship2.setPunishScore(90);
		 
		ship2.setLessonScore(90);
		ship2.setInnovateScore(90);
		ship2.setSkillsScore(80);
		 
		ship2.setSportScore(60);
		ship2.setPhysiqueScore(12);
		ship2.setSportMatchScore(19);
	 
		ship2.setManageScore(100);
		ship2.setCultureScore(19);
		ship2.setMediaScore(199);
		ship2.setServiceScore(20);
		
		List<ScholarShip> scholarShip = new ArrayList<ScholarShip>();
		scholarShip.add(ship);
		scholarShip.add(ship2);
	   dao.add(namespace+"addScholarShipByBatch", scholarShip);
		
	}
	
	@Test
	public void testInsertSchloarShip(){
		ScholarShip  ship  = new ScholarShip();
		StuBasicInfo  stuBasicInfo = new StuBasicInfo();
		stuBasicInfo.setStudentNo("20111429");
		ship.setStudent(stuBasicInfo);
		ship.setTerm("201401");
		ship.setBaseScore(80);
		ship.setAwardScore(90);
		ship.setPunishScore(90);
		 
		ship.setLessonScore(90);
		ship.setInnovateScore(90);
		ship.setSkillsScore(80);
		 
		ship.setSportScore(60);
		ship.setPhysiqueScore(12);
		ship.setSportMatchScore(19);
	 
		ship.setManageScore(100);
		ship.setCultureScore(19);
		ship.setMediaScore(199);
		ship.setServiceScore(20);
		dao.add(namespace+"insertScholarShip", ship);
		
	}
	@Test
	public void selectScholarShip(){
	//	dao.select("", params);
	}
}
