package jxau.sms.chenjiang.activityManage.vo;

import java.util.Date;

import jxau.sms.chenjiang.activityManage.po.ActInfo;

/**
 * 
 * @author 江
 *private String activityLevel;//活动级别
	private String activityName;//活动项目
	private String activityType;//活动类型
	private int actNo;//活动编号
	private Date createTime;//创建时间
	private String exameState;//审核状态
	private String info;//活动描述
	private String organize;//承办方
	private String remarks;//备注
	private String sponsor;//主办方
	private int state;//状态
	private String studentName;//负责学生
	private String teacherName;//负责人
	private String teacherNo;//负责人编号
 */
public class ActInfoVO {
	private ActInfo actInfo;
	private int id;

	public ActInfo getActInfo() {
		return actInfo;
	}

	public int getId() {
		return id;
	}
	public void setActInfo(ActInfo actInfo) {
		this.actInfo = actInfo;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "id:"+id+"\nactInfo:"+actInfo;
	}
	
}
