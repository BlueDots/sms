package jxau.sms.lyx.sysPurviewConfig.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import jxau.sms.lyx.po.PurviewInfo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.lyx.sysPurviewConfig.service.impl.SysPurviewConfigserviceimpl;
import jxau.sms.lyx.vo.SessionPurview;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@Controller  
@Scope("prototype")
public class SysPurviewConfigAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;

	private SysPurviewConfigserviceimpl sysPurviewConfigserviceimpl;
	private Map<String,Object> session; 
	
	@Resource(name="SysPurviewConfigserviceimpl")
	public void setSysPurviewConfigserviceimpl(
			SysPurviewConfigserviceimpl sysPurviewConfigserviceimpl) {
		this.sysPurviewConfigserviceimpl = sysPurviewConfigserviceimpl;
	}

	public String setSessionPurview() throws Exception{ 
		
		Map<String,Object> param = new HashMap<String,Object>();
		TecBasicInfo teacher = new TecBasicInfo();
		teacher = (TecBasicInfo) session.get("teacher");
		
		List<RoleInfo> role = (List<RoleInfo>) session.get("roles");
		
		param.put("roleName", role.get(0).getRoleName());
		param.put("teacherNo", teacher.getTeacherNo());
		
		try{
			
			SessionPurview sessionPurview = sysPurviewConfigserviceimpl.searchByAccurate(param, 0);
			session.put("sessionPurview",sessionPurview);
			
			HttpServletResponse response=ServletActionContext.getResponse();  
		      //以下代码从JSON.java中拷过来的  
		    response.setContentType("text/html"); 
		    response.setCharacterEncoding("utf-8");
			Gson gson = new Gson();		
			PrintWriter out;  
	        out = response.getWriter();  
			List<PurviewInfo> purviewList = sessionPurview.getPurviewInfo();	
			List<PurviewInfo> purviewPid = new ArrayList<PurviewInfo>();
			
			for(int i=0;i<purviewList.size();i++){
				
				if(purviewList.get(i).getPid()==1){
					purviewPid.add(purviewList.get(i));
				}
				
			}
			
			String gsonString = gson.toJson(purviewPid);
			out.print(gsonString);
			out.flush();  
			out.close(); 
			
		}catch(Exception e){
			
			return ERROR;
		}
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}
