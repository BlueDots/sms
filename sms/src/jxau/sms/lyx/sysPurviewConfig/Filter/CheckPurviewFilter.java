package jxau.sms.lyx.sysPurviewConfig.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.sms.lyx.vo.SessionPurview;


/**
 * 
 * @author lyx
 * 2014-4-23
 * TODO:
 * 	系统权限验证过滤器
 */
public class CheckPurviewFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest  req =(HttpServletRequest)request;
		//如果是.jsp结尾
		if(req.getRequestURI().endsWith(".jsp")){
			//放行
			System.out.println("fangxing");
			chain.doFilter(request, response);
		}else {
			//从session中获取权限信息进行匹配
			System.out.println(req.getRequestURI());
			System.out.println(req.getRequestURL());
			HttpSession session = req.getSession();
			
			SessionPurview sessionPurview = (SessionPurview) session.getAttribute("sessionPurview");
			
			System.out.println(req.getRequestURI());
			System.out.println(req.getRequestURL());
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
