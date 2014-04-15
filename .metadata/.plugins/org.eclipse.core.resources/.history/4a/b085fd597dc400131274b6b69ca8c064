package jxau.sms.lyx.role.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import jxau.sms.commom.vo.PageVo;
import jxau.sms.lyx.role.service.impl.RoleServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

@Controller  
@Scope("prototype")
public class RoleAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private RoleServiceImpl roleServiceImpl;
	
	@Resource(name="roleServiceImpl")
	public void setRoleServiceImpl(RoleServiceImpl roleServiceImpl) {
		this.roleServiceImpl = roleServiceImpl;
	}

	public String roleExecute(){
		
		PageVo pageVo = new PageVo();
		pageVo.setSize(4);
		roleServiceImpl.searchByAccurate(null, pageVo, 0);
		
		return SUCCESS;
	}
	
}
