/**
* @package_name   com.stuManSys.utility
* @file_name XmlHandler.java
* @author Administrator
* @date 2014-3-12
*/

package jxau.sms.thomas.util;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import jxau.sms.commom.vo.AdvanceSearchVo;


/** 
 * @ClassName: AdvSearchHandler
 * @Description: 用于高级查询，获取高级查询的条件，调用getAdvAttribute方法
 */
/**
 * @author Administrator
 *
 */
public class AdvSearchHandler {

	//private static Element root;        //xml文件中的根节点
	private HashMap<String,List<AdvanceSearchVo>> attributes;     //最后获取的属性字段
	private List<AdvanceSearchVo> advanceAttr;
	private String abstractId;
	
	public AdvSearchHandler(String abstractId){
		this.abstractId = abstractId;
	}
	
	public List<AdvanceSearchVo> getAdvAttribute(){
		attributes = XmlHandler.iterateTree();
		advanceAttr = new ArrayList<AdvanceSearchVo>();
		for (Entry<String, List<AdvanceSearchVo>> itemAttr:attributes.entrySet() )
		{
			if(itemAttr.getKey().length()>4||itemAttr.getKey().equals(abstractId)){
				for (int i = 0; i < itemAttr.getValue().size(); i++) {
					if (itemAttr.getValue().get(i).getColMutiply().equals("true")) {
						advanceAttr.add(itemAttr.getValue().get(i));
					}
				}
			}
		}
		return advanceAttr;
	}
	
}
