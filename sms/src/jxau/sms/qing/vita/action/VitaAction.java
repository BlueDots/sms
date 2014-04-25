package jxau.sms.qing.vita.action;


import java.util.Map;

import javax.annotation.Resource;

import jxau.sms.qing.po.Student;
import jxau.sms.qing.vita.service.VitaService;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller  
@Scope("prototype")
public class VitaAction extends ActionSupport implements RequestAware,SessionAware{	 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String,Object> request;
	private Map<String,Object> session;
	private VitaService vitaService;
	
	public VitaService getVitaService() {
		return vitaService;
	}
	@Resource(name="vitaService")
	public void setVitaService(VitaService vitaService) {
		this.vitaService = vitaService;
	}
	

	@Override  
	 public String execute() {  		 	
	      // Map req = (Map)ActionContext.getContext().get("request");
	     //  req.put("name", "yfct+=========");
		
		String studentNo = (String) session.get("studentNo");
		request.put("vita", vitaService.VitaInfo(studentNo));
	       System.out.println("mmmmm ==========");
	     //  System.out.println(vitaService.VitaInfo("20111112").getStudentInfo().getStudentName()+"哈哈");
	        
	        return SUCCESS; 
	      
	 }

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	
	
	 
	 
	 

}
