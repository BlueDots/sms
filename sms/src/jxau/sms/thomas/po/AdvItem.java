/**
* @package_name   com.stuManSys.advanceInfo.po
* @file_name AdvInfo.java
* @author Administrator
* @date 2014-2-25
*/

package jxau.sms.thomas.po;

import java.util.Date;

/** 
 * @ClassName: AdvInfo
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class AdvItem {

	private int advNo;
	private String advanceActivity;
	private Date createTime;
	private String advLevel;
	private String remarks;
	private int advState;
	
	public int getAdvNo() {
		return advNo;
	}
	public void setAdvNo(int advNo) {
		this.advNo = advNo;
	}
	public String getAdvanceActivity() {
		return advanceActivity;
	}
	public void setAdvanceActivity(String advanceActivity) {
		this.advanceActivity = advanceActivity;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAdvLevel() {
		return advLevel;
	}
	public void setAdvLevel(String advLevel) {
		this.advLevel = advLevel;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getAdvState() {
		return advState;
	}
	public void setAdvState(int advState) {
		this.advState = advState;
	}
	
}
