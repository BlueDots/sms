package jxau.sms.lyx.role.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.RoleInfo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

	@Test
	public void test() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		List<RoleInfo> list = new ArrayList<RoleInfo>();
		
		list = dao.select("findAllRoleInfo", null);
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getRoleName());
		}
	}
	
	
	@Test
	public void test2() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleName", "管理员");
		List<RoleInfo> list  = dao.select("findRoleByCondition", map);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getRoleName());
		}
	}
	
	
	@Test
	public void test3() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		RoleInfo roleInfo =new RoleInfo();
		roleInfo.setRoleName("测试角色1");
		roleInfo.setCreateTime(new Date());
		roleInfo.setRoleDescription("测试角色哦亲");
		dao.add("saveRole", roleInfo);
		
	}
	
	@Test
	public void test4() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherNo", "4321");
		map.put("roleName", "校级工作人员");
		int count = dao.selectOne("checkLoginRole", map);
		System.out.println(count);
	}

}
