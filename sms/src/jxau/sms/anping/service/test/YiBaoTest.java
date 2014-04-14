package jxau.sms.anping.service.test;

import java.util.HashMap;
import java.util.Map;

import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class YiBaoTest {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	GlobalServiceInterface yiBaoService = (GlobalServiceInterface) context.getBean("yiBaoService");
	@Test
	public void testYiBaoSelect(){
		
		PageVo  page = new PageVo();
		page.setCurrentPage(0);
		Map<String,Object> param  = new HashMap<String,Object>(10);
		param.put("college","软件学院");
		yiBaoService.searchByAccurate(param, page, 0);
		System.out.println(page.getCurrentPage());
		System.out.println(page.getFirstIndex());
		System.out.println(page.getPageNum());
		System.out.println(page.getSize());
	}
}
