package jxau.sms.util.chenjiang.roleVerify;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import jxau.sms.globaldao.Dao;


@Component("moduleVerifyOperation")
public class ModuleVerifyOperation {
	private Dao dao;
	
	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public <T>  void moduleVerify(List<T> ids,String exameState,String remarks,String moduleId,ModuleVerify mVerify) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(remarks == null) remarks="";
		
		params.put("mVerify", mVerify);
		params.put("exameState", exameState);
		params.put("remarks", remarks);
		params.put("ids", ids);
		dao.update("jxau.sms.util.chenjiang.roleVerify.verify", params);
	}
	
	/**
	 * 得到待审核人数
	 * @param params
	 * @return
	 */
	public int getRoleWaitForVerifyNums(Map<String, Object> params) {
		int num = -1;
		dao.selectOne("jxau.sms.util.chenjiang.roleVerify.getVerifyNums", params);
		
		num = (Integer)params.get("nums");
		
		return num;
	}
	
}
