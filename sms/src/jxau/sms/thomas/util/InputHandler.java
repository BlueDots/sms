/**
* @package_name   com.stuManSys.utility
* @file_name InputHandler.java
* @author Administrator
* @date 2014-4-13
*/

package jxau.sms.thomas.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import jxau.sms.globaldao.Dao;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/** 
 * @ClassName: InputHandler
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class InputHandler<T>{

	private String filePath;
	private HSSFSheet sheet;
	private List<T> inputAttrs;
	private Dao dao;
	private static HashMap<String, String> mapperIds;
	private static final String fileName = "AbstractionMapper.xml";
	
	public InputHandler(String filePath){
		this.filePath = filePath;
	}
	
	@Resource(name="dao")
	public void setDao(Dao dao){
		this.dao = dao;
	}
	public String getMapperId(String viewId){
		String mapperid = null;
		mapperIds = XmlHandler.iterateTree(fileName, viewId);
		for (java.util.Map.Entry<String, String> mapper:mapperIds.entrySet()) {
			if (mapper.getKey().equals("inputId")) {
				mapperid = mapper.getValue();
			}
		}
		return mapperid;
	}
	private int getTotalCount(){
		FileInputStream fin;
		int totalRow = 0;
		try {
			fin = new FileInputStream(filePath);
			HSSFWorkbook workbook=new HSSFWorkbook(fin);//创建工作薄
			sheet=workbook.getSheetAt(0);//得到工作表
			totalRow =sheet.getLastRowNum();//得到excel的总记录条数
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalRow;
	}
	
	private List<T> setAttributes(List<T> attributes){
		
		Field[] fields = attributes.getClass().getDeclaredFields();
		
		for(int i=1;i<=getTotalCount();i++){
			 HSSFRow row=sheet.getRow(i);
			 for (int j = 0; j < fields.length; j++) {
				 HSSFCell cell=row.getCell(j);
				 fields[j].setAccessible(true);
				 try {
					fields[j].set(attributes.get(i-1),cell.getRichStringCellValue().toString());
					//转化属性的格式
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		 }
		 return attributes;
	}
	
	public int inputExcel(List<T> attributes,String viewId){
		inputAttrs = setAttributes(attributes);
		dao.batchAdd(getMapperId(viewId), attributes);
		return attributes.size();
	}

}
