/**
* @package_name   com.stuManSys.grantInfo.po
* @file_name StuGrant.java
* @author Administrator
* @date 2014-3-2
*/

package jxau.sms.thomas.po;

import java.util.Date;

/** 
 * @ClassName: StuGrant
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class StuGrantInfo {

	private int awardNo;
	private String studentNo;
	private String activityName;
	private String grantProperty;
	private int grantMoney;
	private String grantTime;
	private String examState;
	private String remarks;
	
	public int getGrantMoney() {
		return grantMoney;
	}
	public void setGrantMoney(int grantMoney) {
		this.grantMoney = grantMoney;
	}
	public int getAwardNo() {
		return awardNo;
	}
	public void setAwardNo(int awardNo) {
		this.awardNo = awardNo;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getGrantTime() {
		return grantTime;
	}
	public void setGrantTime(String grantTime) {
		this.grantTime = grantTime;
	}
	public String getExamState() {
		return examState;
	}
	public void setExamState(String examState) {
		this.examState = examState;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getGrantProperty() {
		return grantProperty;
	}
	public void setGrantProperty(String grantProperty) {
		this.grantProperty = grantProperty;
	}
	
}
