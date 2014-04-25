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
		
		
		String[] roleId = (String[])params.get("roleId");//角色编号
		
		System.out.println("roleId:"+roleId[0]);
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
			stuBasicInfoServiceImpl.roleEntry(StuBasicInfo.class, entryLists, "01", roleId[0], null);
			entryStuBasicInfos = entryLists;
		}
		if(roleId[0].equals("2")){
			return "tutor";
		}
		else {
			return "college";
		}
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
	
	public String gainTutorWatingForUpdateNum() {
		String[] teacherNoString=(String[])params.get("teacherNo");
		tutorWatingForUpdateNum = stuBasicInfoServiceImpl.selectTutorWattingForUpdateNum(teacherNoString[0]);
		return SUCCESS;
	}
	
	public String gainTutorWatingForUpdate() {
		String[] teacherNoString=(String[])params.get("teacherNo");
		pageVo = new PageVo();
		pageVo.setCurrentPage(currentPage);
		tutorWatingForUpdateList = stuBasicInfoServiceImpl.selectTutorWattingForUpdate(teacherNoString[0], pageVo);
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
	
	public String verify() {
		String[] idsString=(String[])params.get("ids");
		String[] operationIdString = (String[])params.get("operationId");
		String[] remarksString = (String[])params.get("remarks");
		if(idsString==null || idsString.equals("") || idsString[0] == null || idsString[0].equals("")){
			verifyFlag = false;
			return ERROR;
		}
		
		String[] ids = idsString[0].split(",");
		//id  List
		List<String> idList = new ArrayList<>();
		
		for(int i=0;i<ids.length;i++)
			idList.add(ids[i]);
		String operationId = operationIdString[0];
		String remarks = remarksString[0];
		
		System.out.println(idList);
		System.out.println(operationId);
		System.out.println(remarks);
		
		stuBasicInfoServiceImpl.verify(idList, "01", "3", operationId, remarks);
		
		verifyFlag = true;
		
		return SUCCESS;
	}
	
	public String loadTeacher() {
		TecBasicInfo teacher = (TecBasicInfo) session.get("teacher");
		List<RoleInfo> roles = (List<RoleInfo>) session.get("roles");
		
		RoleInfo role = roles.get(0);
		int flag=0;
		
		if(role.getRoleName().equals("院级工作人员"))
			flag = 3;
		else if(role.getRoleName().equals("班主任")) 
			flag = 2;
		
		System.out.println(flag);
		if(teacher!=null && flag==2){
			session.put("roleId", 2);
			return "tutor";
		}
		else if(teacher!=null && flag==3) {
			session.put("roleId", 3);
			return "college";
		}
		else {
			session.put("roleId", 4);
			return "school";
		}
	}
	
	
	//查询学生基本信息
	@JSON(serialize=false)
	public String queryStuBasicInfoLists() {
		String[] college=(String[])params.get("college");
		String[] major = (String[])params.get("major");
		String[] className = (String[])params.get("className");
		String[] stuNoOrName = (String[])params.get("stuNoOrName");
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(college!=null&&college[0]!=null&&!college[0].trim().equals(""))
			params.put("college", college[0]);
		if(major!=null&&major[0]!=null&&!major[0].trim().equals(""))
			params.put("major", major[0]);
		if(className != null&&className[0]!=null&&!className[0].trim().equals(""))
			params.put("className", className[0]);
		if(stuNoOrName == null||stuNoOrName[0]==null||stuNoOrName[0].equals("输入学号或者姓名")||stuNoOrName[0].trim().equals(""))
			params.put("stuNoOrName",null);
		else params.put("stuNoOrName",stuNoOrName[0]);
		System.out.println(params);
		
		
		pageVo = new PageVo();
	   	//设置当前页数
	   	pageVo.setCurrentPage(currentPage);
	   	pageVo.setSize(5);
	   	
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
	//审核成功的标志
	private Boolean verifyFlag = false;
	
	//待审核信息列表
	private List<StuBasicInfoVO> waitingForLists;
	
	//班主任待修改信息数量
	private long tutorWatingForUpdateNum=0;
	//班主任待修改信息列表
	private List<StuBasicInfo> tutorWatingForUpdateList = null;
	



	private Map<String, Object> session = ActionContext.getContext()
			.getSession();
	private Map<String, Object> params = ActionContext.getContext()
			.getParameters();	

	public List<StuBasicInfo> getTutorWatingForUpdateList() {
		return tutorWatingForUpdateList;
	}	
	
	public long getTutorWatingForUpdateNum() {
		return tutorWatingForUpdateNum;
	}	
	
	public int getWaitingForNum() {
		return waitingForNum;
	}
	
	public Boolean getVerifyFlag() {
		return verifyFlag;
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
