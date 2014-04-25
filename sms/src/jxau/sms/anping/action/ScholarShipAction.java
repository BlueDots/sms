package jxau.sms.anping.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import jxau.sms.anping.po.ScholarShip;
import jxau.sms.anping.service.ScholarShipService;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.qing.po.Teacher;
import jxau.sms.util.service.impl.CollegeMajorClassInterface;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ScholarShipAction extends ActionSupport {
	
	public String addSchloarShip(){
		String result   = SUCCESS;
		String error  = null;
		String[] studentNos = (String[]) parameters.get("studentNo");  
		String[] terms = (String[]) parameters.get("term");  
		String[] baseScores = (String[]) parameters.get("baseScore");  
		String[] awardScores = (String[]) parameters.get("awardScore");
		String[] punishScores = (String[]) parameters.get("punishScore"); 
		String[] lessonScores = (String[]) parameters.get("lessonScore"); 
		String[] innovateScore = (String[]) parameters.get("innovateScore"); 
		String[] skillsScores = (String[]) parameters.get("skillsScore"); 
		String[] sportScores = (String[]) parameters.get("sportScore"); 
		String[] physiqueScores = (String[]) parameters.get("physiqueScore"); 
		String[] sportMatchScores = (String[]) parameters.get("sportMatchScore"); 
		String[] manageScores = (String[]) parameters.get("manageScore"); 
		String[] cultureScores = (String[]) parameters.get("cultureScore"); 
		String[] mediaScores = (String[]) parameters.get("mediaScore"); 
		String[] serviceScores = (String[]) parameters.get("serviceScore"); 
		String[] deparments = (String[]) parameters.get("department");
	  	String[] className = (String[]) parameters.get("className");
		List<ScholarShip> scholarShipsForadd  =  new  ArrayList<ScholarShip>(6);
		
		try {
			for(int i=0;i<studentNos.length;i++){
			  ScholarShip  ship = new ScholarShip();
			  StuBasicInfo  student   = new StuBasicInfo();
			  student.setStudentNo(studentNos[i]);
			  ship.setTerm(terms[0]);
			  ship.setBaseScore(Double.parseDouble(baseScores[i]));
			  ship.setAwardScore(Double.parseDouble(awardScores[i]));
			  ship.setPunishScore(Double.parseDouble(punishScores[i]));
			  ship.setLessonScore(Double.parseDouble(lessonScores[i]));
			  ship.setInnovateScore(Double.parseDouble(innovateScore[i]));
			  ship.setSkillsScore(Double.parseDouble(skillsScores[i]));
			  ship.setSportScore(Double.parseDouble(sportScores[i]));
			  ship.setPhysiqueScore(Double.parseDouble(physiqueScores[i]));
			  ship.setSportMatchScore(Double.parseDouble(sportMatchScores[i]));
			  ship.setManageScore(Double.parseDouble(manageScores[i]));
			  ship.setCultureScore(Double.parseDouble(mediaScores[i]));
			  ship.setMediaScore(Double.parseDouble(mediaScores[i]));
			  ship.setServiceScore(Double.parseDouble(serviceScores[i]));
			  ship.setStudent(student);
			  scholarShipsForadd.add(ship);
			}
		} catch (NumberFormatException e) {
			 	e.printStackTrace();
			 	result="error";
			 	error=e.getMessage();
		}
		
		
		for(ScholarShip ship:scholarShipsForadd){
			System.out.println(ship.getArtEducationTotalRank());
		}
		 
		TecBasicInfo  teacher =(TecBasicInfo)  session.get("teacher");
		@SuppressWarnings("unchecked")
		List<RoleInfo> roleInfos  =(List<RoleInfo> ) session.get("roles"); 
		try {
			scholarShipService.addSchloarShip(scholarShipsForadd, teacher, roleInfos, deparments==null?null:deparments[0], className==null?null:className[0], terms[0]);
		} catch (Exception e) {
			 e.printStackTrace();
			 error=e.getMessage();
			 result="error";
		 }
		 
		PageVo  pagevo  = new PageVo();
		pagevo.setCurrentPage(1);
		pagevo.setSize(6);
		try {
			scholarShipsForadd=scholarShipService.searchOneClassByOneStudent(scholarShipsForadd.get(0).getStudent().getStudentNo(), pagevo, terms[0]);
		} catch (Exception e) {
			 e.printStackTrace();
			 error=e.getMessage();
			 result="error";
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("className",scholarShipsForadd.get(0).getStudent().getClassName() );
		params.put("term",terms[0]);
		request.put("scholars", scholarShipsForadd);
		request.put("pagevo", pagevo);
		request.put("params", params);
		return result;
	}

	public String querySchloarShipForTeacher() {

		String result = "gaoJiquery";

		String[] deparments = (String[]) parameters.get("department");
		String[] major = (String[]) parameters.get("major");
		String[] className = (String[]) parameters.get("className");
		String[] terms = (String[]) parameters.get("term");
		String[] currentPages = (String[]) parameters.get("currentPage");
		String[] sex = (String[]) parameters.get("sex");
		String[] advLevel = (String[]) parameters.get("advLevel");
		String[] advRank = (String[]) parameters.get("advRank");
		String[] advScore = (String[]) parameters.get("advScore");

		Map<String, Object> params = new HashMap<String, Object>(10);
		if (deparments != null && deparments[0] != null
				&& !deparments[0].equals("-1") && !deparments[0].equals("")) {
			params.put("college", deparments[0]);
		}

		if (major != null && major[0] != null && !major[0].equals("-1")
				&& !major[0].equals("")) {
			params.put("major", major[0]);
		}

		if (className != null && className[0] != null
				&& !className[0].equals("-1") && !className[0].equals("")) {
			params.put("className", className[0]);
		}

		if (terms != null && terms[0] != null) {
			params.put("term", terms[0]);
		}

		if (sex != null && sex[0] != null&& !sex[0].equals("on")) {
			params.put("sex", sex[0]);
		}
		if (advLevel != null && advLevel[0] != null && !advLevel[0].equals("全部")) {
			params.put("rank", advLevel[0]);
		}
		if (advRank != null && advRank[0] != null&& !advRank[0].equals("")) {
			params.put("totalScoreRank", advRank[0]);
		}

		if (advScore != null && advScore[0] != null&& !advScore[0].equals("全部")) {
			params.put("totalScore", advScore[0]);
		}

		int currentPage;
		if (currentPages == null || currentPages[0] == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPages[0]);
		}

		PageVo pageVo = new PageVo();
		pageVo.setCurrentPage(currentPage);
		pageVo.setSize(6);

		List<ScholarShip> scholars = null;

		
		Set<String> keys = params.keySet();
		for(String key:keys){
			System.out.println(key+"---"+params.get(key));
		}
		try {
			 scholars = scholarShipService.queryByGaoJi(params, pageVo);
		} catch (Exception e) {
			request.put("error", e.getMessage());
			e.printStackTrace();
			result = "error";
		}
		request.put("scholars", scholars);
		request.put("pagevo", pageVo);
		request.put("params", params);
		
		return result;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 显示所有的班级奖学金信息 通过教师的角色来获取信息:像班主任只能显示本班的学生信息 　　　　　　　　　　　　像校级工作人员需要显示所有的最前的数据
	 * 像院级工作人员也是显示本院的数据 anping TODO 下午6:58:09
	 * 
	 * @return
	 */
	public String showSchloarShipForTeacher() {
		String result = SUCCESS;
		String[] deparments = (String[]) parameters.get("department");
		String[] major = (String[]) parameters.get("major");
		String[] className = (String[]) parameters.get("className");
		String[] student = (String[]) parameters.get("student");
		String[] terms = (String[]) parameters.get("term");
		String[] currentPages = (String[]) parameters.get("currentPage");
		int currentPage;
		Map<String, Object> params = new HashMap<String, Object>(6);

		if (deparments != null && deparments[0] != null
				&& !deparments[0].equals("-1") && !deparments[0].equals("")) {
			params.put("college", deparments[0]);
		}

		if (major != null && major[0] != null && !major[0].equals("-1")
				&& !major[0].equals("")) {
			params.put("major", major[0]);
		}

		if (className != null && className[0] != null
				&& !className[0].equals("-1") && !className[0].equals("")) {
			params.put("className", className[0]);
		}

		if (student != null && student[0] != null
				&& !student[0].equals("输入学号或者姓名")) {
			try {
				Integer.parseInt(student[0]);
				params.put("studentNo", student[0]);
			} catch (NumberFormatException e) {
				params.put("studentName", student[0]);
			}
		}

		if (terms != null && terms[0] != null) {
			params.put("term", terms[0]);
		}
		if (currentPages == null || currentPages[0] == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPages[0]);
		}

		PageVo pageVo = new PageVo();
		pageVo.setCurrentPage(currentPage);
		pageVo.setSize(6);
		List<ScholarShip> scholars = null;
		try {
			scholars = scholarShipService.Search(params, pageVo, 0);
		} catch (Exception e) {
			request.put("error", e.getMessage());
			result = "error";
		}

		request.put("scholars", scholars);
		request.put("pagevo", pageVo);
		request.put("params", params);
		return result;
	}

	@Resource(name = "scholarShip")
	public void setScholarShipService(ScholarShipService scholarShipService) {
		this.scholarShipService = scholarShipService;
	}

	@Resource(name = "collegeMajorClassServiceImpl")
	public void setClassMajor(CollegeMajorClassInterface classMajor) {
		this.classMajor = classMajor;
	}

	private Map<String, Object> request = (Map<String, Object>) ActionContext
			.getContext().get("request");
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();

	private ScholarShipService scholarShipService;
	private CollegeMajorClassInterface classMajor;
	private Map<String, Object> parameters = ActionContext.getContext()
			.getParameters();

}
