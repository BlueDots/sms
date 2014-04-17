package jxau.sms.util.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.anping.po.ClassInfo;
import jxau.sms.anping.po.DepInfo;
import jxau.sms.anping.po.MajorInfo;
import jxau.sms.globalService.GlobalServiceInterface;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
	
	private ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private GlobalServiceInterface globalServiceInterface =  (GlobalServiceInterface) applicationContext.getBean("collegeMajorClassServiceImpl");
	
	
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
