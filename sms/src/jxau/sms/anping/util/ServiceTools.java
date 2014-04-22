package jxau.sms.anping.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jxau.sms.anping.po.ClassInfo;
import jxau.sms.anping.po.ScholarShip;
import jxau.sms.lyx.po.RoleInfo;

@Component("anpingServiceTools")
public class ServiceTools {
	


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
	 * 判断教师是不是班主任
	 * anping
	 * TODO
	 * 下午7:55:24
	 * @return
	 */
	public boolean checkTeacherIsClassLoader(String className,List<ClassInfo> classes){
		boolean  result=false;
		for(ClassInfo clas:classes){
			if(className.equals(clas.getClassName())){
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
	 * 拿到最高级别的角色
	 * anping
	 * TODO
	 * 下午6:20:07
	 * @return
	 */
	public String getHighLevelRole(List<RoleInfo> roles){
		
		String roleName =null;
		List<String>  roleNames = new ArrayList<String>(6);
		for(RoleInfo roleInfo:roles){
	      	roleNames.add(roleInfo.getRoleName());
	     
	 	}
		roleName = roleNames.contains("班主任")==true?"班主任":null;
		roleName = roleNames.contains("院级工作人员")==true?"院级工作人员":roleName;
		roleName = roleNames.contains("院级管理员")==true?"院级管理员":roleName;
		roleName = roleNames.contains("校级工作人员")==true?"校级工作人员":roleName;
		roleName = roleNames.contains("校级管理员")==true?"校级管理员":roleName;
		return roleName;
	}

}
