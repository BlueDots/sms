package jxau.sms.lyx.purview.action;

import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.purview.service.impl.PurviewListPackage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller  
@Scope("prototype")
public class RoleSystemPurviewAction extends ActionSupport implements ModelDriven<RoleInfo>{

	private static final long serialVersionUID = 1L;

	private PurviewListPackage plp;
	private RoleInfo roleInfo = new RoleInfo();
	
	@Resource(name="PurviewListPackage")
	public void setPlp(PurviewListPackage plp) {
		this.plp = plp;
	}

	String roleNo = ServletActionContext.getRequest().getParameter("roleNo");	
	String param = ServletActionContext.getRequest().getParameter("array");
		
	/**
	 * 
	 * lyx
	 * TODO:
	 * 			角色修改权限
	 * 下午7:14:10
	 * @return
	 * @throws Exception
	 */
	public String renewPurview() throws Exception{
			
		plp.containerTransform(roleNo, param);				
		return SUCCESS;
				
	}

	@Override
	public RoleInfo getModel() {
		// TODO Auto-generated method stub
		return roleInfo;
	}
	
}
