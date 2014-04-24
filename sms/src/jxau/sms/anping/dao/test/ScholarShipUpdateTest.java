package jxau.sms.anping.dao.test;

import jxau.sms.anping.po.ScholarShip;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.globaldao.Dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScholarShipUpdateTest {
	ApplicationContext app = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	String namespace = "jxau.sms.anping.scholarship.dao.";
	Dao dao = (Dao) app.getBean("dao");
	
	@Test
	public void testUpdateScholarShip(){
		ScholarShip  ship  = new ScholarShip();
		StuBasicInfo  stuBasicInfo = new StuBasicInfo();
		stuBasicInfo.setStudentNo("20111430");
		ship.setStudent(stuBasicInfo);
		ship.setTerm("201404");
 ;
	 
		ship.setManageScore(100);
		ship.setCultureScore(19);
		ship.setMediaScore(199);
		ship.setServiceScore(100);
		dao.update(namespace+"updateScholarShipByTeacher",ship);
	}
}
