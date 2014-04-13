package jxau.sms.chenjiang.vo;

import jxau.sms.chenjiang.po.StuActParticipate;





public class StuActParticipateVO {
	private int id;

	private StuActParticipate stuActParticipate;

	public int getId() {
		return id;
	}

	public StuActParticipate getStuActParticipate() {
		return stuActParticipate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStuActParticipate(StuActParticipate stuActParticipate) {
		this.stuActParticipate = stuActParticipate;
	}
	
	public String toString() {
		return "stuActParticipate"+stuActParticipate;
	}
}
