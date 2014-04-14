package jxau.sms.qing.login.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import jxau.sms.qing.login.service.LoginService;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller  
@Scope("prototype")
public class LoginAction extends ActionSupport implements ServletResponseAware {	 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;  
	 
	 @Override  
	 public void setServletResponse(HttpServletResponse response) {  
	        this.response = response;  
	  }  
	 
	 @Override  
	 public String execute() throws Exception {  		 	
	        System.out.println("HelloAction.execute is executing..."); 
	        new LoginService().whichUser("0000", "ll");
	        return SUCCESS;  
	 }  
	 
	 public void say() throws IOException{  
	        System.out.println("HelloAction.say is executing....");  
	        response.setContentType("text/html;charset=utf-8");  
	        PrintWriter out = response.getWriter();  
	        out.println("<span style='color:red;'>啊哈，We are here!</span>");  
	        out.close();  
	      
	 }  

}
