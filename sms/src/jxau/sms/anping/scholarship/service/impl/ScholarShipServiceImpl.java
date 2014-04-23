package jxau.sms.anping.scholarship.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Service;

import jxau.sms.abstration.AbstractionService;
import jxau.sms.anping.exception.ParameterNotMatchException;
import jxau.sms.anping.po.ClassInfo;
import jxau.sms.anping.po.DepInfo;
import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.po.ScholarShip;
import jxau.sms.anping.service.ScholarShipService;
import jxau.sms.anping.util.ServiceTools;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.chenjiang.stuBasicInfo.service.impl.StuBasicInfoServiceImpl;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.commom.vo.WaitCheckVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.qing.po.Teacher;
import jxau.sms.util.service.impl.CollegeMajorClassInterface;

/**
 * 　班级奖学金service类 　 　需要提供的方法有这些：
 * １。添加班级奖学金数据(包括批量添加／导入)　[当然该操作需要经过权限模块，在action中自动屏蔽那些没有权限的教师，
 * 　　　　　　但是service层需要做一个特例的排段的是对班主任的判断，如果他的最高的角色是班主任的话，那么他只能够导入自己班级的信息，
 * 　　　其他人只要有这个权限就随便导入。然后就是一些业务逻辑的判断 　　　　]
 * ２。更新学生信息[也是如上，只是需要做一个班主任的判断,然后是其他的业务逻辑的判断]
 * 3.学生可以导出班级中所有的班级奖学金信息[需要判断学生是自己的班级的，使用赖慧强封装的库] 4.普通查询和高级查询 ５。审核，使用陈江封装的库
 * ６。查询某个学生的所有的信息[找出某个学生在校的所有班级奖学金情况]
 * 
 * @author anping 2014-4-21 TODO
 */
@Service("scholarShip")
public class ScholarShipServiceImpl extends AbstractionService implements
		ScholarShipService {

	/**
	 * 添加 需要处理的业务逻辑如下 　１。学号不能为空 　2。学号不能重复[采用学院班级比较studentNo的方式插入]
	 * ３。其他的成绩部分能为空，但四部分中总分不能为空 ４。自动的计算总分
	 * 
	 * ６。统一计算总分排名 ７。统一计算奖学金排名(拿取班级可拿奖的人数)
	 */
	@Override
	public void addSchloarShip(List<ScholarShip> scholarShips,
			TecBasicInfo teacher, List<RoleInfo> roleInfos, String college,
			String className, String term) {
		// 核对学号是不是有null
		if (!tools.checkScholarIsNull(scholarShips)) {
			throw new ParameterNotMatchException(
					"学号或者基准分或者学业课程分不能为空，体育课程（活动）要么全部为空要么全部给分！");
		}

		String checkScore = tools.checkScoreHeFa(scholarShips);
		if (checkScore != null) {
			throw new ParameterNotMatchException("checkScore");
		}
		// 核对是不是有重复的学号
		String checkIsDuipt = tools.checkStudentNoIsDulipe(scholarShips);
		if (checkIsDuipt != null) {
			throw new ParameterNotMatchException(checkIsDuipt);
		}

		// 获取第一个学生的信息用来检测是不是和传过来班级一致

		StuBasicInfo student = studentService.getOneById(scholarShips.get(0)
				.getStudent().getStudentNo());

		// 首先核对是不是班主任。如果是的话，那么需要判断是不是有修改这个班级权利
		String maxLevel = tools.getHighLevelRole(roleInfos);
		if (maxLevel.equals("班主任")) {
			List<ClassInfo> classes = classMajorService.searchClassByTeacher(
					teacher, roleInfos, null, null);
			if (!tools.checkTeacherIsClassLoader(student.getClassName(),
					classes)) {
				throw new ParameterNotMatchException("你已班主任身份登陆，没有权限去修改其它班级");
			}

		} else {
			System.out.println(student.getCollege() + "----"
					+ student.getClassName());
			// 如果不是班主任则判断需要添加的数据是不是一致的
			if (!(student.getCollege().equals(college) && student
					.getClassName().equals(className))) {
				throw new ParameterNotMatchException("你需要添加的班级和你选择的班级不一致，请重新选择");
			}

		}

		// 判断学号是不是都是一个班的
		List<StuBasicInfoVO> stuBasics = studentService
				.getListsByCollegeAndClassName(student.getCollege(),
						student.getClassName());

		String checkStudentIsInClass = tools.checkStudentIsInDataBase(
				scholarShips, stuBasics);

		if (checkStudentIsInClass != null) {
			throw new ParameterNotMatchException(checkStudentIsInClass);
		}

		// 检测记录是不是在数据库中已经存在过了
		String checkRecordIsExists = tools.checkStudentIsInTermRecord(
				scholarShips,
				this.getClassMaxStuentNo(student.getCollege(),
						student.getClassName(), term));

		if (checkRecordIsExists != null) {
			throw new ParameterNotMatchException(checkRecordIsExists);
		}

		// 计算总分和插入term
		tools.computerTotalScoreAndIsertTerm(scholarShips, term);
		// 终于可以添加了

		dao.add(namespace + "addScholarShipByBatch", scholarShips);
		this.doTotalScoreRank(student.getCollege(), student.getClassName(),
				term);
		this.doAwardRand(student.getCollege(), student.getClassName(), term);
	}

	@Override
	public void exportSchloarShip(POIFSFileSystem excelFileSystem,
			TecBasicInfo teacher, List<RoleInfo> roleInfos, String college,
			String className, String term) {

	}

	/**
	 * 更新的业务逻辑如下： 　 1. 只能更新四部分中的成绩 　2. 自动的计算总分
	 * 
	 * ４。统一计算总分排名 ５。统一计算奖学金排名(...) 6.只能修该对应审核中的数据
	 */
	@Override
	public void updateSchloarShip(List<ScholarShip> scholarShips,
			TecBasicInfo teacher, List<RoleInfo> roleInfos) {

		// 核对学期和学号是不是为null
		if (!tools.checkScholarTermIsNull(scholarShips)) {
			throw new ParameterNotMatchException("学期不能为空！");
		}
		String checkScore = tools.checkScoreHeFa(scholarShips);
		if (checkScore != null) {
			throw new ParameterNotMatchException(checkScore);
		}
		// 获取第一个学生的信息用来检测是不是和传过来班级一致
		StuBasicInfo student = studentService.getOneById(scholarShips.get(0)
				.getStudent().getStudentNo());

		// 首先核对是不是班主任。如果是的话，那么需要判断是不是有修改这个班级权利
		String maxLevel = tools.getHighLevelRole(roleInfos);
		if (maxLevel.equals("班主任")) {
			List<ClassInfo> classes = classMajorService.searchClassByTeacher(
					teacher, roleInfos, null, null);
			if (!tools.checkTeacherIsClassLoader(student.getClassName(),
					classes)) {
				throw new ParameterNotMatchException("你已班主任身份登陆，没有权限去修改其它班级");
			}
		}

		// 判断学号是不是都是一个班的
		List<StuBasicInfoVO> stuBasics = studentService
				.getListsByCollegeAndClassName(student.getCollege(),
						student.getClassName());

		String checkStudentIsInClass = tools.checkStudentIsInDataBase(
				scholarShips, stuBasics);

		if (checkStudentIsInClass != null) {
			throw new ParameterNotMatchException(checkStudentIsInClass);
		}

		String  checkHefaState=this.updateForSideScore(scholarShips,roleInfos);
		if(null!=checkHefaState){
			throw new ParameterNotMatchException(checkHefaState);
		}
		System.out.println("111111111111111111");

		tools.computerTotalScoreAndIsertTerm(scholarShips, null);
		dao.batchUpdate(namespace + "updateScholarShipByTeacher", scholarShips);

		this.doTotalScoreRank(student.getCollege(), student.getClassName(),
				scholarShips.get(0).getTerm());
		this.doAwardRand(student.getCollege(), student.getClassName(),
				scholarShips.get(0).getTerm());

	}

	private String updateForSideScore(List<ScholarShip> scholarShips,List<RoleInfo> roleInfos) {
		String result = null;
		for (ScholarShip ship : scholarShips) {
			ScholarShip studentShipInDataBase = this.searchOneByTerm(ship
					.getStudent().getStudentNo(), ship.getTerm());
			 
			   if(studentShipInDataBase==null){
				   result="你需要修改的数据在数据库中不存在";
				   break;
			   }
		      if(!tools.checkRoleIsRight(tools.getHighLevelRole(roleInfos), studentShipInDataBase.getExameState())){
		    	  result="现在不能修改学号为："+ship.getStudent().getStudentNo()+"的学生";
		    	  break;	
		      }
			
			if (ship.getBaseScore() == 0
					&& studentShipInDataBase.getBaseScore() != 0) {
				ship.setBaseScore(studentShipInDataBase.getBaseScore());
			}
			if (ship.getAwardScore() == 0
					&& studentShipInDataBase.getAwardScore() != 0) {
				ship.setAwardScore(studentShipInDataBase.getAwardScore());
			}
			if (ship.getPunishScore() == 0
					&& studentShipInDataBase.getPunishScore() != 0) {
				ship.setPunishScore(studentShipInDataBase.getPunishScore());
			}

			if (ship.getLessonScore() == 0
					&& studentShipInDataBase.getLessonScore() != 0) {
				ship.setLessonScore(studentShipInDataBase.getLessonScore());
			}
			if (ship.getInnovateScore() == 0
					&& studentShipInDataBase.getInnovateScore() != 0) {
				ship.setInnovateScore(studentShipInDataBase.getInnovateScore());
			}

			if (ship.getSkillsScore() == 0
					&& studentShipInDataBase.getSkillsScore() != 0) {
				ship.setSkillsScore(studentShipInDataBase.getSkillsScore());
			}

			if (ship.getSportScore() == 0
					&& studentShipInDataBase.getSportScore() != 0) {
				ship.setSportScore(studentShipInDataBase.getSportScore());
			}

			if (ship.getPhysiqueScore() == 0
					&& studentShipInDataBase.getPhysiqueScore() != 0) {
				ship.setPhysiqueScore(studentShipInDataBase.getPhysiqueScore());
			}
			if (ship.getSportMatchScore() == 0
					&& studentShipInDataBase.getSportMatchScore() != 0) {
				ship.setSportMatchScore(studentShipInDataBase
						.getSportMatchScore());
			}

			if (ship.getManageScore() == 0
					&& studentShipInDataBase.getManageScore() != 0) {
				ship.setManageScore(studentShipInDataBase.getManageScore());
			}

			if (ship.getCultureScore() == 0
					&& studentShipInDataBase.getCultureScore() != 0) {
				ship.setCultureScore(studentShipInDataBase.getCultureScore());
			}

			if (ship.getMediaScore() == 0
					&& studentShipInDataBase.getMediaScore() != 0) {
				ship.setMediaScore(studentShipInDataBase.getMediaScore());
			}

			if (ship.getServiceScore() == 0
					&& studentShipInDataBase.getServiceScore() != 0) {
				ship.setServiceScore(studentShipInDataBase.getServiceScore());
			}

			List<ScholarShip> datas = new ArrayList<ScholarShip>(1);
			datas.add(ship);
			tools.computerTotalScoreAndIsertTerm(datas, null);

		}
		return result;

	}

	/**
	 * 获取所有的班级奖学金的信息 可以通过查询的方式有:通过学院专业班级查询全班数据 通过学号姓名查询数据
	 * 
	 */
	@Override
	public List<ScholarShip> Search(Map<String, Object> param,
			PageVo pageVo, int type) {
		
		param.put("firstIndex", pageVo.getFirstIndex());
		param.put("size",pageVo.getSize() );
		List<ScholarShip> scholars =  dao.select(namespace+"selectScholarShipByCondition", param);
		long  nums = dao.selectOne(namespace+"selectScholarShipByConditionNums", param);
		pageVo.setCount(nums);
		
		return scholars;
	}

	/**
	 * 查询某一个学生的所有的数据
	 */
	@Override
	public List<ScholarShip> searchOneStudent(String studentNo) {
		
		Map<String,Object> params  = new HashMap<String,Object>();
		params.put("studentNo", studentNo);
		
		return dao.select(namespace+"selectScholarShipByCondition", params);
	}

	/**
      *通过角色获取所有的待审核的数据 
      */
	@Override
	public List<WaitCheckVo> getAllWaitCheckData(List<RoleInfo> infos,TecBasicInfo teacher) {
		Map<String,Object> params = new HashMap<String,Object>();
		if(tools.getHighLevelRole(infos).equals("院级工作人员")){
			List<DepInfo> depinfos = classMajorService.searchCollegeByTeacher(teacher, infos);
			params.put("college",depinfos.get(0).getDepartment());
			params.put("exameState","院级审核中");
		}else if(tools.getHighLevelRole(infos).equals("校级工作人员")){
			params.put("exameState","校级审核中");
		}
		
		
		return dao.select(namespace+"getWaitData", params);
	}

	@Override
	public <T> List<T> getWaitingForLists(Map<String, Object> params,
			PageVo pageVo) {
		return null;
	}

	/**
	 * 
	 * anping TODO计算学生总分的所有排名
	 * 
	 * 　首先从数据库中获取所有班级的数据,默认以总分的降序排序，没有并列第一的情况 如果总分相同，那么我先已智育的排序，再以德育排序，再以美育，再以体育
	 * 　如果全部相同就数据库随机() 　　然后就直接将排好序的成绩表明排名，入库 　　可以通过sql语句的存储过程中的游标来实现 下午10:53:32
	 */
	private void doTotalScoreRank(String college, String className, String term) {
		Map<String, Object> params = new HashMap<String, Object>(3);
		params.put("college", college);
		params.put("className", className);
		params.put("term", term);
		dao.select(namespace + "updateTotalScoreRand", params);
	}

	/**
	 * 
	 * anping TODO计算获奖情况　需要获取班级的比例分配情况 下午10:54:32 首先从数据库中获取所有的班级信息的排名和备注的数据
	 * 然后获取该班被分配的比例数据 然后通过遍历是否有挂科情况来分派班级的奖学金
	 * 
	 * @param college
	 * @param className
	 */
	private void doAwardRand(String college, String className, String term) {
		Map<String, Object> params = new HashMap<String, Object>(3);
		params.put("college", college);
		params.put("className", className);
		params.put("term", term);
		dao.selectOne(namespace + "updateAwardRand", params);
	}

	@Override
	public ScholarShip searchOneByTerm(String studentNo, String term) {
		Map<String, Object> params = new HashMap<String, Object>(2);
		params.put("studentNo", studentNo);
		params.put("term", term);
		return dao.selectOne(namespace + "selectSchloarShipByTermAndStudentno",
				params);
	}

	@Resource(name = "collegeMajorClassServiceImpl")
	public void setClassMajorService(
			CollegeMajorClassInterface classMajorService) {
		this.classMajorService = classMajorService;
	}

	@Resource(name = "stuBasicInfoServiceImpl")
	public void setStudentService(StuBasicInfoServiceImpl studentService) {
		this.studentService = studentService;
	}

	@Resource(name = "dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Resource(name = "anpingServiceTools")
	public void setTools(ServiceTools tools) {
		this.tools = tools;
	}

	/**
	 * 
	 * anping TODO 拿到某个班级的某个学期库中学号最大的学生 下午2:04:47
	 * 
	 * @return
	 */
	private List<String> getClassMaxStuentNo(String college, String className,
			String term) {
		Map<String, Object> params = new HashMap<String, Object>(3);
		params.put("college", college);
		params.put("className", className);
		params.put("term", term);
		return dao.select(namespace + "getStudentNoInClass", params);
	}

	private ServiceTools tools;
	private Dao dao;
	private StuBasicInfoServiceImpl studentService;
	private CollegeMajorClassInterface classMajorService;

	private String namespace = "jxau.sms.anping.scholarship.dao.";

	@Override
	public <T> int roleEntry(Class<?> c, Object entryObject, String moduleId,
			String roleId, String level) {
		// TODO Auto-generated method stub
		return 0;
	}

}
