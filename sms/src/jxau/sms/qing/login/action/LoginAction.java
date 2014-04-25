package jxau.sms.qing.login.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import jxau.sms.lyx.exception.NotFoundDataException;
import jxau.sms.lyx.exception.NotUserRoleException;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.lyx.role.service.impl.RoleServiceImpl;
import jxau.sms.lyx.tecBasicInfo.service.impl.SessionTecBasicInfoServiceImpl;
import jxau.sms.qing.exception.LoginException;
import jxau.sms.qing.login.service.LoginService;

import org.apache.struts2.ServletActionContext;
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
	private String contentType = "text/html;charset=utf-8";  
	private Map<String,Object> session; 
	private LoginService loginService;
	private SessionTecBasicInfoServiceImpl sessionTecBasicInfoServiceImpl;
	private RoleServiceImpl roleServiceImpl;
	
	
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
	        
		//获取页面信息
		String username = ServletActionContext.getRequest().getParameter("username");
		String password = ServletActionContext.getRequest().getParameter("password");
		String roleName = ServletActionContext.getRequest().getParameter("roleName");
		
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(roleName);
		
		//指定输出内容类型和编码  
        ServletActionContext.getResponse().setContentType(contentType);   
        //获取输出流，然后使用  
        PrintWriter out = ServletActionContext.getResponse().getWriter();
	    Boolean bool;
	        	        
	        try{
	        	this.getLoginService().whichUser(username, password);
	        		
	        	Map<String,Object> param = new HashMap<String,Object>();
	        	param.put("teacherNo", username);
	        	TecBasicInfo teacher = sessionTecBasicInfoServiceImpl.searchByAccurate(param, 0);
	        	param.put("roleName", roleName);	
	        	List<RoleInfo> roles = roleServiceImpl.searchListByAccurate(param, 0);        	
	        	roleServiceImpl.checkUserRole(param);
	        	  	
	        	for(int i=0;i<roles.size();i++){
	        		
	        		roles.get(i).setRoleName(roleName);
	        	}
	        
	        	session.put("teacher", teacher);
	        	session.put("roles", roles);
	        	out.print("登录成功");
	        	
	        } catch (LoginException e) {
	        	
	        	out.print("用户名或密码不正确");
	        	    
	        	return ERROR;
	        	
	        } catch (NotUserRoleException re) {
	        	
	        	out.print("该用户无该角色权限");
	        	
	        	return ERROR;
	        	
	        } finally {
	        	
	        	out.flush();
	        	out.close();
	        }
	        
	        return SUCCESS; 
	      
	 }
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}  
	 
	 
	 

}
