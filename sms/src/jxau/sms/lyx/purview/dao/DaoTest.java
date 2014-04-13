package jxau.sms.lyx.purview.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.PurviewInfo;
import jxau.sms.lyx.purview.service.impl.UserPurviewManagerServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

	@Test
	public void test() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleNo",3);
				
		List<PurviewInfo> list = new ArrayList<PurviewInfo>();
		list = dao.select("jxau.sms.lyx.purview.dao.findPurviewByCondition", map);
	
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getPurviewName());
		}
	}
	
	@Test
	public void test2() {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserPurviewManagerServiceImpl up = (UserPurviewManagerServiceImpl)context.getBean("UserPurviewManagerServiceImpl");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherNo", "1234");
		List<PurviewInfo> list = new ArrayList<PurviewInfo>();
		list = up.searchListByAccurate(map, 0);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getPurviewName());
		}
	}

}
