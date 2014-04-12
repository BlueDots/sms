package jxau.sms.chenjiang.po;

import java.sql.Date;

/**
 * 
 * @author 江
 *活动举办信息
 */
public class ActHold {
	private ActInfo actInfo;//活动编号
	private Date endTime;//结束时间
	private String holdPlace;//场地
	private int id;//活动id
	private int sessionYear;//届数
	private Date startTime;//开始时间
	
	public String toString() {
		return "id:"+id+"\nactInfo:"+actInfo+"\nstartTime:"+startTime+",endTime:"+endTime
				+",sessionYear:"+sessionYear+",holdPlace:"+holdPlace;
	}
	
	public ActInfo getActInfo() {
		return actInfo;
	}
	public Date getEndTime() {
		return endTime;
	}
	public String getHoldPlace() {
		return holdPlace;
	}
	public int getId() {
		return id;
	}
	public int getSessionYear() {
		return sessionYear;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setActInfo(ActInfo actInfo) {
		this.actInfo = actInfo;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public void setHoldPlace(String holdPlace) {
		this.holdPlace = holdPlace;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSessionYear(int sessionYear) {
		this.sessionYear = sessionYear;
	}
	public void setStartTime(Date date) {
		this.startTime = date;
	}
}
