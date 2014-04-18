package jxau.sms.anping.service;

import java.util.List;
import java.util.Map;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.globalService.GlobalServiceInterface;

public interface YiBaoService extends GlobalServiceInterface {
	public int updateYiBaoByThreeWay(Map<String,List<HosInsuranceInfo>> params);
}
