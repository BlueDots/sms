/**
* @package_name   com.stuManSys.proption.po
* @file_name ColPropDistribution.java
* @author Administrator
* @date 2014-3-4
*/

package jxau.sms.thomas.po;

import java.util.Date;

/** 
 * @ClassName: ColPropDistribution
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class ColPropDistribution {

	private int departNo;
	private int propNo;
	private int awardNum;
	private Double proposition;
	private Double freProposition;
	private Double SopProposition;
	private Double junProposition;
	private Double senProposition;
	private Date allocateTime;
	private Date startTime;
	private Date endTime;
	private String term;
	
	public int getDepartNo() {
		return departNo;
	}
	public void setDepartNo(int departNo) {
		this.departNo = departNo;
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
	public Double getFreProposition() {
		return freProposition;
	}
	public void setFreProposition(Double freProposition) {
		this.freProposition = freProposition;
	}
	public Double getSopProposition() {
		return SopProposition;
	}
	public void setSopProposition(Double sopProposition) {
		SopProposition = sopProposition;
	}
	public Double getJunProposition() {
		return junProposition;
	}
	public void setJunProposition(Double junProposition) {
		this.junProposition = junProposition;
	}
	public Double getSenProposition() {
		return senProposition;
	}
	public void setSenProposition(Double senProposition) {
		this.senProposition = senProposition;
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
