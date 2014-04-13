package jxau.sms.util.chenjiang.roleVerify;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxau.sms.util.chenjiang.Dom4jXML;
import jxau.sms.util.chenjiang.exception.*;

import org.dom4j.Document;

import org.dom4j.Element;
import org.springframework.stereotype.Component;

@Component("rolesVerifyOperation")
public class RolesVerifyOperation {

	private  Dom4jXML dXml = null;
	@Resource(name="dXml")
	public void setdXml(Dom4jXML dXml) {
		this.dXml = dXml;
		document = dXml.read("jxau/sms/chengjiangConfig/roleVerify.xml");
	}
	
	private  Document document = null;
	
	private ModuleVerifyOperation moduleVerifyOperation;
	
	@Resource(name="moduleVerifyOperation")
	public void setModuleVerifyOperation(ModuleVerifyOperation moduleVerifyOperation) {
		this.moduleVerifyOperation = moduleVerifyOperation;
	}
	
	/**
	 * 
	 * @param ids ：主键集合
	 * @param moduleId：模块号
	 * @param roleId:操作角色
	 * @param operationId：操作编号  "1"：审核通过；"2"：审核不通过；
	 * @param remarks:备注
	 */
	public  <T>  void  roleVerifyOperation(List<T> ids, String moduleId,String roleId,String operationId,String remarks) {
		ModuleVerify mVerify = null;
		
		//得到得到根节点
		Element root = dXml.getRootElement(document);
		//得到module节点
		Element moduleElement = dXml.getModuleElementById(root, moduleId);
		if(moduleElement == null) 
			throw new ModuleNotFoundException("没有该模块编号:"+moduleId);
		//获得ModuleVerify
		mVerify = ModuleVerifySetUp.createModuleVerify(moduleId, dXml, moduleElement);
		
		//System.out.println(mVerify);
		
		//得到roles节点
		Element rolesElement = dXml.getRolesElement(moduleElement);
		//得到role节点
		Element roleElement = dXml.getRoleElement(rolesElement, roleId);
		if(roleElement == null) 
			throw new RoleNotFoundException("模块"+moduleId+"没有该角色编号:"+roleId);
		//得到operation节点
		if(operationId !="1" && operationId !="2")
			throw new VerifyOperationErrorException("operationId输入有误，只能为1或者2");
		Element operationElement = dXml.getOperationElement(roleElement, operationId);
		if(operationElement == null)
			throw new OperationNotFoundException("模块"+moduleId+"的角色"+roleId+"无该操作编号:"+operationId);
		//获得审核状态
		String exameState = operationElement.getStringValue();
		if(operationId.equals("1"))
			remarks = null;
		//调用
		moduleVerifyOperation.moduleVerify(ids, exameState, remarks, moduleId, mVerify);
	}
	
	/**
	 * 
	 * @param moduleId 模块编号
	 * @param roleId 角色编号 ，该角色必须有审核的权限才能有数据返回
	 * @return -1 出错, >=0 执行成功
	 */
	public int getRoleWaitForVerifyNums(String moduleId,String roleId) {
		int num = 0;
		
		//得到得到根节点
		Element root = dXml.getRootElement(document);
		//得到module节点
		Element moduleElement = dXml.getModuleElementById(root, moduleId);
		if(moduleElement == null) 
			throw new ModuleNotFoundException("没有该模块编号:"+moduleId);
		
		
		//得到procedure节点
		Element procedureElement = dXml.getProcedureElement(moduleElement);
		if(procedureElement == null)
			throw new ProcedureNotFoundException("模块"+moduleId+"没有存储过程");
		//得到roles节点
		Element rolesElement = dXml.getRolesElement(moduleElement);
		//得到role节点
		Element roleElement = dXml.getRoleElement(rolesElement, roleId);
		if(roleElement == null) 
			throw new RoleNotFoundException("模块"+moduleId+"没有该角色编号:"+roleId);
		//得到waitverify节点
		Element waitverifyeElement = dXml.getWaitVerifyElement(roleElement);
		if(waitverifyeElement == null)
			throw new WaitVerifyNotFoundException("模块"+moduleId+"的角色"+roleId+"无审核权限");
		
		//System.out.println(waitverifyeElement.getStringValue());
		//System.out.println(procedureElement.getStringValue());
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("procedure", procedureElement.getStringValue());
		params.put("eState", waitverifyeElement.getStringValue());
		params.put("nums", null);
		
		//调用
		num = moduleVerifyOperation.getRoleWaitForVerifyNums(params);
		
		return num;
	}
	
	/**
	 * 
	 * 江
	 * TODO
	 * 下午7:39:01
	 * @param c 是为了在做添加的时候做判断用户是不是传入了正确的对象
	 * @param lists 录入对象集合
	 * @param moduleId 模块号
	 * @param roleId 角色号
	 */
	
	public <T> void setExameStateOfEntering(Class<?> c,List<T> lists,String moduleId,String roleId,String level) {
		String operateId=null;
		//得到得到根节点
		Element root = dXml.getRootElement(document);
		//得到module节点
		Element moduleElement = dXml.getModuleElementById(root, moduleId);
		if(moduleElement == null) 
			throw new ModuleNotFoundException("没有该模块编号:"+moduleId);
		//得到roles节点
		Element rolesElement = dXml.getRolesElement(moduleElement);
		//得到role节点
		Element roleElement = dXml.getRoleElement(rolesElement, roleId);
		if(roleElement == null) 
			throw new RoleNotFoundException("模块"+moduleId+"没有该角色编号:"+roleId);
		//得到operation节点
		Element operationElement =null;
		if(level == null)
			operationElement = dXml.getOperationElement(roleElement, "3");
		else {
			if(!level.equals("1") && !level.equals("2"))
				throw new OperationNotFoundException("level 输入有误！要么为 null,要么为1,为2");
			if(!moduleId.equals("03"))
				throw new OperationNotFoundException("模块"+moduleId+"的level必须为null");
			operateId="3"+level;
			operationElement = dXml.getOperationElement(roleElement, operateId);
		}
		if(operationElement == null)
			throw new OperationNotFoundException("模块"+moduleId+"的角色"+roleId+"无该操作编号为"+operateId+"的操作");
		//获得审核状态
		String exameState = operationElement.getStringValue();
		//System.out.println(exameState);
		
		//得到verify节点对象
		Element verifyElement = dXml.getVerifyElement(moduleElement);
		String verifyColumn= verifyElement.attributeValue("column");
		
		
		
		StringBuffer lastW = new StringBuffer(verifyColumn.substring(1, verifyColumn.length()));
		StringBuffer firstW = new StringBuffer(verifyColumn.substring(0, 1)); 
		
		StringBuffer MethodName = new StringBuffer("set");
		
		//得到set方法的名称
		MethodName.append(verifyColumn.substring(0, 1).toUpperCase())
					.append(verifyColumn.substring(1, verifyColumn.length()));
		//得到set方法
		Method m=null;
		try {
			m = c.getMethod(MethodName.toString(), String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		System.out.println(m);
		for(int i=0;i<lists.size();i++) {
			T t = lists.get(i);
			try {
				m.invoke(t, exameState);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
