/**
* @package_name   com.stuManSys.utility
* @file_name XmlHandler.java
* @author Administrator
* @date 2014-3-12
*/

package jxau.sms.thomas.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import jxau.sms.commom.vo.AdvanceSearchVo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


/** 
 * @ClassName: XmlHandler
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class XmlHandler {

	
	private static final String[] fileNames = {"CommanAttribute.xml","ActManModule.xml","AdvInfoModule.xml","GrantModule.xml"
										,"InsuranceModule.xml","PovertyModule.xml","PunishModule.xml","ScholarModule.xml"
										,"StateModule.xml","StuActivityModule.xml","StudentModule.xml","TeacherModule.xml"};      //xml文件的名称     
	
	private static HashMap<String,List<AdvanceSearchVo>> attributes;     //最后获取的属性字段
	private static HashMap<String, String> mapperIds;
	private static List<Element> roots;
	private static Element root;
	
	public static List<Element> read() {
		roots = new ArrayList<Element>();
	    SAXReader reader = new SAXReader();     //实例化SAXreader
	    Document document = null;
	    for (int i = 0; i < fileNames.length; i++) {
	    	try {
				document = reader.read(new File(XmlPathUtility.getPath(fileNames[i],"viewMapping")));     //通过SAXReader获取document对象
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				System.out.print("xml读取文件失败!");   //异常处理，打印信息
			}
	    	roots.add(document.getRootElement());     //返回document对象
		}
	    return roots;
	}
	public static Element read(String fileName){
		SAXReader reader = new SAXReader();     //实例化SAXreader
	    Document document = null;
	    try {
			document = reader.read(new File(XmlPathUtility.getPath(fileName,"")));
			root = document.getRootElement();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return root;
	}
	public static HashMap<String, String> iterateTree(String fileName,String viewId){
		mapperIds = new HashMap<String, String>();
		for (Iterator view = read(fileName).elementIterator("view"); view.hasNext();) {
			Element viewNode = (Element)view.next();
			if (viewNode.attributeValue("id").equals(viewId)) {
				@SuppressWarnings("unchecked")
				List<Element> columnNode = viewNode.elements("mapper");
				for (int i = 0; i < columnNode.size(); i++) {
					mapperIds.put(columnNode.get(i).attributeValue("id"), columnNode.get(i).attributeValue("value"));
				}
			}
		}
		return mapperIds;
	}
	public static HashMap<String,List<AdvanceSearchVo>> iterateTree(){
		
		XmlHandler.read();
		List<AdvanceSearchVo> listSearchVos = null;
		attributes = new HashMap<String,List<AdvanceSearchVo>>();
		Map<String,Object> properties = null;
		for (int k = 0; k < roots.size(); k++) {
			for (Iterator view = roots.get(k).elementIterator("view"); view.hasNext();) {
				Element viewNode = (Element)view.next();
				listSearchVos = new ArrayList<AdvanceSearchVo>();
				@SuppressWarnings("unchecked")
				List<Element> columnNode = viewNode.elements("column");
				for (int i = 0; i < columnNode.size(); i++) {
					AdvanceSearchVo advanceSearchVo = new AdvanceSearchVo();
					properties = new LinkedHashMap<String,Object>();
				    Element column = columnNode.get(i);
				    advanceSearchVo.setViewType(viewNode.attributeValue("type"));
				    advanceSearchVo.setColName(column.attributeValue("name"));
				    advanceSearchVo.setColValue(column.attributeValue("value"));
				    advanceSearchVo.setColMutiply(column.attributeValue("multiply"));
				    //multiply = column.attributeValue("multiply");
				    //if (multiply != null && multiply.equals("true")) {
				    	List<Element> propertyNode = column.elements("property");
				    	for (int j = 0; j < propertyNode.size(); j++) {
							Element property = propertyNode.get(j);
							properties.put(property.attributeValue("value"), property.attributeValue("type"));
						}
				    //}else {
						//continue;
					//}
				    advanceSearchVo.setProperties(properties);
				    listSearchVos.add(advanceSearchVo);
				}
				attributes.put(viewNode.attributeValue("id"), listSearchVos);
			}
		}
		return attributes;
	}
	
}
