package jxau.sms.chenjiang.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxau.sms.chenjiang.stuBasicInfo.service.impl.StuBasicInfoServiceImpl;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Controller  
@Scope("prototype")
public class StuBasicInfoAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private StuBasicInfoServiceImpl stuBasicInfoServiceImpl;
	


	@Resource(name="stuBasicInfoServiceImpl")
	public void setStuBasicInfoServiceImpl(
			StuBasicInfoServiceImpl stuBasicInfoServiceImpl) {
		this.stuBasicInfoServiceImpl = stuBasicInfoServiceImpl;
	}
	
	public String validateStudentNoIsExist() {
		studentNoIsExist = stuBasicInfoServiceImpl.studentNoIsExist(""+studentNo);
		return SUCCESS;
	}
	
	public String loadTeacher() {
		TecBasicInfo teacher = (TecBasicInfo) session.get("teacher");
		List<RoleInfo> roles = (List<RoleInfo>) session.get("roles");
		
		return SUCCESS;
	}
	
	//查询学生基本信息
	public String getStuBasicInfoLists() {
		
		String[] college=(String[])params.get("college");
		String[] major = (String[])params.get("major");
		String[] className = (String[])params.get("className");
		String[] stuNoOrName = (String[])params.get("stuNoOrName");
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(college[0].equals("无")||college[0]==null||college[0].trim().equals(""))
			params.put("college", null);
		else params.put("college", college[0]);
		if(major[0].equals("全部")||major[0]==null||major[0].trim().equals(""))
			params.put("major", null);
		else params.put("major", major[0]);
		if(className[0].equals("全部")||className[0]==null||className[0].trim().equals(""))
			params.put("className", null);
		else params.put("className", className[0]);
		if(stuNoOrName[0].equals("输入学号或者姓名")||stuNoOrName[0]==null||stuNoOrName[0].trim().equals(""))
	   		params.put("stuNoOrName", null);
		else params.put("stuNoOrName",stuNoOrName[0]);
	   	
	   	//设置当前页数
	   	pageVo.setCurrentPage(currentPage);
	   	
	   	
		stuBasicInfoVOlists = stuBasicInfoServiceImpl.searchByAccurate(params, pageVo, 0);
		//System.out.println(lists);
		
		this.setCurrentPage(currentPage);
		this.setStuBasicInfoVOlists(stuBasicInfoVOlists);
		this.setPageVo(pageVo);
		return SUCCESS;
	}
	
	// 获取strtus2 的参数
	private Map<String, Object> parameters = ActionContext.getContext()
			.getParameters();
	
	private PageVo pageVo= new PageVo();
	//学生基本信息VO列表
	private List<StuBasicInfoVO> stuBasicInfoVOlists=null;
	
	//当前页面
	private int currentPage = 0;
	//学号
	private long studentNo;
	
	public boolean getStudentNoIsExist() {
		return studentNoIsExist;
	}

	public void setStudentNo(long studentNo) {
		this.studentNo = studentNo;
	}

	//学号是否存在
	private boolean studentNoIsExist = true;
	
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();
	private Map<String, Object> params = ActionContext.getContext()
			.getParameters();
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setPageVo(PageVo pageVo) {
		this.pageVo = pageVo;
	}

	public void setStuBasicInfoVOlists(List<StuBasicInfoVO> stuBasicInfoVOlists) {
		this.stuBasicInfoVOlists = stuBasicInfoVOlists;
	}
	
	public PageVo getPageVo() {
		return pageVo;
	}
	
	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}
	
	public List<StuBasicInfoVO> getStuBasicInfoVOlists() {
		return stuBasicInfoVOlists;
	}
}
