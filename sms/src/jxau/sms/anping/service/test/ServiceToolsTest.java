package jxau.sms.anping.service.test;

import java.util.ArrayList;
import java.util.List;

import jxau.sms.anping.po.ScholarShip;
import jxau.sms.anping.scholarship.service.impl.ScholarShipServiceImpl;
import jxau.sms.anping.util.ServiceTools;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.qing.po.Student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceToolsTest {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	ServiceTools tools = (ServiceTools) context
			.getBean("anpingServiceTools");
	
	@Test
	public void testCheckStudentIsInDataBase(){
		List<ScholarShip> scholarShips = new ArrayList<>();
		ScholarShip ship = new ScholarShip();
		StuBasicInfo student = new StuBasicInfo();
		student.setStudentNo("20111429");
		ship.setStudent(student);
 
		scholarShips.add(ship);
		
		StuBasicInfoVO  vo  = new StuBasicInfoVO();
		vo.setStudentNo("20111429");

		StuBasicInfoVO  vo2  = new StuBasicInfoVO();
		vo2.setStudentNo("20111428");
		
		StuBasicInfoVO  vo3  = new StuBasicInfoVO();
		vo2.setStudentNo("20111428");
		List<StuBasicInfoVO>  infos  = new ArrayList<>();
		
		infos.add(vo2);
		infos.add(vo);
		infos.add(vo3);
		System.out.println(tools.checkStudentIsInDataBase(scholarShips, infos));
	}
}
