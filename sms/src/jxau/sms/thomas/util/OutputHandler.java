/**
 * @package_name   com.stuManSys.utility
 * @file_name POIHandler.java
 * @author Administrator
 * @date 2014-3-18
 */

package jxau.sms.thomas.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.swing.JOptionPane;

import jxau.sms.commom.vo.AdvanceSearchVo;
import jxau.sms.globaldao.Dao;
import jxau.sms.thomas.vo.StuAdvVo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dom4j.Element;


/** 
 * @ClassName: POIHandler
 * @Description: 用于导出的功能，使用时需要调用exportExcel方法;导出当前页码显示的内容,
 * 							因此需要查询所用页码的内容
 */
/**
 * @author Administrator
 * 
 */
public class OutputHandler {

	private HashMap<String,List<AdvanceSearchVo>> attributes;     //最后获取的属性字段
	private List<AdvanceSearchVo> outputAttr; //符合条件的属性;
	private String abstractId;	//视图的抽象编号
	private Dao dao;
	
	private static HSSFWorkbook demoWorkBook = new HSSFWorkbook();
	private static HSSFSheet demoSheet = demoWorkBook.createSheet("学生工作管理系统");

	public OutputHandler(String abstractId){
		this.abstractId = abstractId;
	}

	@Resource(name="dao")
	public void setDao(Dao dao){
		this.dao = dao;
	}
	
	private List<AdvanceSearchVo> getOutAttribute(){
		attributes = XmlHandler.iterateTree();
		outputAttr = new ArrayList<AdvanceSearchVo>();
		for (Entry<String, List<AdvanceSearchVo>> itemAttr:attributes.entrySet())
		{
			if(itemAttr.getKey().equals(abstractId)){ //itemAttr.getKey().length()>4||
				for (int i = 0; i < itemAttr.getValue().size(); i++) {
					outputAttr.add(itemAttr.getValue().get(i));
				}
			}
		}
		return outputAttr;
	}

	private String generateTitle(){
		HSSFHeader header = demoSheet.getHeader();
		header.setCenter("111");
		HSSFRow headerRow = demoSheet.createRow((short) 0);
		int i = 0;
		for (int j = 0; j < outputAttr.size(); j++) {
			getOutAttribute();
			HSSFCell headerCell = headerRow.createCell((short) j);
			headerCell.setCellValue(outputAttr.get(j).getColValue());
		}
		return "excel头文件成功";
	};
	public <T> void transferFormation(Field field,HSSFCell cell,T attribute ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		String returnType = field.getType().getName();
		if (returnType.equals(java.lang.String.class.getName())) {
			cell.setCellType(1);
			cell.setCellValue(field.get(attribute).toString());
		}else if (returnType.equals(java.lang.Integer.class.getName())) {
			cell.setCellType(0);
			cell.setCellValue((Integer)field.get(attribute));
		}else if (returnType.equals(java.lang.Double.class.getName())) {
			cell.setCellType(0);
			cell.setCellValue((Double)field.get(attribute));
		}else if (returnType.equals(java.util.Date.class.getName())) {
			HSSFCellStyle cellStyle = demoWorkBook.createCellStyle();
	        HSSFDataFormat format= demoWorkBook.createDataFormat();
	        cellStyle.setDataFormat(format.getFormat("yyyy-MM-dd"));
	        cell.setCellStyle(cellStyle);
	        cell.setCellValue((Date)field.get(attribute));
		}else {
			System.out.print("数据格式尚未定义");
		}

	}
	private <T> String createTableRow(List<T> rows) {
		if (rows.equals(null) || rows.size() == 0) {
			return "error";
		} else {
			int count = 0;
			//Method[] methods = rows.get(0).getClass().getDeclaredMethods();
			/*for (int k = 0; k < methods.length; k++) {
				if (methods[k].getName().startsWith("get")) {
					methods[count] = methods[k];
					count++;
				}
			}*/
			for (int j = 1; j < rows.size()+1; j++) {
				HSSFRow row = demoSheet.createRow((short) j);
				Field[] fields = rows.get(j-1).getClass().getDeclaredFields();
				//System.out.print(outputAttr.size());
				for (short i = 0; i < outputAttr.size(); i++) {
					HSSFCell cell = row.createCell((short) i);
					try {
						fields[i].setAccessible(true);
						//fields[i].set("studentNo", "20111");
						transferFormation(fields[i],cell,attributes.get(j-1));
						//transferFormation(methods[i].getReturnType().getName(),methods[i],rows.get(j-1),cell);
						//methods[i].invoke(rows.get(j-1)).toString();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return "excel内容创建成功";
		}
	}
	private <T> void createExcelSheeet(List<T> rows){
		generateTitle();
		createTableRow(rows);
	}
	
	public void exportExcel(HSSFSheet sheet,OutputStream os) throws IOException   
	{   
	    sheet.setGridsPrinted(true);   
	    HSSFFooter footer = sheet.getFooter();   
	    footer.setRight("Page " + HSSFFooter.page() + " of " +   
	            HSSFFooter.numPages());   
	    demoWorkBook.write(os);   
	}   
	
	
	public static void main(String[] args) {   
	    String fileName = "D:\\workbook.xls"; 
	    FileOutputStream fos = null;   
	    try {   
	    	OutputHandler poiHandler = new OutputHandler("0100");
	    	ArrayList<StuAdvVo> stuAdvInfos = new ArrayList<StuAdvVo>();
	    	StuAdvVo stuAdvInfo = new StuAdvVo();
	    	stuAdvInfo.setStudentNo("20111826");
	    	stuAdvInfo.setCollege("软件学院");
	    	stuAdvInfo.setMajor("软件+英语");
	    	stuAdvInfo.setClassName("软件1111班");
	    	stuAdvInfo.setSex(1);
	    	stuAdvInfo.setAdvanceActivity("优秀三好学生");
	    	stuAdvInfo.setAdvLevel("校级");
	    	stuAdvInfo.setAdvTime("2013-02-02");
	    	
	    	stuAdvInfos.add(stuAdvInfo);
	    	
	    	
	        fos = new FileOutputStream(fileName); 
	        poiHandler.getOutAttribute();
	        poiHandler.createExcelSheeet(stuAdvInfos); 
	        poiHandler.exportExcel(demoSheet,fos);   
	        JOptionPane.showMessageDialog(null, "文件名称 : "+fileName);   
	    } catch (Exception e) {   
	        JOptionPane.showMessageDialog(null, "导出错误:"+e);   
	        e.printStackTrace();   
	    } finally {   
	        try {   
	            fos.close();   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }   
	    }   
	}   
}
