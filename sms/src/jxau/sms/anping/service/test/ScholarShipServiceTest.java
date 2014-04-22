package jxau.sms.anping.service.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.anping.po.ScholarShip;
import jxau.sms.anping.scholarship.service.impl.ScholarShipServiceImpl;
import jxau.sms.anping.service.ScholarShipService;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.qing.po.Student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScholarShipServiceTest {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ScholarShipServiceImpl scholarShipService = (ScholarShipServiceImpl) context.getBean("scholarShip");
	
	@Test
	public void testServiceCheckStudentNoIsChongFu(){
		List<ScholarShip> scholarShips = new ArrayList<ScholarShip>();
		ScholarShip scholarShip  = new ScholarShip();
		ScholarShip scholarShip2  = new ScholarShip();
		StuBasicInfo  basicInfo =  new StuBasicInfo();
		basicInfo.setStudentNo("20111429");
		StuBasicInfo  basicInfo2 =  new StuBasicInfo();
		basicInfo.setStudentNo("20131429");
		scholarShip.setStudent(basicInfo);
		scholarShip2.setStudent(basicInfo2);
		scholarShips.add(scholarShip);
		scholarShips.add(scholarShip2);
		
		//System.out.println(scholarShipService.checkStudentNoIsDulipe(scholarShips));
	}
	
	@Test
	public void testSelectSchloarShipAboutAwardRank(){
		//scholarShipService.doAwardRand("软件学院","1102", "201401");
	}
	
	/**
	 * 对service的测试　
	 * 测试通过学号和学期来获取数据
	 * anping
	 * TODO
	 * 上午11:40:21
	 */
	@Test
	public void testSelectScholarShipSelectSchloarShipByStudentNoAndTerm(){
		ScholarShip schloarShip = scholarShipService.searchOneByTerm("20111429","201401");
		System.out.println(schloarShip.getStudent().getStudentNo());
	}
	
	
	/**
	 * 测试排名
	 * anping
	 * TODO
	 * 上午11:20:33
	 */
	@Test
	public void testScholarShipdoRankForTotalScore(){
		 
		//scholarShipService.doTotalScoreRank("软件学院", "1102", "201401");
		
	}
	
	/**
	 * 测试判断是否为null
	 * anping
	 * TODO
	 * 上午11:20:41
	 */
	@Test
	public void testScholarShipCheckScholarIsNull(){
		List<ScholarShip> scholarShip= new ArrayList<ScholarShip>();
		ScholarShip  ship = new ScholarShip();
		StuBasicInfo student = new StuBasicInfo();
		student.setStudentNo("20111429");
		ship.setStudent(student);
	    ship.setBaseScore(20);
	    ship.setLessonScore(20);
	    ship.setSportScore(100);
	
		ScholarShip  ship2 = new ScholarShip();
		ship2.setStudent(student);
	    ship2.setBaseScore(20);
	    ship2.setLessonScore(20);
	    
	    scholarShip.add(ship);
	    scholarShip.add(ship2);
		
		//System.out.println(scholarShipService.checkScholarIsNull(scholarShip));
		
	}
}
