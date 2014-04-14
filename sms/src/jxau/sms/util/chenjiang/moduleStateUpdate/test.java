package jxau.sms.util.chenjiang.moduleStateUpdate;

import java.util.ArrayList;
import java.util.List;

import jxau.sms.util.chenjiang.roleVerify.RolesVerifyOperation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	
	private ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private ModuleStateOperation moduleStateOperation=(ModuleStateOperation) applicationContext.getBean("moduleStateOperation");
	
	@Test
	public void m() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(4);
		ids.add(5);
		ids.add(6);		
		moduleStateOperation.moduleStateUpdate(ids, 1, null, "有问题", "04");
	}
	
	@Test
	public void testSubTableStateUpdate() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);	
		moduleStateOperation.subTableStateUpdate(ids, 1, "ss", "sss");
	}
}
