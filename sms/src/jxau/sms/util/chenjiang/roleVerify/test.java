package jxau.sms.util.chenjiang.roleVerify;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import jxau.sms.chenjiang.po.ActInfo;
import jxau.sms.chenjiang.po.StuActParticipate;
import jxau.sms.chenjiang.po.StuBasicInfo;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class test {
	private ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private RolesVerifyOperation rolesVerifyOperation=(RolesVerifyOperation) applicationContext.getBean("rolesVerifyOperation");
	
 


	@Test
	public void testSetExameStateOfEntering() {
	   	 List<StuActParticipate> lists = new ArrayList<StuActParticipate>();

	  	 StuActParticipate s1 = new StuActParticipate();
	   	 ActInfo a1 = new ActInfo();
	   	a1.setActNo(2);
	   	 StuBasicInfo sb1 = new StuBasicInfo();
	   	sb1.setStudentNo("20111635");
		 s1.setActInfo(a1);
		 s1.setStuBasicInfo(sb1);
	   	 
		 s1.setSessionYear(2);
		 s1.setAwardTime(Date.valueOf("2211-1-13"));
		 s1.setActivityRating("二等奖");
		
	  	 StuActParticipate s2 = new StuActParticipate();
	   	 ActInfo a2 = new ActInfo();
	   	a2.setActNo(1);
	   	 StuBasicInfo sb2 = new StuBasicInfo();
	   	sb2.setStudentNo("20111636");
		 s2.setActInfo(a2);
		 s2.setStuBasicInfo(sb2);
	   	 
		 s2.setSessionYear(1);
		 s2.setAwardTime(Date.valueOf("1111-11-11"));
		 s2.setActivityRating("二等奖");
		 
		 lists.add(s1);
		 lists.add(s2);
		rolesVerifyOperation.setExameStateOfEntering(StuActParticipate.class,lists, "04", "4",null);
		
		for(int i=0;i<lists.size();i++) {
			System.out.println(lists.get(i));
		}
	}
	
	@Test
	public  void m() throws Exception {
		List<String> ids = new ArrayList<String>();
		ids.add("20111367");
		ids.add("20111429");
		ids.add("20111635");
		//ids.add("20111638");
/*		List<Integer> ids = new ArrayList<Integer>();
		ids.add(3);
		ids.add(4);*/
		
		
		rolesVerifyOperation.roleVerifyOperation(ids, "01", "3", "2", "");
	}
	
	
	@Test
	public void testRoleVerifyOperation() {
/*		List<String> ids = new ArrayList<String>();
		ids.add("20111620");
		ids.add("20111621");
		ids.add("20111622");	*/
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(3);
		rolesVerifyOperation.roleVerifyOperation(ids, "08", "4", "1", "信息有误");
	}
	
	@Test
	public void testGetRoleWaitForVerifyNums() {
		System.out.println(rolesVerifyOperation.getRoleWaitForVerifyNums("01", "3"));
		
	}
	
}
