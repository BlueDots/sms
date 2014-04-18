package jxau.sms.anping.service;

import java.util.List;
import java.util.Map;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.qing.po.Student;
import jxau.sms.qing.po.Teacher;

public interface YiBaoService extends GlobalServiceInterface {
	public int updateYiBaoByThreeWay(Map<String,List<HosInsuranceInfo>> params);
	public int updateYiBaoByStudent(StuBasicInfo student,HosInsuranceInfo hosInsuranceInfo);
	
}
