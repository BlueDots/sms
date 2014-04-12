package jxau.sms.anping.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

 
import jxau.sms.anping.student.service.UserService;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;


@Controller  
@Scope("prototype")
public class HelloAction extends ActionSupport implements ServletResponseAware {
    
    private UserService userService;
    
	@Resource(name="userSerivce")  
	 public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private static final long serialVersionUID = -6493858961444458651L; 
	 
	 private HttpServletResponse response;  
	 
	 @Override  
	 public void setServletResponse(HttpServletResponse response) {  
	        this.response = response;  
	  }  
	 
	 
	 
	 public String testProject(){  
	        System.out.println("HelloAction.say is executing....");  
	    
	        System.out.println("---------成共进入action----------------");
	        userService.findUser();
			return SUCCESS;
   
	   }  

}
