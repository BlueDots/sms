package jxau.sms.chenjiang.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.chenjiang.stuBasicInfo.service.impl.StuBasicInfoServiceImpl;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;

import org.apache.struts2.json.annotations.JSON;
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
	
	@JSON(serialize=false)
	public String validateStudentNoIsExist() {
		studentNoIsExist = stuBasicInfoServiceImpl.studentNoIsExist(""+studentNo);
		return SUCCESS;
	}
	
	//录入学生基本信息
	@JSON(serialize=false)
	public String entryStuBasicInfoLists() {
		String[] sno=(String[])params.get("sno");//学号
		String[] sname = (String[])params.get("sname");//姓名
		String[] college = (String[])params.get("college");//学院
		String[] major = (String[])params.get("major");//专业
		String[] className = (String[])params.get("className");//班级
		String[] sex = (String[])params.get("sex");//性别
		String[] nation = (String[])params.get("nation");//民族
		String[] hometown = (String[])params.get("birthPlace");//籍贯
		String[] political = (String[])params.get("political");//政治面貌
		String[] IDCard = (String[])params.get("IDCard");//idCard
		String[] bankCard = (String[])params.get("bankCard");//银行卡号
		
		//学生基本信息
		List<StuBasicInfo> entryLists = null;
		
		if(sno!= null) {
			entryLists = new ArrayList<StuBasicInfo>();
			for(int i=0;i<sno.length;i++) {
				StuBasicInfo temp = new StuBasicInfo();
				temp.setStudentNo(sno[i]);
				temp.setStudentName(sname[i]);
				temp.setCollege(college[i]);
				temp.setMajor(major[i]);
				temp.setClassName(className[i]);
				temp.setSex(sex[i].equals("男")?0:1);
				temp.setNation(nation[i]);
				temp.setHometown(hometown[i]);
				temp.setPolitical(political[i]);
				temp.setIdCard(IDCard[i]);
				temp.setBankCard(bankCard[i]);
				entryLists.add(temp);
			}
		}
		
		
		
		if(entryLists!=null) {
			stuBasicInfoServiceImpl.roleEntry(StuBasicInfo.class, entryLists, "01", "3", null);
			entryStuBasicInfos = entryLists;
		}
		return SUCCESS;	
	}
	
	public String gainWaitingForNum() {
		waitingForNum = stuBasicInfoServiceImpl.getWaitingVerifyNums("01", "3");
		return SUCCESS;
	}
	
	public String gainWaitingForClassName() {
		
		Map<String, Object> params = new HashMap<>();
		params.put("exameState", "院级审核中");
		pageVo = new PageVo();
		pageVo.setSize(5);
		pageVo.setCurrentPage(currentPage);
		waitingForClassName = stuBasicInfoServiceImpl.getWaitForClassName(params, pageVo);
		//System.out.println(pageVo.getCount());
		return SUCCESS;
	}
	
	public String gainWaitingForLists() {
		Map<String, Object> params = new HashMap<>();
		params.put("exameState", "院级审核中");
		params.put("className", className);
		pageVo = new PageVo();
		pageVo.setSize(8);
		pageVo.setCurrentPage(currentPage);
		waitingForLists = stuBasicInfoServiceImpl.getWaitingForLists(params, pageVo);
		return SUCCESS;
	}
	
	public String loadTeacher() {
		TecBasicInfo teacher = (TecBasicInfo) session.get("teacher");
		List<RoleInfo> roles = (List<RoleInfo>) session.get("roles");
		
		return SUCCESS;
	}
	
	//查询学生基本信息
	@JSON(serialize=false)
	public String queryStuBasicInfoLists() {
		String[] college=(String[])params.get("college");
		String[] major = (String[])params.get("major");
		String[] className = (String[])params.get("className");
		String[] stuNoOrName = (String[])params.get("stuNoOrName");
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(college==null||college[0]==null||college[0].equals("无")||college[0].trim().equals("")) {
			params.put("college", null);
		}
		else params.put("college", college[0]);
		if(major==null||major[0]==null||major[0].equals("全部")||major[0].trim().equals(""))
			params.put("major", null);
		else params.put("major", major[0]);
		if(className == null||className[0]==null||className[0].equals("全部")||className[0].trim().equals(""))
			params.put("className", null);
		else params.put("className", className[0]);
		if(stuNoOrName == null || stuNoOrName[0]==null||stuNoOrName[0].equals("输入学号或者姓名")||stuNoOrName[0].trim().equals(""))
	   		params.put("stuNoOrName", null);
		else params.put("stuNoOrName",stuNoOrName[0]);
	   	
		
		pageVo = new PageVo();
	   	//设置当前页数
	   	pageVo.setCurrentPage(currentPage);
	   	
	   	
		stuBasicInfoVOlists = stuBasicInfoServiceImpl.searchByAccurate(params, pageVo, 0);
		//System.out.println(lists);
		
		return SUCCESS;
	}
	
	// 获取strtus2 的参数
	private Map<String, Object> parameters = ActionContext.getContext()
			.getParameters();
	
	//当前分页信息
	private PageVo pageVo;
	//学生基本信息VO列表
	private List<StuBasicInfoVO> stuBasicInfoVOlists=null;
	
	//学生基本信息录入信息
	private List<StuBasicInfo> entryStuBasicInfos=null;
	


	//当前页面
	private int currentPage = 0;
	//学号(学号验证)
	private long studentNo;
	//学号是否存在
	private Boolean studentNoIsExist = true;
	//待审核数量
	private int waitingForNum;
	//待审核班级列表
	private List<String> waitingForClassName;
	//待审核班级名称
	private String className;

	//待审核信息列表
	private List<StuBasicInfoVO> waitingForLists;
	
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();
	private Map<String, Object> params = ActionContext.getContext()
			.getParameters();	

	public int getWaitingForNum() {
		return waitingForNum;
	}
	
	public List<StuBasicInfoVO> getWaitingForLists() {
		return waitingForLists;
	}

	public void setClassName(String className) {
		this.className = className;
	}	
	
	public List<String> getWaitingForClassName() {
		return waitingForClassName;
	}
	
	public Boolean getStudentNoIsExist() {
		return studentNoIsExist;
	}

	public void setStudentNo(long studentNo) {
		this.studentNo = studentNo;
	}
		
	public int getCurrentPage() {
		return currentPage;
	}

	
	public PageVo getPageVo() {
		return pageVo;
	}
	
	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}
	
	public List<StuBasicInfo> getEntryStuBasicInfos() {
		return entryStuBasicInfos;
	}
	
	public List<StuBasicInfoVO> getStuBasicInfoVOlists() {
		return stuBasicInfoVOlists;
	}
}
