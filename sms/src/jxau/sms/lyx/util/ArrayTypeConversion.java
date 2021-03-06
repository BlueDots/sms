package jxau.sms.lyx.util;


import java.util.ArrayList;
import java.util.List;

import jxau.sms.lyx.exception.MyNumberFormatException;

/**
 * 
 * @author lyx
 * 2014-4-13
 * TODO:
 * 		该类用作数组类型转换
 */
public class ArrayTypeConversion {

	/**
	 * @TODO:
	 * 		该方法用于String[]数组转换为int[]数组，再放入list容器中
	 * @param str
	 * @return
	 */
	public static List<Integer> StringConversionInteger(String[] str){
		
		List<Integer> newList = new ArrayList<Integer>();
		Integer array[] = new Integer[str.length]; 
		
		for(int i=0;i<str.length;i++){
			
			try{
				array[i] = Integer.parseInt(str[i]);
			}catch(Exception e){
				throw new MyNumberFormatException("非数字类型不能转换");
			}
					
			newList.add(array[i]);
		}
		
		return newList;
	}
}
