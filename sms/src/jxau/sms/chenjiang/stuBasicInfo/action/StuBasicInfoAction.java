package jxau.sms.chenjiang.stuBasicInfo.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxau.sms.chenjiang.stuBasicInfo.service.impl.StuBasicInfoServiceImpl;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.commom.vo.PageVo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller  
@Scope("prototype")
public class StuBasicInfoAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private StuBasicInfoServiceImpl stuBasicInfoServiceImpl;

	//学生基本信息VO列表
	private List<StuBasicInfoVO> lists = null;
	
	public List<StuBasicInfoVO> getLists() {
		return lists;
	}

	public void setLists(List<StuBasicInfoVO> lists) {
		this.lists = lists;
	}

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
		PageVo pageVo = new PageVo();
		pageVo.setCurrentPage(1);
		
		lists = stuBasicInfoServiceImpl.searchByAccurate(param, pageVo, 0);
		
		return SUCCESS;
	}
	
	

}
