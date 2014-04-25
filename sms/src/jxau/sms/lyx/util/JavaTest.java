package jxau.sms.lyx.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JavaTest {

	/**
	 * lyx test
	 * TODO
	 * 上午10:39:24
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> str = new ArrayList<String>();
		
		str.add("/hosInsuranceInfo!getAllHosByTeacher");
		str.add("/hosInsuranceQuery!getAllHosByTeacher");
		str.add("/hosInsuranceInfo!updateHoss");
		
		String url = "/hosInsuranceInfo!getAllHosByTeacher";
		
		if(str.contains(url)){
			System.out.println("对的");
		}else {
			System.out.println("错的");
		}
	}

}
