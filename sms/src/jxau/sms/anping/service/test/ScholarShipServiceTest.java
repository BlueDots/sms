package jxau.sms.anping.service.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.anping.po.ScholarShip;
import jxau.sms.anping.scholarship.service.impl.ScholarShipServiceImpl;
import jxau.sms.anping.service.ScholarShipService;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.qing.po.Student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScholarShipServiceTest {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ScholarShipServiceImpl scholarShipService = (ScholarShipServiceImpl) context.getBean("scholarShip");
	
	
	/**
	 * 测试　　　拿到某个工作人员需要审核的所有信息
	 * anping
	 * TODO
	 * 下午6:48:35
	 */
	@Test
	public void testGetAllWaitMes(){
		TecBasicInfo tea = new TecBasicInfo();
		tea.setTeacherNo("1234");
		List<RoleInfo> roleInfos = new ArrayList<>();  
		RoleInfo  roleInfo  = new RoleInfo();
		 roleInfo.setRoleName("院级工作人员");
		roleInfos.add(roleInfo);
		scholarShipService.getAllWaitCheckData(roleInfos, tea);
	}
	
	/**
	 * 测试　查询一个学生的数据
	 * anping
	 * TODO
	 * 下午5:12:39
	 */
	@Test
 	public void testSearchSchloarShipOneStudent(){
		
 	   scholarShipService.searchOneStudent("20111429");
	}
	
	/**
	 * 测试批量增加，需要添加的数据都市一个班级的
	 * anping
	 * TODO
	 * 下午4:00:25
	 */
	@Test
	public void testSchloarShipUpdate(){
		List<ScholarShip> scholarShips = new ArrayList<ScholarShip>();
		ScholarShip scholarShip  = new ScholarShip();
		scholarShip.setBaseScore(99);
		StuBasicInfo  basicInfo =  new StuBasicInfo();
		basicInfo.setStudentNo("20111429");
		scholarShip.setStudent(basicInfo);
		scholarShip.setTerm("201404");
		
		scholarShips.add(scholarShip);
		TecBasicInfo tea = new TecBasicInfo();
		tea.setTeacherNo("1234");
		List<RoleInfo> roleInfos = new ArrayList<>();  
		RoleInfo  roleInfo  = new RoleInfo();
		 roleInfo.setRoleName("班主任");
		roleInfos.add(roleInfo);
		scholarShipService.updateSchloarShip(scholarShips, tea, roleInfos);
	}
	
	@Test
	public void testServiceAddSchloarShip(){
		List<ScholarShip> scholarShips = new ArrayList<ScholarShip>();
		ScholarShip scholarShip  = new ScholarShip();
		scholarShip.setBaseScore(20);
		scholarShip.setLessonScore(20);
		StuBasicInfo  basicInfo =  new StuBasicInfo();
		basicInfo.setStudentNo("20111429");
		scholarShip.setStudent(basicInfo);
		scholarShip.setExameState("院级审核中");
		ScholarShip scholarShip2  = new ScholarShip();
		scholarShip2.setBaseScore(20);
		scholarShip2.setLessonScore(20);
		scholarShip2.setExameState("院级审核中");
		StuBasicInfo  basicInfo2 =  new StuBasicInfo();
		basicInfo2.setStudentNo("20111430");
		scholarShip2.setStudent(basicInfo2);
		
		ScholarShip scholarShip3  = new ScholarShip();
		scholarShip3.setBaseScore(20);
		scholarShip3.setLessonScore(20);
		scholarShip3.setExameState("院级审核中");
		StuBasicInfo  basicInfo3 =  new StuBasicInfo();
		basicInfo3.setStudentNo("20111431");
		scholarShip3.setStudent(basicInfo3);
		
		
		
		scholarShips.add(scholarShip);
		scholarShips.add(scholarShip2);
		scholarShips.add(scholarShip3);
		TecBasicInfo tea = new TecBasicInfo();
		tea.setTeacherNo("1234");
		List<RoleInfo> roleInfos = new ArrayList<>();  
		RoleInfo  roleInfo  = new RoleInfo();
		 roleInfo.setRoleName("院级工作人员");
		roleInfos.add(roleInfo);
		System.out.println(scholarShips.size());
		scholarShipService.addSchloarShip(scholarShips, tea, roleInfos,"软件学院", "1102","201403");
		
	}
	
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
		ScholarShip schloarShip = scholarShipService.searchOneByTerm("20111429","201404");
		System.out.println(schloarShip.getStudent().getStudentNo()+schloarShip.getBaseScore());
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
