package jxau.sms.chenjiang.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxau.sms.chenjiang.stuBasicInfo.service.impl.StuBasicInfoServiceImpl;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.commom.vo.PageVo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
	
	public String stuBasicInfoExecute() {
		
		Map<String, Object> param = new HashMap<String, Object>();
	   	param.put("college", "软件学院");
	   	param.put("major", null);
	   	param.put("className", null);
	   	param.put("stuNoOrName", null);
	   	
	   	//设置当前页数
	   	pageVo.setCurrentPage(currentPage);
	   	
	   	
		stuBasicInfoVOlists = stuBasicInfoServiceImpl.searchByAccurate(param, pageVo, 0);
		//System.out.println(lists);
		
		this.setCurrentPage(currentPage);
		this.setStuBasicInfoVOlists(stuBasicInfoVOlists);
		this.setPageVo(pageVo);
		return SUCCESS;
	}
	
	public String queryStuBasicInfoLists() {
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
