package jxau.sms.qing.login.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
 
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.lyx.role.service.impl.RoleServiceImpl;
import jxau.sms.lyx.tecBasicInfo.service.impl.SessionTecBasicInfoServiceImpl;
import jxau.sms.qing.exception.LoginException;
import jxau.sms.qing.login.service.LoginService;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller  
@Scope("prototype")
public class LoginAction extends ActionSupport  implements SessionAware{	 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  
	private Map<String,Object> session; 
	private LoginService loginService;
	private SessionTecBasicInfoServiceImpl sessionTecBasicInfoServiceImpl;
	private RoleServiceImpl roleServiceImpl;
	private String username;
	private String password;
	private String roleName;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	@Resource(name="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Resource(name="SessionTecBasicInfoServiceImpl")
	public void setSessionTecBasicInfoServiceImpl(
			SessionTecBasicInfoServiceImpl sessionTecBasicInfoServiceImpl) {
		this.sessionTecBasicInfoServiceImpl = sessionTecBasicInfoServiceImpl;
	}
	@Resource(name="RoleServiceImpl")
	public void setRoleServiceImpl(RoleServiceImpl roleServiceImpl) {
		this.roleServiceImpl = roleServiceImpl;
	}
	
	@Override  
	 public String execute() throws Exception {  		 	
	        System.out.println("HelloAction.execute is executing..."); 
	        Boolean bool;
	        	        
	        try{
	        	this.getLoginService().whichUser(username, password);
	        	
	        	Map<String,Object> param = new HashMap<String,Object>();
	        	param.put("teacherNo", username);
	        	TecBasicInfo teacher = sessionTecBasicInfoServiceImpl.searchByAccurate(param, 0);
	        	param.put("roleName", roleName);
	        	List<RoleInfo> roles = roleServiceImpl.searchListByAccurate(param, 0);        	
	        	roles.get(0).setRoleName(roleName);
	        	session.put("teacher", teacher);
	        	session.put("roles", roles);
	        	
	        } catch (LoginException e) {
	        	e.printStackTrace();
	        	return ERROR;
	        }
	        return roleName; 
	      
	 }
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}  
	 
	 
	 

}
