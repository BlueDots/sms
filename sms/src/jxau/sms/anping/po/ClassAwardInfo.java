package jxau.sms.anping.po;
/**
 * 班级奖学金等级
 * @author anping
 * 2014-4-12
 * TODO
 */

public class ClassAwardInfo {
	private int awardNo;//奖学金等级编号
	private String awardLevel;//奖学金等级
	private int awarState;//状态
	public int getAwardNo() {
		return awardNo;
	}
	public void setAwardNo(int awardNo) {
		this.awardNo = awardNo;
	}
	public String getAwardLevel() {
		return awardLevel;
	}
	public void setAwardLevel(String awardLevel) {
		this.awardLevel = awardLevel;
	}
	public int getAwarState() {
		return awarState;
	}
	public void setAwarState(int awarState) {
		this.awarState = awarState;
	}
	
	
}
