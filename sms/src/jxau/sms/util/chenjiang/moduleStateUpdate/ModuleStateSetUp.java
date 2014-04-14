package jxau.sms.util.chenjiang.moduleStateUpdate;

import java.util.List;

import javax.annotation.Resource;

import jxau.sms.util.chenjiang.Dom4jXML;
import jxau.sms.util.chenjiang.exception.ModuleNotFoundException;


import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

@Component("moduleStateSetUp")
public class ModuleStateSetUp {
	private  Dom4jXML dXml = null;
	
	private  Document document = null;
	
	@Resource(name="dXml")
	public void setdXml(Dom4jXML dXml) {
		this.dXml = dXml;
		document = dXml.read("jxau/sms/chengjiangConfig/moduleState.xml");
	}
	

	
	public  StateUpdate createStateUpdate(String moduleId) {
		StateUpdate sUpdate = null;
		Element root = null;
		root = dXml.getRootElement(document);
		if(root != null) {
			//得到module节点对象
			Element moduleElement =  dXml.getModuleElementById(root,moduleId);
			if(moduleElement == null) 
				throw new ModuleNotFoundException("没有该模块编号或子表编号:\""+moduleId+"\",请查看jxau/sms/chengjiangConfig/moduleState.xml中的具体配置");
			//得到id节点对象
			Element idElement = dXml.getIdElement(moduleElement);
			
			//得到state节点对象
			Element stateElement = dXml.getStateElement(moduleElement);
			//得到remarks节点
			Element remarksElement = dXml.getRemarksElement(moduleElement);
			//得到related节点
			Element relatedElement = dXml.getRelatedElement(stateElement);
			//得到relateStateString
			List<String> relatedStates = null;
			if(relatedElement != null) {
				 relatedStates = dXml.getRelateStateString(relatedElement);
			}
			
			sUpdate = new StateUpdate();
			sUpdate.setTable(moduleElement.attributeValue("table"));
			sUpdate.setId(idElement.attributeValue("column"));
			sUpdate.setState(stateElement.attributeValue("column"));
			if(remarksElement != null)
				sUpdate.setRemarks(remarksElement.attributeValue("column"));
			
			
			if(relatedElement != null) 
				sUpdate.setRelatedStates(relatedStates);
		}
		
		return sUpdate;
	}
}
