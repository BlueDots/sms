/**
* @package_name   com.stuManSys.advanceInfo.po
* @file_name StuAdvance.java
* @author Administrator
* @date 2014-3-2
*/

package jxau.sms.thomas.po;

import java.util.Date;

/** 
 * @ClassName: StuAdvance
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class StuAdvInfo {

	private int awardNo;
	private String studentNo;
	private String advanceActivity;
	private String advLevel;
	private String advTime;
	private String examState;
	private String remarks;
	
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
	public String getAdvanceActivity() {
		return advanceActivity;
	}
	public void setAdvanceActivity(String advanceActivity) {
		this.advanceActivity = advanceActivity;
	}
	public String  getAdvTime() {
		return advTime;
	}
	public void setAdvTime(String advTime) {
		this.advTime = advTime;
	}
	public String getAdvLevel() {
		return advLevel;
	}
	public void setAdvLevel(String advLevel) {
		this.advLevel = advLevel;
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
}
