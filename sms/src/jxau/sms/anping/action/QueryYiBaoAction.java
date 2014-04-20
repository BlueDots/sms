package jxau.sms.anping.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

import javax.annotation.Resource;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.service.YiBaoService;
import jxau.sms.commom.vo.PageVo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryYiBaoAction extends ActionSupport{

	
	public String queryHosByCondition(){
		String result  = "queryCondition";

		PageVo  pageVo  = new PageVo();
		String[] collarCards = (String[]) parameters.get("collarCard");
		String[] hostates = (String[]) parameters.get("hosState");
	 
		String[] hosTypes = (String[])parameters.get("hosType");
		 
		String[] currentPages = (String[]) parameters.get("currentPage");
		Map<String,Object>   params= new HashMap<String,Object>();
		//把简单查询条件传入
	  
		params.put("collarCard", collarCards!=null&&collarCards[0]!=null?collarCards[0]:null);
		params.put("hosState", hostates!=null&&hostates[0]!=null?hostates[0]:null);
		params.put("hosType", hosTypes!=null&&hosTypes[0]!=null?hosTypes[0]:null);
		//简单查询条件结束
		
		
		pageVo.setCurrentPage(currentPages==null?0:Integer.parseInt(currentPages[0]));
		pageVo.setSize(6);
		List<HosInsuranceInfo> hoss=null;
		
		try {
			hoss = yiBaoService.searchByAccurate(params, pageVo, -1);
			//将数据发给前台去
			
			request.put("pageVo",pageVo);
			request.put("hoss", hoss);
		    request.put("collarCard",params.get("collarCard"));
		    request.put("hosState",params.get("hosState"));
		    request.put("hosType",params.get("hosType"));
		} catch (Exception e) {
			e.printStackTrace();
			result=ERROR;
		}
		

		return result;
	}
	
	public String getAllHosByTeacher(){
		String result="teacherShowHoss";
		PageVo  pageVo  = new PageVo();
		String[] currentPages = (String[]) parameters.get("currentPage");
		String[] hostates = (String[]) parameters.get("hosState");
		String[] departments = (String[])parameters.get("department");
		String[] majors = (String[])parameters.get("major");
		String[] classNames = (String[])parameters.get("className");
		String[] students = (String[]) parameters.get("student");
		
		Map<String,Object>   params= new HashMap<String,Object>();
		//把简单查询条件传入
	 
		
		params.put("college", departments!=null&&departments[0]!=null&&!departments[0].equals("-1")?departments[0]:null);
		params.put("major",majors!=null&&majors[0]!=null&&!majors[0].equals("-1")?majors[0]:null);
		params.put("className",classNames!=null&&classNames[0]!=null&&!classNames[0].equals("-1")?classNames[0]:null);
		if(students!=null && students[0]!=null && !students[0].equals("输入学号或者姓名")){
		
			try {
				Integer.parseInt(students[0]);
				params.put("studentNo", students[0]);
			} catch (NumberFormatException e) {
				params.put("studentName", students[0]);	
			}
			
		}
		
		
		//简单查询条件结束
		
		if(hostates!=null&&hostates[0]!=null){
			String hostate = null;
			try {
				hostate=URLDecoder.decode(URLDecoder.decode(hostates[0], "utf-8"),"utf-8");
				 if(hostate.equals("校级审核中")){
					result = "apply";
				}
			} catch (UnsupportedEncodingException e) {
				 e.printStackTrace();
			}
			
			params.put("hosState", hostate);
		}
		pageVo.setCurrentPage(currentPages==null?0:Integer.parseInt(currentPages[0]));
		pageVo.setSize(1000);
		List<HosInsuranceInfo> hoss=null;
		
		try {
			hoss = yiBaoService.searchByAccurate(params, pageVo, -1);
			//将数据发给前台去
			
			request.put("pageVo",pageVo);
			request.put("hoss", hoss);
		 
		} catch (Exception e) {
			e.printStackTrace();
			result=ERROR;
		}
		
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> request = (Map<String, Object>) ActionContext
			.getContext().get("request");
	private Map<String, Object> parameters = ActionContext.getContext()
			.getParameters();
	private YiBaoService yiBaoService;
	@Resource(name = "yiBaoService")
	public void setYiBaoService(YiBaoService yiBaoService) {
		this.yiBaoService = yiBaoService;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
