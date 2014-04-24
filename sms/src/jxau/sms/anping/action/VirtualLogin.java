package jxau.sms.anping.action;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TeacherRole;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.qing.po.Teacher;

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
			stuBasicInfo.setStudentNo("20111429");
			stuBasicInfo.setAddress("江西人");
			stuBasicInfo.setBankCard("121312312");
			stuBasicInfo.setBirthday(new Date(2011,11,11));
			stuBasicInfo.setClassName("1102");
			stuBasicInfo.setCollege("软件学院");
			stuBasicInfo.setEduBackground("本科");
			stuBasicInfo.setTelephone("23213123");
			stuBasicInfo.setSex(1);
			
			session.setAttribute("student",stuBasicInfo );

			System.out.println("学生已经登陆账号为20111429，详细请见jxau.sms.anping.action.VirtualLogin");
		}
		
		
 
		if(session.getAttribute("teacher")==null){
			TecBasicInfo teacher = new TecBasicInfo();
			//先虚拟的存储这点东西
			teacher.setTeacherNo("1234");
			teacher.setTeacherName("jack");
			session.setAttribute("teacher",teacher);
		    //虚拟的存储一点点角色
			RoleInfo  role  = new RoleInfo();
		    role.setRoleName("班主任");
		    
		     List<RoleInfo> roles= new ArrayList<RoleInfo>(1);
		     roles.add(role);
		    session.setAttribute("roles", roles);
		    System.out.println("以模拟教师登陆");
		}

 
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
