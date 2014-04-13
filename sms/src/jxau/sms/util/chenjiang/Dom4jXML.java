package jxau.sms.util.chenjiang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;



@Component("dXml")
public class Dom4jXML {
	//得到文档对象
	public Document read(String fileName) throws DocumentException {
		SAXReader reader = new SAXReader();
		
		Document document = reader.read(Dom4jXML.class.getResource("/").getPath()+"/"+fileName);
		return document;
	}
	//得到根节点
	public Element getRootElement(Document doc) {
		return doc.getRootElement();
	}
	
	//得到moudle节点
	public Element getModuleElementById(Element root,String moduleId) {
		Element element = null;
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       if(e.attributeValue("id").equals(moduleId))
		    	   element = e;
		    }
		 return element;
	}
	//得到id节点
	public Element getIdElement(Element root) {
		Element element = null;
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       if(e.getName().equals("id"))
		    	   element = e;
		    }
		 return element;
	}
	
	//得到verify节点
	public Element getVerifyElement(Element root) {
		Element element = null;
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       if(e.getName().equals("verify"))
		    	   element = e;
		    }
		 return element;
	}
	//得到remarks节点
	public Element getRemarksElement(Element root) {
		Element element = null;
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       if(e.getName().equals("remarks"))
		    	   element = e;
		    }
		 return element;
	}	
	//得到state节点
	public Element getStateElement(Element root) {
		Element element = null;
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       if(e.getName().equals("state"))
		    	   element = e;
		    }
		 return element;
	}	
	//得到related节点
	public Element getRelatedElement(Element root) {
		Element element = null;
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       if(e.getName().equals("related"))
		    	   element = e;
		    }
		 return element;
	}	
	
	
	//得到relateStateString
	public List<String> getRelateStateString(Element root) {
		List<String> propertys = new ArrayList<String>();
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       propertys.add(e.getStringValue());
		    }
		return propertys;
	}
	
	//得到procedure节点
	public Element getProcedureElement(Element root) {
		Element element = null;
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       if(e.getName().equals("procedure")) {
		    	   element = e;
		       }
		    }
		 return element;
	}
	
	//得到roles节点
	public Element getRolesElement(Element root) {
		Element element = null;
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       if(e.getName().equals("roles")) {
		    	   element = e;
		       }
		    }
		 return element;
	}	
	//得到role节点
	public Element getRoleElement(Element root,String roleId) {
		Element element = null;
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       if(e.getName().equals("role") && e.attributeValue("id").equals(roleId)) {
		    	   element = e;
		       }
		    }
		 return element;
	}
	
	//得到operation节点
	public Element getOperationElement(Element root,String operationId) {
		Element element = null;
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       if(e.getName().equals("operation") && e.attributeValue("id").equals(operationId))
		    	   element = e;
		    }
		 return element;
	}
	
	//得到waitverify节点
	public Element getWaitVerifyElement(Element root) {
		Element element = null;
		 for ( Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
		       Element e = (Element) i.next();
		       if(e.getName().equals("waitverify"))
		    	   element = e;
		    }
		 return element;
	}
}
