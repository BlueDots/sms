package jxau.sms.anping.action;

import java.io.IOException;
import java.sql.Date;
 

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.sms.chenjiang.po.StuBasicInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
 
public class VirtualLogin implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  req =(HttpServletRequest)request;
		HttpSession session  = req.getSession();
		if(session.getAttribute("student")==null){
			StuBasicInfo  stuBasicInfo  = new StuBasicInfo();
			stuBasicInfo.setStudentNo("4610");
			stuBasicInfo.setAddress("江西人");
			stuBasicInfo.setBankCard("121312312");
			stuBasicInfo.setBirthday(new Date(2011,11,11));
			stuBasicInfo.setClassName("1102");
			stuBasicInfo.setCollege("软件学院");
			stuBasicInfo.setEduBackground("本科");
			stuBasicInfo.setTelephone("23213123");
			stuBasicInfo.setSex(1);
			
			session.setAttribute("student",stuBasicInfo );
			
		}
		System.out.println("已经在session中设置了一个学生信息，详细请见jxau.sms.anping.action.VirtualLogin");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
