/**
* @package_name   com.stuManSys.proption.po
* @file_name SchPropDistribution.java
* @author Administrator
* @date 2014-3-4
*/

package jxau.sms.thomas.po;

import java.util.Date;

/** 
 * @ClassName: SchPropDistribution
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class SchPropDistribution {

	private int auto;
	private int propNo;
	private int awardNum;
	private Double proposition;
	private Date allocateTime;
	private Date startTime;
	private Date endTime;
	private String term;
	
	public int getAuto() {
		return auto;
	}
	public void setAuto(int auto) {
		this.auto = auto;
	}
	public int getPropNo() {
		return propNo;
	}
	public void setPropNo(int propNo) {
		this.propNo = propNo;
	}
	public int getAwardNum() {
		return awardNum;
	}
	public void setAwardNum(int awardNum) {
		this.awardNum = awardNum;
	}
	public Double getProposition() {
		return proposition;
	}
	public void setProposition(Double proposition) {
		this.proposition = proposition;
	}
	public Date getAllocateTime() {
		return allocateTime;
	}
	public void setAllocateTime(Date allocateTime) {
		this.allocateTime = allocateTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
}
