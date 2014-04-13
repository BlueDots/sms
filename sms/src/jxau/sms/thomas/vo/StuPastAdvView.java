/**
* @package_name   com.stuManSys.advanceInfo.po
* @file_name StuPastAdvInfo.java
* @author Administrator
* @date 2014-3-2
*/

package jxau.sms.thomas.vo;

import java.util.Date;

/** 
 * @ClassName: StuPastAdvInfo
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class StuPastAdvView {

	private String advanceActivity;
	private String advLevel;
	private Date advTime;
	private String remarks;
	
	public String getAdvanceActivity() {
		return advanceActivity;
	}
	public void setAdvanceActivity(String advanceActivity) {
		this.advanceActivity = advanceActivity;
	}
	public String getAdvLevel() {
		return advLevel;
	}
	public void setAdvLevel(String advLevel) {
		this.advLevel = advLevel;
	}
	public Date getAdvTime() {
		return advTime;
	}
	public void setAdvTime(Date advTime) {
		this.advTime = advTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
