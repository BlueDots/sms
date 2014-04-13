package jxau.sms.util.chenjiang.roleVerify;

import jxau.sms.util.chenjiang.Dom4jXML;

import org.dom4j.Element;

public class ModuleVerifySetUp {
	public static ModuleVerify createModuleVerify(String moduleId,Dom4jXML dXml,Element moduleElement){
		ModuleVerify mVerify = null;
		//得到id节点对象
		Element idElement = dXml.getIdElement(moduleElement);
		//得到verify节点对象
		Element verifyElement = dXml.getVerifyElement(moduleElement);
		//得到remarks节点
		Element remarksElement = dXml.getRemarksElement(moduleElement);
		
		mVerify = new ModuleVerify();
		mVerify.setTable(moduleElement.attributeValue("table"));
		mVerify.setId(idElement.attributeValue("column"));
		mVerify.setRemarks(remarksElement.attributeValue("column"));
		mVerify.setVerify(verifyElement.attributeValue("column"));
		
		return mVerify;
	}
}
