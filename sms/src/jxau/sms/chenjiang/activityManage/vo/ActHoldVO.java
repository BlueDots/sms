package jxau.sms.chenjiang.activityManage.vo;

import java.util.Date;


/**
 * 
 * @author 江
 *	private String activityName;//活动项目
	private Date endTime;//结束时间
	private String holdPlace;//场地
	private int id;//id -->act_hold
	private int sessionYear;//届数
	private Date startTime;//开始时间
 */
public class ActHoldVO {
	private ActHold actHold;
	private int id;
	
	public String toString() {
		return "id:"+id+"\nactHold:"+actHold;
	}
	
	public ActHold getActHold() {
		return actHold;
	}
	public int getId() {
		return id;
	}
	public void setActHold(ActHold actHold) {
		this.actHold = actHold;
	}
	public void setId(int id) {
		this.id = id;
	}
}
