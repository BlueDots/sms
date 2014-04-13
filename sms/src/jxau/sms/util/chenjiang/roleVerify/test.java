package jxau.sms.util.chenjiang.roleVerify;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import javax.faces.application.Application;

import org.jboss.weld.context.ApplicationContext;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class test {
	private ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private RolesVerifyOperation rolesVerifyOperation=(RolesVerifyOperation) applicationContext.getBean("rolesVerifyOperation");
	
 


	@Test
	public void testSetExameStateOfEntering() {
		rolesVerifyOperation.setExameStateOfEntering(null, "01", "2");
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
