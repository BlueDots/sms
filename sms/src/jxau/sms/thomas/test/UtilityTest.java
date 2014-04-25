package jxau.sms.thomas.test; 

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jxau.sms.globaldao.Dao;
import jxau.sms.thomas.po.StuAdvInfo;
import jxau.sms.thomas.util.InputHandler;
import jxau.sms.thomas.util.MapperUtility;
import jxau.sms.thomas.util.OutputHandler;
import jxau.sms.thomas.vo.StuAdvVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UtilityTest {
	@Test
	public void testOutput(){		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao) applicationContext.getBean("dao");
		HashMap<String, Object> cons = new HashMap<>();
		cons.put("studentNo","20111826");
		OutputHandler outputHandler = new OutputHandler("0100");
		try {
			outputHandler.exportExcel("D://test.xls",cons);
			//outputHandler.exportExcel("D://test.xls",cons);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test
	public void testInput() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao) applicationContext.getBean("dao");
		InputHandler inputHandler = new InputHandler("0100");
		List<StuAdvVo> attributes = new ArrayList<StuAdvVo>();
		System.out.print(inputHandler.inputExcel(attributes,"D://outworkbook.xls",dao));
	}
	@Test
	public void testInitiateObject() throws ClassNotFoundException{
		InputHandler inputHandler = new InputHandler("0100");
		List<StuAdvVo> attributes = new ArrayList<StuAdvVo>();
		System.out.print(inputHandler.getInAttribute().get(0).getViewType());
		try {
			System.out.print(inputHandler.initiateObject(attributes,2).get(0));
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testMapperUtility(){
		System.out.print(MapperUtility.getMapperId("0100", "inputid"));
	}
}
