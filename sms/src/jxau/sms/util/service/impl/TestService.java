package jxau.sms.util.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.anping.po.ClassInfo;
import jxau.sms.anping.po.DepInfo;
import jxau.sms.anping.po.MajorInfo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.qing.po.Teacher;

import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
	
	private ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private CollegeMajorClassInterface globalServiceInterface =  (CollegeMajorClassInterface) applicationContext.getBean("collegeMajorClassServiceImpl");
	
	private Dao dao  =(Dao) applicationContext.getBean("dao");
	
	
	/**
	 * 测试拿取班级
	 * anping
	 * TODO
	 * 下午6:27:27
	 */
	@Test
	public void testgetClassByTeacher(){
		TecBasicInfo  teacher  = new TecBasicInfo();
		teacher.setTeacherNo("1234");
		List<RoleInfo>  roles = new ArrayList<RoleInfo>();
		RoleInfo  role   = new RoleInfo();
		role.setRoleName("班主任");
		 roles.add(role);
			String departNo="1105";
		  globalServiceInterface.searchClassByTeacher(teacher, roles, departNo, null);
			
	}
	/**
	 * 测试拿取专业
	 * anping
	 * TODO
	 * 下午6:26:51
	 */
	@Test
	public void testMajorByTeacher(){
		TecBasicInfo  teacher  = new TecBasicInfo();
		teacher.setTeacherNo("1234");
		List<RoleInfo>  roles = new ArrayList<RoleInfo>();
		RoleInfo  role   = new RoleInfo();
		role.setRoleName("班主任");
		 roles.add(role);
			String departNo="1105";
			List<MajorInfo> deps =  globalServiceInterface.searchMajorByTeacher(teacher, roles, departNo);
			for(MajorInfo major :deps){
			}
		
	}
	/**
	 * 测试service 拿到学院信息
	 * anping
	 * TODO
	 * 下午6:23:35
	 */
	@Test
	public void testSearchCollegeByTeacher(){
		TecBasicInfo  teacher  = new TecBasicInfo();
		teacher.setTeacherNo("1234");
		List<RoleInfo>  roles = new ArrayList<RoleInfo>();
		RoleInfo  role   = new RoleInfo();
		role.setRoleName("校级管理员");
		
		 roles.add(role);
		
		List<DepInfo> deps =  globalServiceInterface.searchCollegeByTeacher(teacher, roles);
		for(DepInfo dep :deps){
			System.out.println(dep.getDepartNo()+"---"+dep.getDepartment());
		}
	}
	
	
	//测试通过教师来拿到信息
	@Test
	public void testGetCollegeByTeacher(){
		
	    Map<String,Object> hashMap= new HashMap<String, Object>();
	   hashMap.put("teacherNo","5678" );
	   hashMap.put("roleName", "班主任" );
	   
	    dao.select("jxau.sms.util.dao.findDepByTeacherRole", hashMap);
		
	}
	//测试通过教师角色和部门信息拿取专业
	@Test
	public void testGetMajorByTeacher(){
		
		 Map<String,Object> hashMap= new HashMap<String, Object>();
		   hashMap.put("teacherNo","1234" );
		   hashMap.put("roleName", "院级工作人员" );
		   hashMap.put("departNo", "1105" );
		   
		   
		   dao.select("jxau.sms.util.dao.findMajorByDeptTeacherRole", hashMap);
	}
	
	@Test
	public void testGetClass(){
		 Map<String,Object> hashMap= new HashMap<String, Object>();
		   hashMap.put("teacherNo","1234" );
		   hashMap.put("roleName", "院级工作人员" );
		 //  hashMap.put("majorNo", "1105" );
		   hashMap.put("departNo", "1105" );
		   
		   
		   
		   dao.select("jxau.sms.util.dao.findClassByMajorTeacherRole", hashMap);
	}
	
	@Test
	public void testGetCollegeLists() {
		List<DepInfo> lists = ((CollegeMajorClassServiceImpl)globalServiceInterface).getCollegeLists(null, 0, null);
		System.out.println(lists.size());
		for(int i=0;i<lists.size();i++)
			System.out.println(lists.get(i));
		
	}
	
	@Test
	public void testGetMajorLists() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("departNo", "1105");
		List<MajorInfo> lists = ((CollegeMajorClassServiceImpl)globalServiceInterface).getMajorLists(params, 0, null);
		System.out.println(lists.size());
		for(int i=0;i<lists.size();i++)
			System.out.println(lists.get(i));
		
	}
	
	@Test
	public void testClassLists() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("majorNo", "11050100");
		List<ClassInfo> lists = ((CollegeMajorClassServiceImpl)globalServiceInterface).getClassLists(params, 0, null);
		System.out.println(lists.size());
		for(int i=0;i<lists.size();i++)
			System.out.println(lists.get(i));
		
	}	
}
