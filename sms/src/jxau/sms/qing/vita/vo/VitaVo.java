package jxau.sms.qing.vita.vo;

import java.util.List;

import jxau.sms.qing.po.Advance;
import jxau.sms.qing.po.Participate;
import jxau.sms.qing.po.Student;

public class VitaVo {
	private Student studentInfo;    //学生简历基本信息
	private Participate participate;   //学生活动
	private List<Advance> advance;     //评优评先 & 奖助学金 
	public Student getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(Student studentInfo) {
		this.studentInfo = studentInfo;
	}
	public Participate getParticipate() {
		return participate;
	}
	public void setParticipate(Participate participate) {
		this.participate = participate;
	}
	public List<Advance> getAdvance() {
		return advance;
	}
	public void setAdvance(List<Advance> advance) {
		this.advance = advance;
	}

	
	
	
}
