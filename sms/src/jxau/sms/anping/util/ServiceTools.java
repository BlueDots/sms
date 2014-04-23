package jxau.sms.anping.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jxau.sms.anping.po.ClassInfo;
import jxau.sms.anping.po.ScholarShip;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.lyx.po.RoleInfo;

@Component("anpingServiceTools")
public class ServiceTools {
	/**
	 * 检测分数是否合法
	 * anping TODO 下午4:38:19
	 * 
	 * @param scholarShips
	 * @return
	 */
	public String checkScoreHeFa(List<ScholarShip> scholarShips) {
		String result = null;
		for (ScholarShip ship : scholarShips) {

			if (ship.getBaseScore() < 0 || ship.getBaseScore() > 100) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}
			if (ship.getAwardScore() < 0 || ship.getAwardScore() > 100) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}
			if (ship.getPunishScore() < 0 || ship.getPunishScore() > 100) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}

			if (ship.getLessonScore() < 0 || ship.getLessonScore() > 100) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}
			if (ship.getInnovateScore() < 0 || ship.getInnovateScore() > 100) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}

			if (ship.getSkillsScore() < 0 || ship.getSkillsScore() > 0) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}

			if (ship.getSportScore() < 0 || ship.getSportScore() > 100) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}

			if (ship.getPhysiqueScore() < 0 || ship.getPhysiqueScore() > 100) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}
			if (ship.getSportMatchScore() < 0
					|| ship.getSportMatchScore() > 100) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}

			if (ship.getManageScore() < 0 || ship.getManageScore() > 100) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}

			if (ship.getCultureScore() < 0 || ship.getCultureScore() > 0) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}

			if (ship.getMediaScore() < 0 || ship.getMediaScore() > 100) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}

			if (ship.getServiceScore() < 0 || ship.getServiceScore() > 100) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "的成绩中不能出现小于0和大于100的值";
				break;
			}
		}
		return result;
	}

	/**
	 * 
	 * anping TODO 下午3:25:22
	 */
	public boolean checkScholarTermIsNull(List<ScholarShip> ships) {

		for (ScholarShip ship : ships) {
			if (ship.getTerm() == null
					|| ship.getStudent().getStudentNo() == null) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 计算总分和插入需要插入的学期 anping TODO 上午11:30:05
	 */
	public void computerTotalScoreAndIsertTerm(List<ScholarShip> scholarShips,
			String term) {
		for (ScholarShip ship : scholarShips) {
			ship.setMoralQualityAssessmentScore(ship.getBaseScore()
					+ ship.getAwardScore() - ship.getPunishScore());
			ship.setQualityScore(ship.getLessonScore()
					+ ship.getInnovateScore() + ship.getSkillsScore());
			ship.setSportQualityTotalScore(ship.getSportScore()
					+ ship.getPhysiqueScore() + ship.getSportMatchScore());
			ship.setArtEducationTotalScore(ship.getManageScore()
					+ ship.getCultureScore() + ship.getMediaScore()
					+ ship.getServiceScore());
			if (term != null) {
				ship.setTerm(term);
			}

			ship.setTotalScore(ship.getMoralQualityAssessmentScore() * 0.2
					+ ship.getQualityScore() * 0.6
					+ ship.getSportQualityTotalScore() * 0.05
					+ ship.getArtEducationTotalScore() * 0.15);
			System.out.println(ship.getTotalScore() + "总分－－－－－－－－－－");
		}
	}

	/**
	 * 检测是不是在数据库中已经有了数据记录 anping TODO 上午10:31:01
	 * 
	 * @return
	 */
	public String checkStudentIsInTermRecord(List<ScholarShip> scholarShips,
			List<String> students) {
		String result = null;
		if (students == null || students.size() == 0) {
			return result;
		}

		for (ScholarShip ship : scholarShips) {
			if (students.contains(ship.getStudent().getStudentNo())) {
				result = "学号为:" + ship.getStudent().getStudentNo()
						+ "记录已存在，不能重复添加";
				break;
			}
		}
		return result;
	}

	/**
	 * 测试学生是不是在存在这个班级中 anping TODO 下午10:13:18
	 * 
	 * @return
	 */
	public String checkStudentIsInDataBase(List<ScholarShip> scholarShips,
			List<StuBasicInfoVO> student) {
		String result = null;

		for (ScholarShip ship : scholarShips) {

			if (!this.checkStudentIsInList(ship.getStudent().getStudentNo(),
					student)) {
				result = "学号为:" + ship.getStudent().getStudentNo() + "不存在班级中";
				break;
			}
		}
		return result;
	}

	private boolean checkStudentIsInList(String studentNo,
			List<StuBasicInfoVO> student) {
		boolean flag = false;
		for (StuBasicInfoVO stu : student) {
			if (studentNo.equals(stu.getStudentNo())) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 判断学号是否重复了 anping TODO 下午7:06:23
	 * 
	 * @return
	 */
	public String checkStudentNoIsDulipe(List<ScholarShip> scholarShips) {
		String result = null;
		for (int i = 0; i < scholarShips.size(); i++) {
			for (int k = i + 1; k < scholarShips.size(); k++) {
				if (scholarShips
						.get(i)
						.getStudent()
						.getStudentNo()
						.equals(scholarShips.get(k).getStudent().getStudentNo())) {
					result = "导入的数据中重复的学号为:"
							+ scholarShips.get(i).getStudent().getStudentNo();
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 判断教师是不是班主任 anping TODO 下午7:55:24
	 * 
	 * @return
	 */
	public boolean checkTeacherIsClassLoader(String className,
			List<ClassInfo> classes) {
		boolean result = false;
		for (ClassInfo clas : classes) {
			if (className.equals(clas.getClassName())) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * 判断奖学金中部分属性是不是为null anping 比如　学号不能为null 基准分奖励分惩罚分中基准分不能为null 学业课程分不能为null
	 * 体育课程（活动）分要么一个为null要么全部不为null TODO 上午10:58:49
	 * 
	 * @return
	 */
	public boolean checkScholarIsNull(List<ScholarShip> scholars) {

		boolean flag = false;
		boolean flag2 = false;

		for (ScholarShip scholarShip : scholars) {
			if (scholarShip.getStudent() == null
					|| scholarShip.getStudent().getStudentNo() == null) {
				return false;
			}
			if (scholarShip.getBaseScore() == 0) {
				return false;
			}

			if (scholarShip.getLessonScore() == 0) {
				return false;
			}
			if (!flag && scholarShip.getSportScore() == 0) {
				flag = true;
			}
			if (flag && scholarShip.getSportScore() != 0) {
				return false;
			}

			if (!flag2 && scholarShip.getSportScore() > 0) {
				flag2 = true;
			}

			if (flag2 && scholarShip.getSportScore() == 0) {
				return false;
			}

		}
		return true;
	}

	/**
	 * 拿到最高级别的角色 anping TODO 下午6:20:07
	 * 
	 * @return
	 */
	public String getHighLevelRole(List<RoleInfo> roles) {

		String roleName = null;
		List<String> roleNames = new ArrayList<String>(6);
		for (RoleInfo roleInfo : roles) {
			roleNames.add(roleInfo.getRoleName());

		}
		roleName = roleNames.contains("班主任") == true ? "班主任" : null;
		roleName = roleNames.contains("院级工作人员") == true ? "院级工作人员" : roleName;
		roleName = roleNames.contains("院级管理员") == true ? "院级管理员" : roleName;
		roleName = roleNames.contains("校级工作人员") == true ? "校级工作人员" : roleName;
		roleName = roleNames.contains("校级管理员") == true ? "校级管理员" : roleName;
		return roleName;
	}

}
