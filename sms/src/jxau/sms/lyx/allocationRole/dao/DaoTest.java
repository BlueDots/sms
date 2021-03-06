package jxau.sms.lyx.allocationRole.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.TeacherPurview;
import jxau.sms.lyx.po.TeacherRole;
import jxau.sms.lyx.vo.VTeacherRole;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

	@Test
	public void test() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("AllocationRoleServiceImpl");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("teacherNo", "1234");
		List<VTeacherRole> vTeacherRole = dao.select("findAllTeacherRoleInfo", map);
		System.out.println(vTeacherRole.get(0).getTeacherNo());
	}

	@Test
	public void test2() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("teacherNo", "1234");
		List<String> str= dao.select("findRoleNameByTeacherNo", map);
		System.out.println(str.get(1));
	}
	
	@Test
	public void test3() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("teacherNo", "1234");
		List<String> str= dao.select("findDepartmentByTeacherNo", map);
		System.out.println(str.get(1));
	}
	
	@Test
	public void test4() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		TeacherRole teacherRole = new TeacherRole();
		teacherRole.setRoleNo(6);
		teacherRole.setTeacherNo("1234");
		dao.add("addTecRole", teacherRole);
	}
	
	@Test
	public void test5() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("teacherNo", "1234");	
		List<Integer> list = dao.select("findRoleNoByTeacherNo", map);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
