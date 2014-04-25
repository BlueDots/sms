package jxau.sms.qing.vita.service;

import static org.junit.Assert.*;
import jxau.sms.qing.login.service.LoginService;
import jxau.sms.qing.vita.vo.VitaVo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VitaServiceTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		VitaService vitaService = (VitaService) context.getBean("vitaService");
		VitaVo vo = vitaService.VitaInfo("20111112");
		for(int i=0;i<vo.getAdvance().size();i++){
			System.out.println(vo.getAdvance().get(i).getActivityName());
		}
		//System.out.println(vo.getAdvance().getActivityName()+"    hh");
	}

}
