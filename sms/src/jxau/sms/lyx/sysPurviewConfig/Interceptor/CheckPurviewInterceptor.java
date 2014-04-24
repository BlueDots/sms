package jxau.sms.lyx.sysPurviewConfig.Interceptor;

import jxau.sms.lyx.po.TecBasicInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 
 * @author lyx
 * 2014-4-23
 * TODO:
 * 	  系统权限验证拦截器
 */
public class CheckPurviewInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//获取当前登陆的用户
		TecBasicInfo teacher = (TecBasicInfo) ActionContext.getContext().getSession().get("teacher");
				
		String actionName = invocation.getProxy().getActionName();
		String namespace = invocation.getProxy().getNamespace();
		
		String url = namespace + actionName;  //当前访问的url
		
		System.out.println(url+"aaaaaaaaaaaaaa");
		/*//如果未登陆
		if(teacher == null) {
			
			//如果正在使用的是登陆功能，就放行
			if(url.startsWith("/login")){
				
				return invocation.invoke();
				
			//如果正在使用的是不是登陆功能，就转到登陆页面	
			}else {
				
				return "loginUI";
				
			}
			
			
		
		//如果已登录	
		}else {
			
			//有权限，就放行
			if(){
				
			}else {
				
				return "purviewErrorUI";
			}
			//没权限，就转到error页面
			
		}*/
		return invocation.invoke();
	}

}
