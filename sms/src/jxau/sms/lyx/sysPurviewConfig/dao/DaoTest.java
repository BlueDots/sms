package jxau.sms.lyx.sysPurviewConfig.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.PurviewInfo;
import jxau.sms.lyx.po.RoleInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

	@Test
	public void test() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherNo", "1234");
		map.put("roleName", "院级工作人员");
		List<RoleInfo> list = dao.select("findRoleByTeacherNo",map);
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("roleNo", list.get(0).getRoleNo());
		List<PurviewInfo> list2 = dao.select("findSessionPurviewByRoleNo",map2);
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(i).getPurviewName());
		}
	
	}

}
